package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait PropertyHolder[A <: Node] extends js.Object {
    this: Selection[A] =>

  def property(name: String): UndefOr[String] = ???

  def property(name: String, value: Any): ResultType = ???

  def property[B](name: String, provider: ElementIterator[A, B]): ResultType = ???

  def property(values: js.Dictionary[String]): ResultType = ???
}
