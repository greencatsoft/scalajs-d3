package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

@js.native
trait Stylable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def classed(name: String): Boolean = js.native

  def classed(name: String, value: Boolean): Boolean = js.native

  // d3-selection-multi required
  def classed(classes: js.Dictionary[Boolean]): B = js.native

  def classed[T](provider: ElementIterator[A, T]): B = js.native

  def style(name: String): String = js.native

  def style(name: String, value: String): B = js.native

  def style(name: String, value: String, priority: Int): B = js.native

  def style[T](name: String, provider: ElementIterator[A, T]): B = js.native

  def style[T](name: String, provider: ElementIterator[A, T], priority: Int): B = js.native

  def style(values: js.Dictionary[String]): B = js.native
}
