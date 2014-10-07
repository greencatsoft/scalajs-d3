package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait EventSource[A <: Node, B <: Selection[A, B]] extends js.Object {

  def on[B](event: String): UndefOr[ElementIterator[A, B]]

  def on[B](event: String, listener: ElementIterator[A, B], capture: Boolean = false): B = ???

  def transition(): B = ???

  def interrupt(): B = ???
}
