package com.greencatsoft.d3.event

import scala.scalajs.js

import org.scalajs.dom.{ Event, Node }

import com.greencatsoft.d3.selection.Selection

@js.native
trait Zoom[A <: Node, B <: Selection[A, B]] extends EventSource[A, B] {

  def translate(): js.Array[Double] = js.native

  def translate(translation: js.Array[Double]): B = js.native

  def scale(): Double = js.native

  def scale(scale: Double): B = js.native

  def scaleExtent(): js.Array[Double] = js.native

  def scaleExtent(extend: js.Array[Double]): B = js.native

  def center(): js.Array[Double] = js.native

  def center(extend: js.Array[Double]): B = js.native

  def x(): Double = js.native

  def x(x: Double): B = js.native

  def y(): Double = js.native

  def y(y: Double): B = js.native

  def size(): js.Array[Double] = js.native

  def size(extend: js.Array[Double]): B = js.native

  def apply(selection: B): B = js.native

  def event(selection: B): B = js.native
}

@js.native
trait D3ZoomEvent extends D3Event[Event] {

  val translate: js.Array[Double] = js.native

  val scale: Double = js.native
}
