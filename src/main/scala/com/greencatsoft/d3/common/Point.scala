package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.math.{ pow, sqrt }
import scala.scalajs.js.annotation.JSExportAll

import org.scalajs.dom.SVGPoint

@JSExportAll
case class Point(x: Double, y: Double) {

  def delta(point: Point): Point = Point(x - point.x, y - point.y)

  def add(point: Point): Point = Point(x + point.x, y + point.y)

  def distance(point: Point): Double = {
    val p = delta(point)
    sqrt(pow(p.x, 2) + pow(p.y, 2))
  }
}

object Point {

  implicit def fromSvgPoint(point: SVGPoint) = Point(point.x, point.y)
}