package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.{ HTMLElement, Node, NodeList, SVGElement }

trait SelectionSource[A <: Node, B <: Selection[A]] extends js.Object {
  this: Selection[A] =>

  def select(selector: String): B = ???

  def select(node: A): B = ???

  def selectAll(selector: String): B = ???

  def selectAll(nodes: js.Array[A]): B = ???

  def selectAll(nodes: NodeList): B = ???

  def selection(): B
}

trait SvgSelectionSource extends SelectionSource[SVGElement, SvgSelection] {
  this: Selection[SVGElement] =>
}

trait HtmlSelectionSource extends SelectionSource[HTMLElement, HtmlSelection] {
  this: Selection[HTMLElement] =>
}