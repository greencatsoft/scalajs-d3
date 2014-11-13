package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.math.{ pow, sqrt }
import scala.scalajs.js

import org.scalajs.dom.SVGPoint

case class Point(x: Double, y: Double) {

  def +(point: Point): Point = Point(x + point.x, y + point.y)

  def -(point: Point): Point = this + !point

  def unary_!(): Point = Point(-x, -y)

  def distance(point: Point): Double = {
    val p = this - point
    sqrt(pow(p.x, 2) + pow(p.y, 2))
  }
}

object Point {

  implicit def fromSvgPoint(point: SVGPoint) = Point(point.x, point.y)

  implicit def fromArray(point: js.Array[Double]) = Point(point(0), point(1))

  implicit def toArray(point: Point) = js.Array(point.x, point.y)
}