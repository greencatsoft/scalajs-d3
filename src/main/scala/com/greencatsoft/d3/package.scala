package com.greencatsoft

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.{ GlobalScope, UndefOr }
import scala.scalajs.js.Any.{ jsArrayOps, wrapArray }
import scala.scalajs.js.UndefOr.{ any2undefOrA, undefOr2ops }

import org.scalajs.dom.{ HTMLElement, Node, NodeList, SVGElement }

import com.greencatsoft.d3.D3Api
import com.greencatsoft.d3.selection.{ GenericSelection, HtmlSelection, Selection, SvgSelection }

package object d3 {

  object generic extends D3Provider[Node, GenericSelection] {
    trait D3 extends D3Api[Node, GenericSelection]

    implicit override val d3: D3 = global.d3.asInstanceOf[D3]

    private[d3] override def valid(node: UndefOr[Node]): Boolean = node.isDefined
  }

  object svg extends D3Provider[SVGElement, SvgSelection] {
    trait D3 extends D3Api[SVGElement, SvgSelection]

    implicit override val d3: D3 = global.d3.asInstanceOf[D3]

    private[d3] override def valid(node: UndefOr[Node]): Boolean =
      node.map(_.namespaceURI).filter(_ != null).exists(_.endsWith("svg"))
  }

  object html extends D3Provider[HTMLElement, HtmlSelection] {
    trait D3 extends D3Api[HTMLElement, HtmlSelection]

    implicit override val d3: D3 = global.d3.asInstanceOf[D3]

    private[d3] override def valid(node: UndefOr[Node]): Boolean =
      node.map(_.namespaceURI).filter(_ != null).exists(_.endsWith("html"))
  }

  private[d3] object global extends GlobalScope {
    val d3: D3Api[_, _] = ???
  }

  private[d3] trait D3Provider[A <: Node, B <: Selection[A, B]] {

    implicit val d3: D3Api[A, B]

    implicit def node2selection(elem: A): B = d3.select(elem)

    implicit class D3NodeResult(selection: B) {

      def node: Option[A] = selection.head.headOption.filter(_ != null)

      def nodes: Seq[A] = selection.head
    }

    implicit class D3Element(element: A) {

      def addClass(cls: String): A = {
        d3.select(element).classed(js.Dictionary(cls -> true))
        element
      }

      def removeClass(cls: String): A = {
        d3.select(element).classed(js.Dictionary(cls -> false))
        element
      }

      def hasClass(cls: String): Boolean = d3.select(element).classed(cls)

      def closest(filter: A => Boolean): Option[A] = {
        require(filter != null, "Missing argument 'filter'.")

        def search(node: Node): Option[A] = {
          val result = Some(node) collect {
            case n if n.nodeType == 1 && valid(n) => n.asInstanceOf[A]
          }

          result.find(filter) match {
            case Some(e) => Some(e)
            case None => Option(node.parentNode).map(search(_)).flatten
          }
        }

        search(element)
      }

      def appendClone(elem: A, deepCopy: Boolean = true): A = {
        require(elem != null, "Missing argument 'elem'.")

        def removeId(e: A) {
          d3.select(e).attr("id", null)
          e.childNodes.foreach(removeId(_))
        }

        val clone = elem.cloneNode(deepCopy).asInstanceOf[A]
        removeId(clone)

        element.insertBefore(clone, elem).asInstanceOf[A]
      }
    }

    implicit class D3ElementList(list: NodeList) extends Traversable[A] {

      override def foreach[U](f: A => U): Unit =
        for (i <- 0 until list.length; item = list.item(i) if valid(item)) f(item.asInstanceOf[A])
    }

    private[d3] def valid(node: UndefOr[Node]): Boolean
  }
}
