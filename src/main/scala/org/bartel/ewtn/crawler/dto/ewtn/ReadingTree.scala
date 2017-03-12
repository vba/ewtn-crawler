package org.bartel.ewtn.crawler.dto.ewtn

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}


@JsonIgnoreProperties(ignoreUnknown = true)
case class ReadingTree(@JsonProperty("Color") color: String,
                       @JsonProperty("Date") date: String,
                       @JsonProperty("Note") note: String,
                       @JsonProperty("Title") title: String,
                       @JsonProperty("ReadingGroups") readingGroups: List[ReadingGroup])

