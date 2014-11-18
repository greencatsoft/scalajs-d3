package com.greencatsoft.d3.common

import org.scalajs.dom.{ SVGMatrix, SVGSVGElement }

trait Transformable[A <: Transformable[A]] {

  def matrixTransform(matrix: SVGMatrix)(implicit ownerNode: SVGSVGElement): A
}