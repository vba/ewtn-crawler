package org.bartel.ewtn.crawler

import rx.lang.scala.Observable
import rx.lang.scala.schedulers.IOScheduler

object App {
    def main(args: Array[String]): Unit = {
        val readings = Observable
            .from(DatesProvider.provide())
            .observeOn(IOScheduler.apply())
            .flatMap(ReadingsClient.instance.getReading)
            .map(ReadingsMapper.map)
            .toBlocking
            .toList
        println(readings)
    }
}
