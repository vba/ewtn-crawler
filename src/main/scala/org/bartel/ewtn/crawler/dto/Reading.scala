package org.bartel.ewtn.crawler.dto

import com.fasterxml.jackson.databind.JsonNode
import org.bartel.ewtn.crawler.utils.JsonUtils

case class Reading(kind: ReadingKind, references: List[String]) {
    def toJson: JsonNode = {
        JsonUtils.objectMapper
            .convertValue(Map("kind" -> this.kind, "references" -> references), classOf[JsonNode])
    }
}
