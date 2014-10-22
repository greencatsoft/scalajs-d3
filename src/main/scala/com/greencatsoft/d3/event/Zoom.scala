package com.greencatsoft.d3.event

import scala.scalajs.js

import org.scalajs.dom.{ Event, Node }

import com.greencatsoft.d3.selection.Selection

trait Zoom[A <: Node, B <: Selection[A, B]] extends EventSource[A, B] {

  def translate(): js.Array[Double] = ???

  def translate(translation: js.Array[Double]): B = ???

  def scale(): Double = ???

  def scale(scale: Double): B = ???

  def scaleExtent(): js.Array[Double] = ???

  def scaleExtent(extend: js.Array[Double]): B = ???

  def center(): js.Array[Double] = ???

  def center(extend: js.Array[Double]): B = ???

  def x(): Double = ???

  def x(x: Double): B = ???

  def y(): Double = ???

  def y(y: Double): B = ???

  def size(): js.Array[Double] = ???

  def size(extend: js.Array[Double]): B = ???

  def apply(selection: B): B = ???

  def event(selection: B): B = ???
}

trait D3ZoomEvent extends D3Event[Event] {

  val translate: js.Array[Double] = ???

  val scale: Double = ???
}
