package com.greencatsoft.d3.common

case class Dimension(width: Double, height: Double) {

  def delta(dimension: Dimension): Dimension =
    Dimension(width - dimension.width, height - dimension.height)

  def add(dimension: Dimension): Dimension =
    Dimension(width + dimension.width, height + dimension.height)

  override def toString: String = s"Dimension(width: $width, height: $height)"
}
