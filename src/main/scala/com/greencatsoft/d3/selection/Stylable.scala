package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

trait Stylable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def classed(name: String): Boolean = ???

  def classed(classes: js.Dictionary[Boolean]): B = ???

  def classed[T](provider: ElementIterator[A, T]): B = ???

  def style(name: String): String = ???

  def style(name: String, value: String): B = ???

  def style(name: String, value: String, priority: Int): B = ???

  def style[T](name: String, provider: ElementIterator[A, T]): B = ???

  def style[T](name: String, provider: ElementIterator[A, T], priority: Int): B = ???

  def style(values: js.Dictionary[String]): B = ???
}
