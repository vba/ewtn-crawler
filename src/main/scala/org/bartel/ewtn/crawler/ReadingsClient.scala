package org.bartel.ewtn.crawler

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalDateTime}

import com.fasterxml.jackson.databind.{DeserializationFeature, JsonNode, ObjectMapper}
import com.fasterxml.jackson.databind.util.JSONPObject
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.bartel.ewtn.crawler.dto.ReadingTree
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.{GET, Path}
import rx.Observable




trait EwtnClient {
    @GET("day/{date}/en")
    def getReading(@Path("date") date: String) : Observable[ReadingTree]
}

class ReadingsClient(private val ewtnClientGetter: () => EwtnClient) {
    private lazy val ewtnClient: EwtnClient = { ewtnClientGetter() }

    def getReading(day: LocalDate): Observable[ReadingTree] = {
        val date = day.format(DateTimeFormatter.ofPattern("yyyy-M-d"))
        ewtnClient.getReading(date)
    }
}

object ReadingsClient {

    private val objectMapper = {
        val mapper = new ObjectMapper() with ScalaObjectMapper
        mapper.registerModule(DefaultScalaModule)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    private val ewtnClientGetter = () => {
        val retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .baseUrl("http://www.ewtn.com/se/readings/readingsservice.svc/")
            .build()

        retrofit.create(classOf[EwtnClient])
    }

    val instance = new ReadingsClient(ewtnClientGetter)
}
