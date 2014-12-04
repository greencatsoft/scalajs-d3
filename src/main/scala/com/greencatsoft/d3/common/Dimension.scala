package com.greencatsoft.d3.common

import scala.scalajs.js.annotation.JSExportAll

@JSExportAll
case class Dimension(width: Double, height: Double) {

  def +(dimension: Dimension): Dimension =
    Dimension(width + dimension.width, height + dimension.height)

  def -(dimension: Dimension): Dimension =
    Dimension(width - dimension.width, height - dimension.height)

  def *(ratio: Double): Dimension = Dimension(width * ratio, height * ratio)

  override def toString: String = s"Dimension(width: $width, height: $height)"
}
