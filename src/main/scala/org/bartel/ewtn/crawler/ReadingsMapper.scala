package org.bartel.ewtn.crawler

import org.bartel.ewtn.crawler.dto.{Reading, ReadingKind, Readings}
import org.bartel.ewtn.crawler.dto.ewtn.{Citation, ReadingTree}

class ReadingsMapper private[crawler]() {

    private[crawler] def mapKind(kind: String): ReadingKind = {
        kind.toLowerCase match {
            case "reading 1" => ReadingKind.Reading1
            case "reading 2" => ReadingKind.Reading2
            case "reading 3" => ReadingKind.Reading3
            case "reading 4" => ReadingKind.Reading4
            case "reading 5" => ReadingKind.Reading5
            case "reading 6" => ReadingKind.Reading6
            case "reading 7" => ReadingKind.Reading7
            case "reading 8" => ReadingKind.Reading8
            case "psalm 1" | "psalm" => ReadingKind.Psalm1
            case "psalm 2" => ReadingKind.Psalm2
            case "psalm 3" => ReadingKind.Psalm3
            case "psalm 4" => ReadingKind.Psalm4
            case "psalm 5" => ReadingKind.Psalm5
            case "psalm 6" => ReadingKind.Psalm6
            case "psalm 7" => ReadingKind.Psalm7
            case "psalm 8" => ReadingKind.Psalm8
            case "gospel" => ReadingKind.Gospel
            case _ =>
                println(s"[Warn] Unknown reading kind: $kind")
                ReadingKind.Unknown
        }
    }

    private[crawler] def mapReference(citations: Seq[Citation]): List[String] = {
        citations.map(_.reference).toList
    }

    def map(in: ReadingTree): Readings = {
        val readings = in.readingGroups
            .flatMap(_.readings)
            .map(x => Reading(kind = mapKind(x.kind), references = mapReference(x.citations)))

        Readings(date = in.date, note = in.note, readings = readings)
    }
}

object ReadingsMapper {
    lazy val readingsMapper = new ReadingsMapper()
    def map(in: ReadingTree): Readings = readingsMapper.map(in)
}
