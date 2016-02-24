package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

@js.native
trait AttributeHolder[A <: Node, B <: Selection[A, B]] extends js.Object {

  def attr(name: String, value: Any): B = js.native

  def attr[T](name: String, provider: ElementIterator[A, T]): B = js.native

  def attr(name: String): String = js.native
}