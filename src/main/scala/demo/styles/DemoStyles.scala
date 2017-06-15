package demo.styles

import outwatch.styles.{ComponentStyle, Styles}


trait LogAreaStyle extends ComponentStyle {

  class Style extends StyleSheet.Inline with MdlStyles {

    import dsl._

    val textfield = style(
      mdl.textfield,
      height(400.px),
      width(400.px).important,
      fontFamily :=! "Courier New",
      fontSize(14.px).important
    )
  }

  object defaultStyle extends Style with Styles.Publish
}



trait TextFieldStyle extends ComponentStyle {

  class Style extends StyleSheet.Inline with MdlStyles {

    import dsl._

    val textfield = style (
      mdl.textfield,
      marginRight(8.px).important
    )

    val textinput = style (
      mdl.textinput
    )

    val textlabel = style (
      mdl.textlabel
    )

    val button = style (
      mdl.button
    )
  }

  object defaultStyle extends Style with Styles.Publish
}

trait TodoModuleStyle extends ComponentStyle {

  class Style extends StyleSheet.Inline with MdlStyles {

    import dsl._

    val textinput = style(
      mdl.textinput
    )

    val textlabel = style(
      mdl.textlabel
    )

    val button = style(
      mdl.button,
      marginLeft(8.px)
    )
  }

  object defaultStyle extends Style with Styles.Publish
}
