package org.bartel.ewtn.crawler.dto

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import org.bartel.ewtn.crawler.utils.JsonUtils


case class Readings(date: String, note: String, readings: Seq[Reading]) {
    def toJson : JsonNode = {
        JsonUtils.objectMapper
            .convertValue(Map("kind" -> date, "note" -> note, "readings" -> readings.map(_.toJson)), classOf[JsonNode])
    }
}
