package com.anishathalye.turing.machine

import scala.annotation.tailrec

final class TuringMachine(actions: Map[(State, Symb), (State, Symb, Direction)]) {

  def step(start: (State, Tape)): (State, Tape) = {
    val (state, tape) = start
    if (state == Halt || state == Error) {
      start
    } else {
      val symbol = tape.head
      (actions lift (state, symbol)) match {
        case Some((newState, newSymb, direction)) => {
          (newState, tape write newSymb move direction)
        }
        case None => {
          (Error, tape)
        }
      }
    }
  }

  @tailrec
  def process(start: (State, Tape)): (State, Tape) = {
    val (state, tape) = start
    if (state == Halt || state == Error) start
    else process(step(start))
  }

  @tailrec
  def processWithLimit(steps: Int)(start: (State, Tape)): (State, Tape) = {
    val (state, tape) = start
    if (state == Halt || state == Error || steps <= 0) start
    else processWithLimit(steps - 1)(step(start))
  }

}

object TuringMachine {

  def apply(rules: ((State, Symb), (State, Symb, Direction))*): TuringMachine = {
    new TuringMachine(Map(rules: _*))
  }

}
