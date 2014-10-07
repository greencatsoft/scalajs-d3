package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait PropertyHolder[A <: Node, B <: Selection[A, B]] extends js.Object {
    this: B =>

  def property(name: String): UndefOr[String] = ???

  def property(name: String, value: Any): B = ???

  def property[T](name: String, provider: ElementIterator[A, T]): B = ???

  def property(values: js.Dictionary[String]): B = ???
}
