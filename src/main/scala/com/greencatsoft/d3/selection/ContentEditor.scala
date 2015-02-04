package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.{ HTMLElement, Node }

trait ContentEditor[A <: Node, B <: Selection[A, B]] extends js.Object {

  def text(): UndefOr[String] = js.native

  def text(content: String): B = js.native

  def text[B](provider: ElementIterator[A, B]): B = js.native
}

trait HtmlContentEditor[A <: HTMLElement, B <: Selection[A, B]] extends ContentEditor[A, B] {

  def html(): UndefOr[String] = js.native

  def html(content: String): B = js.native

  def html[A](provider: ElementIterator[HTMLElement, A]): B = js.native
}