package org.bartel.ewtn.crawler.dto.ewtn

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

@JsonIgnoreProperties(ignoreUnknown = true)
case class Reading(@JsonProperty("Type") kind: String,
                   @JsonProperty("Citations") citations : List[Citation])
