package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait DataDriven[A <: Node, B <: Selection[A, B]] extends js.Object {

  import DataDriven._

  def data[T](): js.Array[T] = ???

  def data(values: js.Array[Any]): BoundSelection[A, B] = ???

  def data[T](values: js.Array[T], key: KeyFunction[T]): BoundSelection[A, B] = ???

  def data(provider: js.Function1[Any, Any]): BoundSelection[A, B] = ???

  def data[T](provider: js.Function1[Any, T], key: KeyFunction[T]): BoundSelection[A, B] = ???

  def datum[T](): UndefOr[T] = ???

  def datum(value: Any): B = ???

  def datum[T](value: ElementIterator[A, T]): B = ???

  def filter(selector: String): B = ???

  def filter[T](filter: ElementIterator[A, T]): B = ???

  def sort[T](comparator: js.Function2[T, T, Int]): B = ???

  def order(): B = ???
}

object DataDriven {

  type KeyFunction[A] = js.ThisFunction2[Any, A, Int, Any]

  trait BoundSelection[A <: Node, B <: Selection[A, B]] extends js.Object {
    this: B =>

    def enter(): SelectionBuilder[A, B] = ???

    def exit(): B = ???
  }

  trait SelectionBuilder[A <: Node, B <: Selection[A, B]] extends Container[A, B]
}