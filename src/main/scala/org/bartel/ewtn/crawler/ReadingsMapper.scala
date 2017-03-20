package org.bartel.ewtn.crawler

import org.bartel.ewtn.crawler.dto.{Reading, ReadingKind, Readings}
import org.bartel.ewtn.crawler.dto.ewtn.{Citation, ReadingTree}

class ReadingsMapper() {

    def mapToKind(kind: String): ReadingKind = {
        kind match {
            case "Reading 1" => ReadingKind.Reading1
            case "Reading 2" => ReadingKind.Reading2
            case "Reading 3" => ReadingKind.Reading3
            case "Reading 4" => ReadingKind.Reading4
            case "Reading 5" => ReadingKind.Reading5
            case "Reading 6" => ReadingKind.Reading6
            case "Reading 7" => ReadingKind.Reading7
            case "Reading 8" => ReadingKind.Reading8
            case "Psalm 1" | "Psalm" => ReadingKind.Psalm1
            case "Psalm 2" => ReadingKind.Psalm2
            case "Psalm 3" => ReadingKind.Psalm3
            case "Psalm 4" => ReadingKind.Psalm4
            case "Psalm 5" => ReadingKind.Psalm5
            case "Psalm 6" => ReadingKind.Psalm6
            case "Psalm 7" => ReadingKind.Psalm7
            case "Psalm 8" => ReadingKind.Psalm8
            case "Gospel" => ReadingKind.Gospel
            case x =>
                println(s"[Warn] Unknown reading kind $x")
                ReadingKind.Unknown
        }
    }

    def mapToReference(citations: Seq[Citation]): List[String] = {
        citations.map(_.reference).toList
    }

    def map(in: ReadingTree): Readings = {
        val readings = in.readingGroups
            .flatMap(_.readings)
            .map(x => Reading(kind = mapToKind(x.kind), references = mapToReference(x.citations)))

        Readings(date = in.date, note = in.note, readings = readings)
    }
}

object ReadingsMapper {
    lazy val readingsMapper = new ReadingsMapper()
    def map(in: ReadingTree): Readings = readingsMapper.map(in)
}
