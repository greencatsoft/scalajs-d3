package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait AttributeHolder[A <: Node, B <: Selection[A, B]] extends js.Object {

  def attr(name: String, value: Any): B = ???

  def attr[T](name: String, provider: ElementIterator[A, T]): B = ???

  def attr(name: String): UndefOr[String] = ???
}