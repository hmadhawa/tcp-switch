package com.score.senzswitch.boot

import akka.actor.ActorSystem
import com.score.senzswitch.actors.SenzListenerActor
import com.score.senzswitch.utils.SenzFactory
import org.slf4j.LoggerFactory

/**
  * Created by eranga on 1/9/16.
  */
object Main extends App {

  // setup logging
  SenzFactory.setupLogging

  val logger = LoggerFactory.getLogger(this.getClass)
  logger.info("Booting application")

  // setup keys
  SenzFactory.setupKeys

  // start actor
  implicit val system = ActorSystem("senz")
  system.actorOf(SenzListenerActor.props, name = "SenzListener")
}
