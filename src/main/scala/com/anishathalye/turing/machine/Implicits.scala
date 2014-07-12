package com.anishathalye.turing.machine

import scala.language.implicitConversions

trait Implicits {

  final implicit def tuple2Action(tuple: ((String, Char), (String, Char, Direction))): ((State, Symb), (State, Symb, Direction)) = {
    tuple match {
      case ((s, c), (ns, nc, d)) => ((s: State, c: Symb), (ns: State, nc: Symb, d))
    }
  }

  final implicit def char2Symb(char: Char): Symb = Symb(char)

  final implicit def string2State(string: String): State = State(string)

}

object Implicits extends Implicits
