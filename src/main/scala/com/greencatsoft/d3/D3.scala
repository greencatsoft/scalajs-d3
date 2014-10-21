package com.greencatsoft.d3

import scala.scalajs.js

import org.scalajs.dom.Node

import com.greencatsoft.d3.event.EventChain
import com.greencatsoft.d3.selection.{ Selection, SelectionSource }

trait D3Api[A <: Node, B <: Selection[A, B]] extends js.Object
  with SelectionSource[A, B] with EventChain[A, B]
