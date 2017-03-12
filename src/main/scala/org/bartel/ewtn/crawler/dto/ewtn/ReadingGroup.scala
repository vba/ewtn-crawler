package org.bartel.ewtn.crawler.dto.ewtn

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

@JsonIgnoreProperties(ignoreUnknown = true)
case class ReadingGroup(@JsonProperty("Name") name: String,
                        @JsonProperty("Note") note: String,
                        @JsonProperty("Readings") readings : List[Reading])
