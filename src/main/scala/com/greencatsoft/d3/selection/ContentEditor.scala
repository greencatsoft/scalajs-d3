package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Node
import org.scalajs.dom.html.Element

@js.native
trait ContentEditor[A <: Node, B <: Selection[A, B]] extends js.Object {

  def text(): UndefOr[String] = js.native

  def text(content: String): B = js.native

  def text[B](provider: ElementIterator[A, B]): B = js.native
}

@js.native
trait HtmlContentEditor[A <: Element, B <: Selection[A, B]] extends ContentEditor[A, B] {

  def html(): UndefOr[String] = js.native

  def html(content: String): B = js.native

  def html[A](provider: ElementIterator[Element, A]): B = js.native
}