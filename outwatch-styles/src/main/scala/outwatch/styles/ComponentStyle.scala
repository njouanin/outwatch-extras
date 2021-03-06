package outwatch.styles

import outwatch.dom.{Attribute, Attributes}

import scala.language.implicitConversions
import scalacss.defaults.Exports.StyleA

/**
  * Created by marius on 23/05/17.
  */
trait ComponentStyle {

  type StyleSheet = scalacss.defaults.Exports.StyleSheet.Inline

  type Style <: StyleSheet

  implicit def styleToAttr(styleA: StyleA): Attribute = {
    Attributes.`class` := styleA.htmlClass
  }
}
