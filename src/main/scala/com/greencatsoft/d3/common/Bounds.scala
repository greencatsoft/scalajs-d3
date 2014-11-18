package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.math.{ max, min }

import org.scalajs.dom.{ ClientRect, SVGMatrix, SVGRect, SVGSVGElement }

case class Bounds(x: Double, y: Double, width: Double, height: Double) extends Transformable[Bounds] {

  def intersects(bounds: Bounds): Boolean = {
    require(bounds != null, "Missing argument 'bounds'.")

    ((x + width > bounds.x && x < bounds.x + bounds.width)
      && (y + height > bounds.y && y < bounds.y + bounds.height))
  }

  def contains(point: Point): Boolean = {
    require(point != null, "Missing argument 'point'.")
    point.x >= x && point.x <= x + width && point.y >= y && point.y <= y + height
  }

  def contains(bounds: Bounds): Boolean = {
    require(bounds != null, "Missing argument 'bounds'.")

    ((x <= bounds.x && x + width >= bounds.x + bounds.width)
      && (y <= bounds.y && y + height >= bounds.y + bounds.height))
  }

  def +(size: Double): Bounds =
    Bounds(x - size, y - size, width + (size * 2), height + (size * 2))

  def +(bounds: Bounds): Bounds = {
    val sx = min(x, bounds.x)
    val sy = min(y, bounds.y)

    val mx = max(x + width, bounds.x + bounds.width)
    val my = max(y + height, bounds.y + bounds.height)

    Bounds(sx, sy, mx - sx, my - sy)
  }

  def +(point: Point): Bounds = {
    val sx = min(x, point.x)
    val sy = min(y, point.y)

    val mx = max(x + width, point.x)
    val my = max(y + height, point.y)

    Bounds(sx, sy, mx - sx, my - sy)
  }

  def location = Point(x, y)

  def center = Point(x + width / 2, y + height / 2)

  def size = Dimension(width, height)

  override def matrixTransform(matrix: SVGMatrix)(implicit ownerNode: SVGSVGElement): Bounds =
    Quad.fromBounds(this).matrixTransform(matrix).bounds

  override def toString(): String = s"Bounds(x: $x, y: $y, width: $width, height: $height)"
}

object Bounds {

  def empty: Bounds = new Bounds(0, 0, 0, 0)

  def empty(location: Point): Bounds = new Bounds(location.x, location.y, 0, 0)

  def merge(bounds: Bounds*): Bounds = bounds match {
    case head :: tail => tail.fold(head)((b1, b2) => b1 + b2)
    case Nil => Bounds.empty
  }

  implicit def svgRect2Bounds(rect: SVGRect) = {
    require(rect != null, "Missing argument 'rect'.")

    Bounds(rect.x, rect.y, rect.width, rect.height)
  }

  implicit def clientRect2Bounds(rect: ClientRect) = {
    require(rect != null, "Missing argument 'rect'.")

    Bounds(rect.left, rect.top, rect.width, rect.height)
  }

  implicit def bounds2Rect(bounds: Bounds)(implicit viewNode: SVGSVGElement) = {
    require(bounds != null, "Missing argument 'bounds'.")

    val rect = viewNode.createSVGRect

    rect.x = bounds.x
    rect.y = bounds.y
    rect.width = bounds.width
    rect.height = bounds.height

    rect
  }
}