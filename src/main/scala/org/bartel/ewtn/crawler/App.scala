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
            .retry(3)
            //.onErrorResumeNext(e => Observable.empty)
            .map(ReadingsMapper.map)
            .foldLeft(List[Readings]())((acc, x) =>  x :: acc)
            .subscribeOn(IOScheduler.apply())
            .subscribe(
                x => ReadingsWriter.write(x),
                e => println(s"[Error] $e"),
                () => break = true
            )

        while (!break) {
            Thread.sleep(500)
        }
    }
}
