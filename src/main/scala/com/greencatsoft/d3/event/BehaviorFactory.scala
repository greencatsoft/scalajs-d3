package com.greencatsoft.d3.event

import scala.scalajs.js

import org.scalajs.dom.Node

import com.greencatsoft.d3.selection.Selection

trait BehaviorFactory[A <: Node, B <: Selection[A, B]] extends js.Object {

  def drag(): Drag[A, B] = ???
}