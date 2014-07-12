package com.anishathalye.turing.machine

class Symb(val representation: Char) {

  override final def toString: String = representation.toString

  override final def equals(other: Any): Boolean = other match {
    case that: Symb => representation == that.representation
    case _          => false
  }

  override final def hashCode: Int = representation.hashCode

}

object Symb {

  def apply(representation: Char): Symb = new Symb(representation)

}

case object Blank extends Symb('-')
