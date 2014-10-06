package com.greencatsoft.d3

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSExportAll

import org.scalajs.dom.{ Event, Node }

import com.greencatsoft.d3.common.Point

trait D3 extends js.Object {

  def event: UndefOr[Event] = ???

  def mouse(container: Node): js.Array[Int] = ???

  def touch(container: Node, identifier: String): js.Array[js.Array[Int]] = ???

  def touches(container: Node): js.Array[js.Array[Int]] = ???
}

object D3 {

  import Global.d3

  def mouse(container: Node): Point = {
    val point = d3.mouse(container) ensuring (_.size == 2)
    Point(point(0), point(1))
  }

  def touch(container: Node, identifier: String): Seq[Point] =
    d3.touch(container, identifier).toSeq.map(p => Point(p(0), p(1)))

  def touches(container: Node): Seq[Point] =
    d3.touches(container).toSeq.map(p => Point(p(0), p(1)))
}