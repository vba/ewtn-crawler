package org.bartel.ewtn.crawler.dto

import com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

import scala.beans.BeanProperty

/*
{
   "Color":"Violet",
   "Date":"2017-03-09",
   "Note":"Total Consecration – Day 18",
   "ReadingGroups":[
      {
         "Name":"Default",
         "Note":null,
         "Readings":[
            {
               "Citations":[
                  {
                     "Note":null,
                     "Reference":"Esther C:12, 14-16, 23-25"
                  }
               ],
               "Type":"Reading 1"
            },
            {
               "Citations":[
                  {
                     "Note":null,
                     "Reference":"Psalms 138:1-3, 7-8"
                  }
               ],
               "Type":"Psalm"
            },
            {
               "Citations":[
                  {
                     "Note":null,
                     "Reference":"Matthew 7:7-12"
                  }
               ],
               "Type":"Gospel"
            }
         ]
      }
   ],
   "Title":"Lenten Weekday"
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
case class ReadingTree(@JsonProperty("Color") color: String,
                       @JsonProperty("Date") date: String,
                       @JsonProperty("Note") note: String,
                       @JsonProperty("Title") title: String,
                       @JsonProperty("ReadingGroups") readingGroups: List[ReadingGroup])

@JsonIgnoreProperties(ignoreUnknown = true)
case class ReadingGroup(@JsonProperty("Name") name: String,
                        @JsonProperty("Note") note: String,
                        @JsonProperty("Readings") readings : List[Reading])

@JsonIgnoreProperties(ignoreUnknown = true)
case class Reading(@JsonProperty("Type") kind: String,
                   @JsonProperty("Citations") citations : List[Citation])

@JsonIgnoreProperties(ignoreUnknown = true)
case class Citation(@JsonProperty("Note") note: String, @JsonProperty("Reference") reference: String)

