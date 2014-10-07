package com.greencatsoft

import scala.scalajs.js.GlobalScope

import org.scalajs.dom.{ HTMLElement, Node, SVGElement }

import com.greencatsoft.d3.D3
import com.greencatsoft.d3.selection.{ HtmlSelection, NodeSelection, SvgSelection }

package object d3 {

  object Global extends GlobalScope {
    type D3Generic = D3[Node, NodeSelection]

    implicit val d3: D3Generic = ???
  }

  object svg {
    type D3Svg = D3[SVGElement, SvgSelection]

    implicit val d3: D3Svg = Global.d3.asInstanceOf[D3Svg]
  }

  object html {
    type D3Html = D3[HTMLElement, HtmlSelection]

    implicit val d3: D3Html = Global.d3.asInstanceOf[D3Html]
  }
}
