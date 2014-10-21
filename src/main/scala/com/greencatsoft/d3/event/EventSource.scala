package com.greencatsoft.d3.event

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

import com.greencatsoft.d3.selection.{ ElementIterator, Selection }

trait EventSource[A <: Node, B <: Selection[A, B]] extends js.Object {

  def on(event: String): UndefOr[js.ThisFunction]

  def on[T](event: String, listener: ElementIterator[A, T]): B = ???

  def on[T](event: String, listener: ElementIterator[A, T], capture: Boolean): B = ???

  def transition(): B = ???

  def interrupt(): B = ???
}
