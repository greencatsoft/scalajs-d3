package com.greencatsoft

import scala.scalajs.js.GlobalScope

import com.greencatsoft.d3.D3
import com.greencatsoft.d3.selection.{ HtmlSelectionSource, SvgSelectionSource }

package object d3 {

  type D3Svg = D3 with SvgSelectionSource

  type D3Html = D3 with HtmlSelectionSource

  object Global extends GlobalScope {
    val d3: D3 = ???
  }

  object svg {
    def d3: D3Svg = Global.d3.asInstanceOf[D3Svg]
  }

  object html {
    def d3: D3Html = Global.d3.asInstanceOf[D3Html]
  }
}
