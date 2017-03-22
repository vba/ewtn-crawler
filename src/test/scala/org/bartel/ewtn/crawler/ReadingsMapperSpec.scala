package org.bartel.ewtn.crawler

import org.bartel.ewtn.crawler.dto.ReadingKind
import org.bartel.ewtn.crawler.dto.ewtn.Citation
import org.scalatest.FunSuite

class ReadingsMapperSpec extends FunSuite {
    test("mapKind should provide unknown readings kind when it's impossible to recognise one") {
        // Arrange
        val sut = new ReadingsMapper()

        // Act
        val kind = sut.mapKind("Some rubbish")

        // Assert
        assert(kind == ReadingKind.Unknown, "Unexpected value can be converted to unknown kind")
    }

    test("mapKind should provide Psalm 1 kind when Psalm 1 is received") {
        // Arrange
        val sut = new ReadingsMapper()

        // Act
        val kind = sut.mapKind("Psalm 1")

        // Assert
        assert(kind == ReadingKind.Psalm1, "Psalm1 is expected")
    }

    test("mapKind should provide Psalm 1 kind when Psalm is received") {
        // Arrange
        val sut = new ReadingsMapper()

        // Act
        val kind = sut.mapKind("psalm")

        // Assert
        assert(kind == ReadingKind.Psalm1, "Psalm1 is expected")
    }


    test("mapKind should provide Gospel kind when Gospel is received") {
        // Arrange
        val sut = new ReadingsMapper()

        // Act
        val kind = sut.mapKind("gospel")

        // Assert
        assert(kind == ReadingKind.Gospel, "Gospel is expected")
    }

    test("mapReference should provide a list of references when citations are received") {
        // Arrange
        val sut = new ReadingsMapper()
        val actualCitations = List(Citation(reference = "Ref1", note = ""), Citation(reference = "Ref2", note = ""))

        // Act
        val references = sut.mapReference(actualCitations)

        // Assert
        assert(references.length == actualCitations.length, "Same lenght is expected")
        assert(references.head == actualCitations.head.reference, "Reference must be mapped")
        assert(references.reverse.head == actualCitations.reverse.head.reference, "Reference must be mapped")
    }
}
