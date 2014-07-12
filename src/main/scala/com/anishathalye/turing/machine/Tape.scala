package com.anishathalye.turing.machine

case class Tape(left: List[Symb], head: Symb, right: List[Symb]) {

  def move(direction: Direction): Tape = direction match {
    case Left => {
      left match {
        case x :: xs => Tape(xs, x, head :: right)
        case Nil     => Tape(Nil, Blank, head :: right)
      }
    }
    case Right => {
      right match {
        case x :: xs => Tape(head :: left, x, xs)
        case Nil     => Tape(head :: left, Blank, Nil)
      }
    }
    case Stay => this
  }

  def write(symbol: Symb): Tape = Tape(left, symbol, right)

  override def toString: String = {
    val leftString = left.reverse mkString " "
    val rightString = right mkString " "
    val elems = List(leftString, s"[$head]", rightString) filter { _.nonEmpty }
    s"Tape(${elems mkString " "})"
  }

}

object Tape {

  def apply(position: Int)(data: Symb*): Tape = {
    require(0 <= position)
    require(position < data.length)

    val (left, right) = data splitAt position
    Tape(left.reverse.toList, right.head, right.tail.toList)
  }

  def apply(data: Symb*): Tape = {
    if (data.isEmpty) Tape(Nil, Blank, Nil)
    else Tape(Nil, data.head, data.tail.toList)
  }

}
