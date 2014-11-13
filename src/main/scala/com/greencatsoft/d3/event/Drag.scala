package com.greencatsoft.d3.event

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.UndefOr.undefOr2ops

import org.scalajs.dom.{ Event, Node, TouchList }

import com.greencatsoft.d3.common.Point
import com.greencatsoft.d3.selection.{ ElementIterator, Selection }

trait Drag[A <: Node, B <: Selection[A, B]] extends EventSource[A, B] {

  def origin[T](): ElementIterator[A, T] = ???

  def origin[T](fn: ElementIterator[A, T]): B = ???
}

trait D3DragEvent extends D3Event[Event] {

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

    def touches: Option[TouchList] = {
      val source = event.sourceEvent.asInstanceOf[js.Dynamic]
      source.touches.asInstanceOf[UndefOr[TouchList]].toOption
    }

    def button: Option[Int] = {
      val source = event.sourceEvent.asInstanceOf[js.Dynamic]
      source.button.asInstanceOf[UndefOr[Int]].toOption
    }
  }
}
