package com.harmeetsingh13.actors

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.util.Timeout

import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Harmeet Singh(Taara) on 1/7/17.
  */
class HelloWorldSelectionActor extends Actor with ActorLogging {

  override def receive: Receive = {
    case any =>
      Thread.sleep(1000)
      log.info(s"Hello $any")
  }
}

object HelloWorldSelectionActor extends App {

  val system = ActorSystem("HelloWorldSelectionSystem")
  val ref1 = system.actorOf(Props[HelloWorldSelectionActor])
  val ref2 = system.actorSelection(ref1.path)
  val ref3 = system.actorSelection(ref1.path)
  val ref4 = system.actorSelection(ref1.path)
  val ref5 = system.actorSelection(ref1.path)

  Future { for (i <- 1 to 10000) ref1 ! "James" }
  Future { for (i <- 1 to 10000) ref2 ! "Jimmy" }
  Future { for (i <- 1 to 10000) ref3 ! "Foo" }
  Future { for (i <- 1 to 10000) ref4 ! "Bar" }
  Future { for (i <- 1 to 10000) ref5 ! "FooBar" }
}
