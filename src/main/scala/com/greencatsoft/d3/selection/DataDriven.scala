package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

trait DataDriven[A <: Node, B <: Selection[A, B]] extends js.Object {

  import DataDriven._

  def data[T](): js.Array[T] = js.native

  def data(values: js.Array[Any]): BoundSelection[A, B] = js.native

  def data[T](values: js.Array[T], key: KeyFunction[T]): BoundSelection[A, B] = js.native

  def data(provider: js.Function1[Any, Any]): BoundSelection[A, B] = js.native

  def data[T](provider: js.Function1[Any, T], key: KeyFunction[T]): BoundSelection[A, B] = js.native

  def datum[T](): UndefOr[T] = js.native

  def datum(value: Any): B = js.native

  def datum[T](value: ElementIterator[A, T]): B = js.native

  def filter(selector: String): B = js.native

  def filter[T](filter: ElementIterator[A, T]): B = js.native

  def sort[T](comparator: js.Function2[T, T, Int]): B = js.native

  def order(): B = js.native
}

object DataDriven {

  type KeyFunction[A] = js.ThisFunction2[Any, A, Int, Any]

  trait BoundSelection[A <: Node, B <: Selection[A, B]] extends js.Object {
    this: B =>

    def enter(): SelectionBuilder[A, B] = js.native

    def exit(): B = js.native
  }

  trait SelectionBuilder[A <: Node, B <: Selection[A, B]] extends Container[A, B]
}