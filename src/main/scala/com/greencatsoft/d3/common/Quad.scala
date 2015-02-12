package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.scalajs.js.annotation.JSExportAll

import org.scalajs.dom.svg.{ Matrix, SVG }

/**
 * DomQuad interface.
 * @see http://dev.w3.org/fxtf/geometry/#dom-domquad
 */
@JSExportAll
case class Quad(p1: Point, p2: Point, p3: Point, p4: Point) extends Transformable[Quad] {
  require(p1 != null, "Missing argument 'p1'.")
  require(p2 != null, "Missing argument 'p2'.")
  require(p3 != null, "Missing argument 'p3'.")
  require(p4 != null, "Missing argument 'p4'.")

  def bounds: Bounds = Bounds(p1.x, p1.y, 0, 0) + p2 + p3 + p4

  override def matrixTransform(matrix: Matrix)(implicit ownerNode: SVG): Quad =
    Quad(
      p1.matrixTransform(matrix),
      p2.matrixTransform(matrix),
      p3.matrixTransform(matrix),
      p4.matrixTransform(matrix))
}

object Quad {

  implicit def fromBounds(bounds: Bounds): Quad = {
    val Bounds(x, y, width, height) = bounds
    Quad(Point(x, y), Point(x + width, y), Point(x + width, y + height), Point(x, y + height))
  }
}
