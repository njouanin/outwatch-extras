package outwatch.mdl

import monix.execution.Ack.Continue
import org.scalajs.dom
import outwatch.Sink
import outwatch.dom.{Attributes, InsertHook}

import scala.scalajs.js

/**
  * Created by marius on 11/06/17.
  */
trait Mdl {

  private val upgradeElement = Sink.create[dom.Element] { e =>
    val componentHandler = js.Dynamic.global.componentHandler
    if (!js.isUndefined(componentHandler)) componentHandler.upgradeElement(e)
    Continue
  }

  val material: InsertHook = Attributes.insert --> upgradeElement
}