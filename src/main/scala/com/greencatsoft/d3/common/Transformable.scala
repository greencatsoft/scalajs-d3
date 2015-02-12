package com.greencatsoft.d3.common

import org.scalajs.dom.svg.{ Matrix, SVG }

trait Transformable[A <: Transformable[A]] {

  def matrixTransform(matrix: Matrix)(implicit ownerNode: SVG): A
}