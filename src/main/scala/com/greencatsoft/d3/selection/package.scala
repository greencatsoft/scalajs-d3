package com.greencatsoft.d3

import scala.language.implicitConversions
import scala.scalajs.js

import org.scalajs.dom.Node

import com.greencatsoft.d3.selection.{ Selection, SelectionSource }

package object selection {

  type ElementIterator[A <: Node, B] = js.ThisFunction2[A, B, Int, Any]

  import Global.d3
  import svg.{ d3 => d3svg }
  import html.{ d3 => d3html }

  implicit def node2selection[A <: Node, B <: Selection[A, B]](node: A)(implicit d3: SelectionSource[A, B]): B = d3.select(node)
}
