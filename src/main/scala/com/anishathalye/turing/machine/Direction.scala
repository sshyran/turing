package com.anishathalye.turing.machine

sealed abstract class Direction

case object Left extends Direction

case object Right extends Direction

case object Stay extends Direction
