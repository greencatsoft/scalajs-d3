package com.greencatsoft

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.GlobalScope

import org.scalajs.dom.{ HTMLElement, Node, SVGElement }

import com.greencatsoft.d3.D3
import com.greencatsoft.d3.selection.{ HtmlSelection, NodeSelection, Selection, SvgSelection }

package object d3 {

  object global extends GlobalScope {
    val d3: D3Api[_, _] = ???
  }

  object generic {
    trait D3 extends D3Api[Node, NodeSelection]

    implicit val d3: D3 = ???

    implicit class D3Element(elem: Node)
      extends AbstractD3Element[Node, NodeSelection](elem)

    implicit def node2selection(elem: Node): NodeSelection = d3.select(elem)
  }

  object svg {
    trait D3 extends D3Api[SVGElement, SvgSelection]

    implicit val d3: D3 = global.d3.asInstanceOf[D3]

    implicit class D3Element(elem: SVGElement)
      extends AbstractD3Element[SVGElement, SvgSelection](elem)

    implicit def node2selection(elem: SVGElement): SvgSelection = d3.select(elem)
  }

  object html {
    trait D3 extends D3Api[HTMLElement, HtmlSelection]

    implicit val d3: D3 = global.d3.asInstanceOf[D3]

    implicit class D3Element(elem: HTMLElement)
      extends AbstractD3Element[HTMLElement, HtmlSelection](elem)

    implicit def node2selection(elem: HTMLElement): HtmlSelection = d3.select(elem)
  }

  abstract class AbstractD3Element[A <: Node, B <: Selection[A, B]](element: A)(implicit api: D3Api[A, B]) {

    def d3: D3Api[A, B] = api

    def addClass(cls: String): A = {
      d3.select(element).classed(js.Dictionary(cls -> true))
      element
    }

    def removeClass(cls: String): A = {
      d3.select(element).classed(js.Dictionary(cls -> false))
      element
    }

    def hasClass(cls: String): Boolean = d3.select(element).classed(cls)
  }
}
