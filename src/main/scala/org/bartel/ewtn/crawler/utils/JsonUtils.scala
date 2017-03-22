package org.bartel.ewtn.crawler.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object JsonUtils {
    lazy val objectMapper: ObjectMapper = new ObjectMapper().registerModule(DefaultScalaModule)
}
