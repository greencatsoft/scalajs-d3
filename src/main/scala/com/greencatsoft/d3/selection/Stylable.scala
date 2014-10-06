package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

trait Stylable[A <: Node] extends js.Object {
  this: Selection[A] =>

  def classed(name: String): Boolean = ???

  def classed(classes: js.Dictionary[Boolean]): ResultType = ???

  def classed[B](provider: ElementIterator[A, B]): ResultType = ???

  def style(name: String): String = ???

  def style(name: String, value: String): ResultType = ???

  def style(name: String, value: String, priority: Int): ResultType = ???

  def style[B](name: String, provider: ElementIterator[A, B]): ResultType = ???

  def style[B](name: String, provider: ElementIterator[A, B], priority: Int): ResultType = ???

  def style(values: js.Dictionary[String]): ResultType = ???
}
