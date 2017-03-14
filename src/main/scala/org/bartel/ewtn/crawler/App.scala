package org.bartel.ewtn.crawler

import java.time.LocalDate

object App {
    def main(args: Array[String]): Unit = {

        val first = ReadingsClient.instance.getReading(LocalDate.now()).toBlocking.first()
        println(first)
    }
}
