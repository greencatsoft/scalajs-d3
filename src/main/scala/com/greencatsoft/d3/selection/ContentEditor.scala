package com.greencatsoft.d3.selection

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.{ HTMLElement, Node, SVGElement }

trait ContentEditor[A <: Node] extends js.Object {
  this: Selection[A] =>

  def text(): UndefOr[String] = ???

  def text(content: String): ResultType = ???

  def text[B](provider: ElementIterator[A, B]): ResultType = ???
}

trait SvgContentEditor extends ContentEditor[SVGElement] {
  this: Selection[SVGElement] =>
}

trait HtmlContentEditor extends ContentEditor[HTMLElement] {
  this: Selection[HTMLElement] =>

  def html(): UndefOr[String] = ???

  def html(content: String): ResultType = ???

  def html[A](provider: ElementIterator[HTMLElement, A]): ResultType = ???
}