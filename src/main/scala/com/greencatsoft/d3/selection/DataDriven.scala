package com.greencatsoft.d3.selection

import scala.scalajs.js
import org.scalajs.dom.Node
import scala.scalajs.js.UndefOr

trait DataDriven[A <: Node] extends js.Object {
  this: Selection[_] =>

  import DataDriven._

  def data[B](): js.Array[B] = ???

  def data(values: js.Array[Any]): BoundSelection[A, this.type] = ???

  def data[B](values: js.Array[B], key: KeyFunction[B]): BoundSelection[A, this.type] = ???

  def data(provider: js.Function1[Any, Any]): BoundSelection[A, this.type] = ???

  def data[B](provider: js.Function1[Any, B], key: KeyFunction[B]): BoundSelection[A, this.type] = ???

  def datum[B](): UndefOr[B] = ???

  def datum(value: Any): ResultType = ???

  def datum[B](value: ElementIterator[A, B]): ResultType = ???

  def filter(selector: String): ResultType = ???

  def filter[B](filter: ElementIterator[A, B]): ResultType = ???

  def sort[B](comparator: js.Function2[B, B, Int]): ResultType = ???

  def order(): ResultType = ???
}

object DataDriven {

  type KeyFunction[A] = js.ThisFunction2[Any, A, Int, Any]

  trait BoundSelection[A <: Node, B <: DataDriven[A]] extends js.Object {
    this: B =>

    def enter(): SelectionBuilder[A, this.type] = ???

    def exit(): B = ???
  }

  trait SelectionBuilder[A <: Node, B <: DataDriven[A]] extends Selection[A] with Container[A] {

    override type ResultType = B
  }
}