package com.greencatsoft.d3.event

import scala.scalajs.js
import scala.scalajs.js.Any.jsArrayOps
import scala.scalajs.js.UndefOr
import scala.scalajs.js.UndefOr.undefOr2ops

import org.scalajs.dom.{ Event, Node }

import com.greencatsoft.d3.common.Point
import com.greencatsoft.d3.global.d3
import com.greencatsoft.d3.selection.Selection

trait EventChain[A <: Node, B <: Selection[A, B]] extends js.Object {

  def event: UndefOr[D3Event[_]] = ???

  def mouse(container: Node): UndefOr[js.Array[Double]] = ???

  def touch(container: Node): UndefOr[js.Array[js.Array[Double]]] = ???

  def touch(container: Node, identifier: String): UndefOr[js.Array[js.Array[Double]]] = ???

  def touches(container: Node): UndefOr[js.Array[js.Array[Double]]] = ???

  def behavior: BehaviorFactory[A, B] = ???
}

object EventChain {

  import com.greencatsoft.d3.global.d3

  def event[A <: Event]: Option[A] = d3.event.toOption.map(_.asInstanceOf[A])

  def sourceEvent[A <: Event]: Option[A] = event[D3Event[A]].map(_.sourceEvent.toOption).flatten

  def mouse(container: Node): Option[Point] =
    d3.mouse(container).toOption.map(point => Point(point(0), point(1)))

  def touch(container: Node): Seq[Point] =
    d3.touch(container).toOption.toSeq.flatten.map(p => Point(p(0), p(1)))

  def touch(container: Node, identifier: String): Seq[Point] =
    d3.touch(container, identifier).toOption.toSeq.flatten.map(p => Point(p(0), p(1)))

  def touches(container: Node): Seq[Point] =
    d3.touches(container).toOption.toSeq.flatten.map(p => Point(p(0), p(1)))
}