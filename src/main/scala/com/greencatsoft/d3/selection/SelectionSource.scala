package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.{ Node, NodeList }

trait SelectionSource[A <: Node, B <: Selection[A, B]] extends js.Object {

  def select(selector: String): B = ???

  def select(node: A): B = ???

  def selectAll(selector: String): B = ???

  def selectAll(nodes: js.Array[A]): B = ???

  def selectAll(nodes: NodeList): B = ???

  def selection(): B
}
