package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.Node

trait Container[A <: Node] extends js.Object {
  this: Selection[A] =>

  def append(name: String): ResultType = ???

  def append(provider: js.Function0[A]): ResultType = ???

  def insert(name: String, before: String): ResultType = ???

  def insert(name: String, provider: js.Function0[A]): ResultType = ???
}

trait RemovableContainer[A <: Node] extends Container[A] {
  this: Selection[A] =>

  def remove(): ResultType = ???
}