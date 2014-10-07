package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

trait Appendable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def append(name: String): B = ???

  def append(provider: js.Function0[A]): B = ???

  def insert(name: String, before: String): B = ???

  def insert(name: String, provider: js.Function0[A]): B = ???
}

trait Removable[A <: Node, B <: Selection[A, B]] extends js.Object {

  def remove(): B = ???
}

trait Container[A <: Node, B <: Selection[A, B]] extends Appendable[A, B] with Removable[A, B]
