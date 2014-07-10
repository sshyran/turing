package com.anishathalye.turing.machine

import scala.language.implicitConversions

trait Implicits {

  final implicit def tuple2Action(tuple: ((String, Char), (String, Char, Direction))): ((State, Symbol), (State, Symbol, Direction)) = {
    tuple match {
      case ((s, c), (ns, nc, d)) => ((s: State, c: Symbol), (ns: State, nc: Symbol, d))
    }
  }

  final implicit def char2Symbol(char: Char): Symbol = Symbol(char)

  final implicit def string2State(string: String): State = State(string)

}

object Implicits extends Implicits
