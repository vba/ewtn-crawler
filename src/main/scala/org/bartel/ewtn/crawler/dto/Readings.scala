package org.bartel.ewtn.crawler.dto


case class Readings(date: String, note: String, readings: Seq[Reading]) {
    def toMap : Map[String, Any] = Map("date" -> date, "note" -> note, "readings" -> readings.map(_.toMap))
}
