package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait EventSource[A <: Node] extends js.Object {
  this: Selection[A] =>

  def on[B](event: String): UndefOr[ElementIterator[A, B]]

  def on[B](event: String, listener: ElementIterator[A, B], capture: Boolean = false): ResultType = ???

  def transition(): ResultType = ???

  def interrupt(): ResultType = ???
}
