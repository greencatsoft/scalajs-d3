package com.greencatsoft.d3.common

import scala.language.implicitConversions

import org.scalajs.dom.{ SVGMatrix, SVGPoint, SVGSVGElement }

import com.greencatsoft.d3.common.Point.toSvgPoint

/**
 * DomQuad interface.
 * @see http://dev.w3.org/fxtf/geometry/#dom-domquad
 */
case class Quad(p1: Point, p2: Point, p3: Point, p4: Point) {
  require(p1 != null, "Missing argument 'p1'.")
  require(p2 != null, "Missing argument 'p2'.")
  require(p3 != null, "Missing argument 'p3'.")
  require(p4 != null, "Missing argument 'p4'.")

  def matrixTransform(matrix: SVGMatrix)(implicit ownerNode: SVGSVGElement): Quad = {
    val tx = (p: SVGPoint) => p.matrixTransform(matrix)
    Quad(tx(p1), tx(p2), tx(p2), tx(p2))
  }

  def bounds: Bounds = Bounds(p1.x, p1.y, 0, 0) + p2 + p3 + p4
}

object Quad {

  implicit def fromBounds(bounds: Bounds): Quad = {
    val Bounds(x, y, width, height) = bounds
    Quad(Point(x, y), Point(x + width, y), Point(x + width, y + height), Point(x, y + height))
  }
}
