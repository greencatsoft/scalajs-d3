package com.greencatsoft.d3.event

import scala.scalajs.js

import org.scalajs.dom.Node

import com.greencatsoft.d3.selection.Selection

@js.native
trait BehaviorFactory[A <: Node, B <: Selection[A, B]] extends js.Object {

  def drag(): Drag[A, B] = js.native

  def zoom(): Zoom[A, B] = js.native
}