package org.bartel.ewtn.crawler.dto

import com.fasterxml.jackson.databind.JsonNode
import org.bartel.ewtn.crawler.utils.JsonUtils

case class Reading(kind: ReadingKind, reference: String) {
    def toJson: JsonNode = {
        JsonUtils.objectMapper
            .convertValue(Map("kind" -> this.kind, "reference" -> reference), classOf[JsonNode])
    }
}
