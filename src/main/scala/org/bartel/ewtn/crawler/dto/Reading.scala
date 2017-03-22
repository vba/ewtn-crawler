package org.bartel.ewtn.crawler.dto

case class Reading(kind: ReadingKind, references: List[String]) {
    def toMap: Map[String, Any] = Map("kind" -> this.kind, "references" -> references)
}
