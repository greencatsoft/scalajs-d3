package com.greencatsoft.d3

import scala.language.implicitConversions
import scala.scalajs.js

import org.scalajs.dom.Node

package object selection {

  type ElementIterator[A <: Node, B] = js.ThisFunction2[A, B, Int, Any]
}
