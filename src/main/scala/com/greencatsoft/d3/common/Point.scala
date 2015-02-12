package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.math.{ pow, sqrt }
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportAll

import org.scalajs.dom.svg
import org.scalajs.dom.svg.{ Matrix, SVG }

@JSExportAll
case class Point(x: Double, y: Double) extends Transformable[Point] {

  def +(point: Point): Point = Point(x + point.x, y + point.y)

  def -(point: Point): Point = this + !point

  def *(ratio: Double): Point = Point(x * ratio, y * ratio)

  def unary_!(): Point = Point(-x, -y)

  def distance(point: Point): Double = {
    val p = this - point
    sqrt(pow(p.x, 2) + pow(p.y, 2))
  }

  override def matrixTransform(matrix: Matrix)(implicit ownerNode: SVG): Point = {
    val p = ownerNode.createSVGPoint

    p.x = x
    p.y = y

    Point.fromSvgPoint(p.matrixTransform(matrix))
  }
}

object Point {

  implicit def fromSvgPoint(point: svg.Point) = Point(point.x, point.y)

  implicit def toSvgPoint(point: Point)(implicit ownerNode: SVG): svg.Point = {
    val p = ownerNode.createSVGPoint

    p.x = point.x
    p.y = point.y

    return p
  }

  implicit def fromArray(point: js.Array[Double]) = Point(point(0), point(1))

  implicit def toArray(point: Point) = js.Array(point.x, point.y)
}