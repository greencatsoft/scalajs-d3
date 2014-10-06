package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.{ HTMLElement, Node, SVGElement }

trait Selection[A <: Node] extends js.Array[A] {

  type ResultType
}

trait SvgSelection extends Selection[SVGElement]
  with SelectionSource[SVGElement, SvgSelection]
  with AttributeHolder[SVGElement]
  with Stylable[SVGElement]
  with PropertyHolder[SVGElement]
  with DataDriven[SVGElement]
  with RemovableContainer[SVGElement]
  with SvgContentEditor {

  override type ResultType = this.type
}

trait HtmlSelection extends Selection[HTMLElement]
  with SelectionSource[HTMLElement, HtmlSelection]
  with AttributeHolder[HTMLElement]
  with Stylable[HTMLElement]
  with PropertyHolder[HTMLElement]
  with DataDriven[HTMLElement]
  with RemovableContainer[HTMLElement]
  with HtmlContentEditor {

  override type ResultType = this.type
}
