package outwatch.extras

import outwatch.Sink
import outwatch.dom.Handlers
import monix.execution.Scheduler.Implicits.global

/**
  * Created by marius on 25/06/17.
  */
object SinkUtil {

  def redirectInto[T](sink1: Sink[T], sink2: Sink[T], otherSinks: Sink[T]*): Sink[T] = {
    val handler = Handlers.createHandler[T]()
    val sinks = Seq(sink1, sink2) ++ otherSinks
    sinks.foreach(_ <-- handler)
    handler
  }
}
