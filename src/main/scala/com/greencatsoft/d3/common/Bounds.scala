package com.greencatsoft.d3.common

import scala.language.implicitConversions
import scala.math.min
import scala.scalajs.js.annotation.JSExportAll

import org.scalajs.dom.{ ClientRect, SVGRect, SVGSVGElement }

@JSExportAll
case class Bounds(x: Double, y: Double, width: Double, height: Double) {

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

  def grows(size: Double): Bounds =
    Bounds(x - size, y - size, width + (size * 2), height + (size * 2))

  def union(bounds: Bounds): Bounds = {
    val sx = min(x, bounds.x)
    val sy = min(y, bounds.y)

    val mx = min(x + width, bounds.x + bounds.width)
    val my = min(y + height, bounds.y + bounds.height)

    Bounds(sx, sy, mx - sx, my - sy)
  }

  def location = Point(x, y)

  def size = Dimension(width, height)

  override def toString(): String = s"Bounds(x: $x, y: $y, width: $width, height: $height)"
}

object Bounds {

  def empty: Bounds = new Bounds(0, 0, 0, 0)

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