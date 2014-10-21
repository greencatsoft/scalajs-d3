package com.greencatsoft.d3

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node

package object selection {

  type ElementIterator[A <: Node, B] = js.ThisFunction2[A, UndefOr[B], UndefOr[Int], Any]
}
