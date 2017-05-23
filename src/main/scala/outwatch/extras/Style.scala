package outwatch.extras

import outwatch.dom.{Attribute, cls}
import rxscalajs.Subject
import rxscalajs.subscription.Subscription

import scalacss.DevDefaults.{StyleSheet, StyleA}

/**
  * Created by marius on 23/05/17.
  */

trait Style {
  type Style <: StyleSheet.Inline

  val defaultStyle: Style
}

object Styles {
  private val styles = Subject[StyleSheet.Inline]()

  def publish(ss: StyleSheet.Inline): Unit = styles.next(ss)

  def subscribe(f: StyleSheet.Inline => Unit): Subscription = styles.subscribe(f)

  trait Published { self: StyleSheet.Inline =>
    publish(self)
  }
}


object StyleAdaptors {
  import scala.language.implicitConversions

  implicit def styleToAttr(styleA: StyleA): Attribute = {
    cls := styleA.htmlClass
  }
}
