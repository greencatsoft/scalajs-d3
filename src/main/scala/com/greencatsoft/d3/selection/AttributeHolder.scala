package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait AttributeHolder[A <: Node] extends js.Object {
  this: Selection[A] =>

  def attr(name: String, value: Any): ResultType = ???

  def attr[B](name: String, provider: ElementIterator[A, B]): ResultType = ???

  def attr(name: String): UndefOr[String] = ???
}