package com.anishathalye.turing.machine

final case class Tape(position: Int, data: Vector[Symbol]) {

  require(0 <= position)
  require(position < data.length)

  def head: Symbol = data(position)

  def move(direction: Direction): Tape = direction match {
    case Left => {
      if (position > 0) Tape(position - 1, data)
      else Tape(0, Blank +: data)
    }
    case Right => {
      if (position < data.length - 1) Tape(position + 1, data)
      else Tape(position + 1, data :+ Blank)
    }
    case Stay => this
  }

  def write(symbol: Symbol): Tape = {
    val (left, right) = data splitAt position
    Tape(position, left ++ (symbol +: right.tail))
  }

  override def toString: String = {
    val selected = data.zipWithIndex map {
      case (sym, pos) =>
        if (pos == position) s"[$sym]"
        else s" $sym "
    }
    selected mkString " "
  }

}

object Tape {

  def apply(position: Int)(data: Symbol*): Tape = Tape(position, data.toVector)

}
