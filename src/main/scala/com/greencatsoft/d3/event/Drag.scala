package com.greencatsoft.d3.event

import org.scalajs.dom.{ MouseEvent, Node }
import com.greencatsoft.d3.selection.{ ElementIterator, Selection }
import scala.scalajs.js.UndefOr
import com.greencatsoft.d3.common.Point

trait Drag[A <: Node, B <: Selection[A, B]] extends EventSource[A, B] {

  def origin[T](): ElementIterator[A, T] = ???

  def origin[T](fn: ElementIterator[A, T]): B = ???
}

trait D3DragEvent extends D3Event[MouseEvent] {

  val x: UndefOr[Double] = ???

  val y: UndefOr[Double] = ???

  val dx: UndefOr[Double] = ???

  val dy: UndefOr[Double] = ???
}

object Drag {

  implicit class DragEvent(val event: D3DragEvent) {

    def location: Option[Point] =
      for (x <- event.x.toOption; y <- event.y.toOption) yield Point(x, y)

    def delta: Option[Point] =
      for (x <- event.dx.toOption; y <- event.dy.toOption) yield Point(x, y)
  }
}
