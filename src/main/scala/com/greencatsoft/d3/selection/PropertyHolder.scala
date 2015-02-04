package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait PropertyHolder[A <: Node, B <: Selection[A, B]] extends js.Object {
    this: B =>

  def property(name: String): UndefOr[String] = js.native

  def property(name: String, value: Any): B = js.native

  def property[T](name: String, provider: ElementIterator[A, T]): B = js.native

  def property(values: js.Dictionary[String]): B = js.native
}
