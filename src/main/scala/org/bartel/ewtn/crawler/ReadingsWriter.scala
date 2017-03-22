package org.bartel.ewtn.crawler

import java.io.File
import java.nio.file.{Files, Paths}
import java.time.LocalDate

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.JsonNode
import org.bartel.ewtn.crawler.dto.Readings
import org.bartel.ewtn.crawler.utils.JsonUtils

class ReadingsWriter private[crawler]() {
    def write(readings: List[Readings]) : Unit = {
        val dir = Paths.get(s"./output/${LocalDate.now().getYear}")
        val file = dir.resolve("readings.json")
        Files.deleteIfExists(file)
        Files.createDirectories(dir)
        Files.createFile(file)

        val writer = JsonUtils.objectMapper.writer(new DefaultPrettyPrinter())
        writer.writeValue(file.toFile, readings.map(_.toMap).toArray)
    }
}

object ReadingsWriter {
    private val readingsWriter = new ReadingsWriter()
    def write(readings: List[Readings]) : Unit = readingsWriter.write(readings)
}
