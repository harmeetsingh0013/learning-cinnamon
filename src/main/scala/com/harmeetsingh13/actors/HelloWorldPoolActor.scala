package com.harmeetsingh13.actors

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.routing.RoundRobinPool

/**
  * Created by Harmeet Singh(Taara) on 1/7/17.
  */
class HelloWorldPoolActor extends Actor with ActorLogging {

  override def receive: Receive = {
    case any =>
      Thread.sleep(1000)
      log.info(s"Hello $any")
  }
}

object HelloWorldPoolActor extends App {
  val system = ActorSystem("HelloWorldPoolSystem")
  val ref1 = system.actorOf(RoundRobinPool(5).props(Props[HelloWorldPoolActor]), "HelloPool")

  for (i <- 1 to 10000) ref1 ! "James"
}