package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.{ Node, NodeList }

@js.native
trait SelectionSource[A <: Node, B <: Selection[A, B]] extends js.Object {

  def select(selector: String): B = js.native

  def select(node: A): B = js.native

  def selectAll(selector: String): B = js.native

  def selectAll(nodes: js.Array[A]): B = js.native

  def selectAll(nodes: NodeList): B = js.native

  def selection(): B = js.native

  def empty(): Boolean = js.native

  def node(): A = js.native

  def nodes(): js.Array[A] = js.native

  def size(): Int = js.native
}
