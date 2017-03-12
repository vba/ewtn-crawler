package org.bartel.ewtn.crawler.dto.ewtn

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

@JsonIgnoreProperties(ignoreUnknown = true)
case class Citation(@JsonProperty("Note") note: String, @JsonProperty("Reference") reference: String)
