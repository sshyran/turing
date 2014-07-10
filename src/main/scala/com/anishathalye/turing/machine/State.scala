package com.anishathalye.turing.machine

class State(val representation: String) {

  override final def toString: String = representation.toString

  override final def equals(other: Any): Boolean = other match {
    case that: State => representation == that.representation
    case _           => false
  }

  override final def hashCode: Int = representation.hashCode

}

object State {

  def apply(representation: String): State = new State(representation)

}

case object Halt extends State("halt")

case object Error extends State("error")
