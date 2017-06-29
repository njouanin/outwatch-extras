package outwatch.extras

import monix.reactive.Observable
import monix.execution.Scheduler.Implicits.global
import outwatch.Sink
import outwatch.dom.Handlers

/**
  * Created by marius on 26/06/17.
  */
trait Effects {
  type Effect
  type EffectResult

  type EffectSink = Sink[Effect]
  type EffectResultSource = Observable[EffectResult]

  private val handler = Handlers.createHandler[Effect]()

  val sink: EffectSink = handler

  lazy val sourceSwitch: EffectResultSource = handler.switchMap(effects).share
  lazy val sourceMerge: EffectResultSource = handler.mergeMap(effects).share
  lazy val sourceConcat: EffectResultSource = handler.concatMap(effects).share

  def effects: Effect => Observable[EffectResult]
}
