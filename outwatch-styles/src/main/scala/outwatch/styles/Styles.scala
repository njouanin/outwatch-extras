package outwatch.styles

import monix.execution.Ack.{Continue, Stop}
import monix.execution.{Ack, Cancelable}
import monix.reactive.subjects.PublishSubject
import monix.execution.Scheduler.Implicits.global

import scala.concurrent.Future
import scalacss.defaults.Exports.StyleSheet

/**
  * Created by marius on 11/06/17.
  */
object Styles {
  private val styles = PublishSubject[StyleSheet.Inline]()

  private var published: Future[Ack] = Future.successful(Continue)

  def publish(ss: StyleSheet.Inline): Future[Ack] = {
    published.synchronized {
      published = published.flatMap {
        case Continue =>
          styles.onNext(ss)
        case Stop =>
          Stop
      }
    }
    published
  }

  def subscribe(f: StyleSheet.Inline => Unit): Cancelable = {
    styles.subscribe { s =>
      f(s)
      Continue
    }
  }

  trait Publish { self: StyleSheet.Inline =>
    publish(self)
  }

}
