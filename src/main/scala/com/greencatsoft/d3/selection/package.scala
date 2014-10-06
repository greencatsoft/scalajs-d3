package com.greencatsoft.d3

import scala.language.implicitConversions
import scala.scalajs.js

import org.scalajs.dom.{ HTMLElement, Node, SVGElement }

import com.greencatsoft.d3.selection.{ HtmlSelection, SvgSelection }

package object selection {

  type ElementIterator[A <: Node, B] = js.ThisFunction2[A, B, Int, Any]

  implicit def node2selection(node: HTMLElement): HtmlSelection = html.d3.select(node)

  implicit def node2selection(node: SVGElement): SvgSelection = svg.d3.select(node)
}
