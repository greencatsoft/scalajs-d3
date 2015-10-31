package com.greencatsoft.d3.event

import scala.scalajs.js
import scala.scalajs.js.UndefOr

import org.scalajs.dom.Event

@js.native
trait D3Event[A <: Event] extends Event {

  val sourceEvent: UndefOr[A] = js.native
}