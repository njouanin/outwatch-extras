package outwatch

import rxscalajs.Observable

/**
  * Created by marius on 25/06/17.
  */
package object redux {

  type Handler[A] = Observable[A] with Sink[A]
}
