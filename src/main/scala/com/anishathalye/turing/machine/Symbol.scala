package com.anishathalye.turing.machine

class Symbol(val representation: Char) {

  override final def toString: String = representation.toString

  override final def equals(other: Any): Boolean = other match {
    case that: Symbol => representation == that.representation
    case _            => false
  }

  override final def hashCode: Int = representation.hashCode

}

object Symbol {

  def apply(representation: Char): Symbol = new Symbol(representation)

}

case object Blank extends Symbol('-')
