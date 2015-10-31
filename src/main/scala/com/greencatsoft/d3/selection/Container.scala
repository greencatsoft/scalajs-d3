package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

@js.native
trait Appendable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def append(name: String): B = js.native

  def append(provider: js.Function0[A]): B = js.native

  def insert(name: String, before: String): B = js.native

  def insert(name: String, provider: js.Function0[A]): B = js.native
}

@js.native
trait Removable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def remove(): B = js.native
}

@js.native
trait Container[A <: Node, B <: Selection[A, B]] extends Appendable[A, B] with Removable[A, B]
