package com.greencatsoft.d3.selection

import scala.scalajs.js

import org.scalajs.dom.{ HTMLElement, Node, SVGElement }

trait Selection[A <: Node, B <: Selection[A, B]] extends js.Array[A]
  with SelectionSource[A, B]
  with AttributeHolder[A, B]
  with Stylable[A, B]
  with PropertyHolder[A, B]
  with DataDriven[A, B]
  with Container[A, B]
  with EventSource[A, B]
  with ContentEditor[A, B] {
  this: B =>
}

trait NodeSelection extends Selection[Node, NodeSelection]

trait SvgSelection extends Selection[SVGElement, SvgSelection]

trait HtmlSelection extends Selection[HTMLElement, HtmlSelection]
  with HtmlContentEditor[HTMLElement, HtmlSelection]
