package org.bartel.ewtn.crawler

import org.bartel.ewtn.crawler.dto.Readings
import rx.lang.scala.Observable
import rx.lang.scala.schedulers.IOScheduler

object App {
    def main(args: Array[String]): Unit = {
        var break = false
        Observable
            .from(DatesProvider.provide())
            .flatMap(ReadingsClient.instance.getReading)
            .map(ReadingsMapper.map)
            .subscribeOn(IOScheduler.apply())
            .subscribe(onNext = x => {println(x)}, onError = e => {println(e)}, onCompleted = () => {break = true})

        while (!break) {
            Thread.sleep(500)
        }

        //ReadingsWriter.write(readings)
    }
}
