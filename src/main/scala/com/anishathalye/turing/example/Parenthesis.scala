package com.anishathalye.turing.example

import com.anishathalye.turing.machine._
import Implicits._

import java.util.Scanner

object Parenthesis {

  val balancer = TuringMachine(
    ("1", '-') -> ("halt", '1', Stay),
    ("1", '(') -> ("2", '{', Right),
    ("1", ')') -> ("halt", '0', Stay),
    ("1", '<') -> ("1", '>', Left),
    ("1", '>') -> ("1", '<', Right),

    ("2", '(') -> ("2", '[', Right),
    ("2", ')') -> ("2", '>', Left),
    ("2", '[') -> ("2", '<', Right),
    ("2", '-') -> ("halt", '0', Stay),
    ("2", '{') -> ("1", '<', Right),
    ("2", '<') -> ("2", '>', Left),
    ("2", '>') -> ("2", '<', Right)
  )

  def isBalanced(parens: String): Boolean = {
    if (parens.nonEmpty && (parens forall { c => c == '(' || c == ')' })) {
      val input = Tape((parens map { Symb(_) }): _*)
      val (state, tape) = balancer process ("1", input)
      tape.head == Symb('1')
    } else {
      false
    }
  }

  def main(args: Array[String]) {
    println("Enter parenthesis to check:")
    val scanner = new Scanner(System.in)
    print("> ")
    while (scanner.hasNextLine()) {
      if (isBalanced(scanner.nextLine())) {
        println("Balanced!")
      } else {
        println("Not balanced.")
      }
      print("> ")
    }
  }

}
