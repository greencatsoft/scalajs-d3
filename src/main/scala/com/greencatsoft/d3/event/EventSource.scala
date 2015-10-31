package com.greencatsoft.d3.event

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

import com.greencatsoft.d3.selection.{ ElementIterator, Selection }

@js.native
trait EventSource[A <: Node, B <: Selection[A, B]] extends js.Object {

  def on(event: String): UndefOr[js.ThisFunction] = js.native

  def on[T](event: String, listener: ElementIterator[A, T]): B = js.native

  def on[T](event: String, listener: ElementIterator[A, T], capture: Boolean): B = js.native

  def transition(): B = js.native

  def interrupt(): B = js.native
}
