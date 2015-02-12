package com.greencatsoft.d3.event

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.UndefOr.undefOr2ops

import org.scalajs.dom.{ Event, Node, TouchList }
import org.scalajs.dom.ext.Castable

import com.greencatsoft.d3.common.Point
import com.greencatsoft.d3.selection.{ ElementIterator, Selection }

trait Drag[A <: Node, B <: Selection[A, B]] extends EventSource[A, B] {

  def origin[T](): ElementIterator[A, T] = js.native

  def origin[T](fn: ElementIterator[A, T]): B = js.native
}

trait D3DragEvent extends D3Event[Event] {

  val x: UndefOr[Double] = js.native

  val y: UndefOr[Double] = js.native

  val dx: UndefOr[Double] = js.native

  val dy: UndefOr[Double] = js.native
}

object Drag {

  implicit class DragEvent(val event: D3DragEvent) {

    def location: Option[Point] =
      for (x <- event.x.toOption; y <- event.y.toOption) yield Point(x, y)

    def delta: Option[Point] =
      for (x <- event.dx.toOption; y <- event.dy.toOption) yield Point(x, y)

    def touches: Option[TouchList] = {
      val source = event.sourceEvent.cast[js.Dynamic]
      source.touches.cast[UndefOr[TouchList]].toOption
    }

    def button: Option[Int] = {
      val source = event.sourceEvent.cast[js.Dynamic]
      source.button.cast[UndefOr[Int]].toOption
    }
  }
}
