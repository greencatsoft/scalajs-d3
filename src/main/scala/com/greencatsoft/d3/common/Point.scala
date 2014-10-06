package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.math.{ pow, sqrt }

import org.scalajs.dom.SVGPoint

case class Point(x: Double, y: Double) {

  def delta(point: Point): Point = Point(x - point.x, y - point.y)

  def add(point: Point): Point = Point(x + point.x, y + point.y)

  def distance(point: Point): Double = {
    val Point(dx, dy) = delta(point)
    sqrt(pow(dx, 2) + pow(dy, 2))
  }
}

object Point {

  implicit def fromSvgPoint(point: SVGPoint) = Point(point.x, point.y)
}