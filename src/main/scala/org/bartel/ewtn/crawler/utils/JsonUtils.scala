package org.bartel.ewtn.crawler.utils

import com.fasterxml.jackson.databind.ObjectMapper

object JsonUtils {
    lazy val objectMapper = new ObjectMapper()
}
