package com.greencatsoft.d3

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.{ Event, Node }

import com.greencatsoft.d3.common.Point
import com.greencatsoft.d3.selection.{ Selection, SelectionSource }

trait D3Api[A <: Node, B <: Selection[A, B]] extends js.Object with SelectionSource[A, B] {

  def event: UndefOr[Event] = ???

  def mouse(container: Node): js.Array[Double] = ???

  def touch(container: Node, identifier: String): js.Array[js.Array[Double]] = ???

  def touches(container: Node): js.Array[js.Array[Double]] = ???
}

object D3 {

  import global.d3

  def event[A <: Event]: Option[A] = d3.event.toOption.map(_.asInstanceOf[A])

  def mouse(container: Node): Point = {
    val point = d3.mouse(container) ensuring (_.size == 2)
    Point(point(0), point(1))
  }

  def touch(container: Node, identifier: String): Seq[Point] =
    d3.touch(container, identifier).toSeq.map(p => Point(p(0), p(1)))

  def touches(container: Node): Seq[Point] =
    d3.touches(container).toSeq.map(p => Point(p(0), p(1)))
}
