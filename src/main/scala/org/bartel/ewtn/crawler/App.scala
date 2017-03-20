package org.bartel.ewtn.crawler

import rx.lang.scala.Observable

object App {
    def main(args: Array[String]): Unit = {

        Observable
            .from(DatesProvider.provide())
            .flatMap(ReadingsClient.instance.getReading)
            .map(ReadingsMapper.map)


        println(1)
    }
}
