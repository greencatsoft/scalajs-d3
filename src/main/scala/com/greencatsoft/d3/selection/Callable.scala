package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

@js.native
trait Callable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def call(fn: Any): B = js.native
}