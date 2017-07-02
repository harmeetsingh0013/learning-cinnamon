package com.harmeetsingh13.actors

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

/**
  * Created by Harmeet Singh(Taara) on 1/7/17.
  */
class HelloWorldActor extends Actor with ActorLogging {

  override def receive: Receive = {
    case any =>
      Thread.sleep(1000)
      log.info(s"Hello $any")
  }
}

object HelloWorldActor extends App {

  val system = ActorSystem("HelloWorldSystem")
  val ref1 = system.actorOf(Props[HelloWorldSelectionActor])

  for (i <- 1 to 10000) ref1 ! "James"
}
