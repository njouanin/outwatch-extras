package outwatch

import monix.reactive.Observable

/**
  * Created by marius on 25/06/17.
  */
package object extras {

  type Handler[A] = Observable[A] with Sink[A]
}
