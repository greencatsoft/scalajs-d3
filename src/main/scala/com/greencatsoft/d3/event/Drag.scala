package com.greencatsoft.d3.event

import org.scalajs.dom.{ MouseEvent, Node }

import com.greencatsoft.d3.selection.{ ElementIterator, Selection }

trait Drag[A <: Node, B <: Selection[A, B]] extends EventSource[A, B] {

  def origin[T](): ElementIterator[A, T] = ???

  def origin[T](fn: ElementIterator[A, T]): B = ???
}

trait DragStartEvent extends D3Event[MouseEvent]

trait DragEvent extends D3Event[MouseEvent] {

  val x: Double = ???

  val y: Double = ???

  val dx: Double = ???

  val dy: Double = ???
}

trait DragEndEvent extends D3Event[MouseEvent]