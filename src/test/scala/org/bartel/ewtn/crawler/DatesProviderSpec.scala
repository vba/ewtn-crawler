package org.bartel.ewtn.crawler

import java.time.LocalDate
import java.time.temporal.ChronoUnit

import org.scalatest.FunSuite

class DatesProviderSpec extends FunSuite {
    test("provide should return all dates from now till the end of the year") {
        // Arrange
        val now = LocalDate.now()
        val after = LocalDate.now().plusMonths(1)
        val sut = makeSut(after)

        // Act
        val dates = sut.provide()

        // Assert
        assert(dates.length == ChronoUnit.DAYS.between(now, after.plusDays(1)))
        assert(dates.toList.head == now)
        assert(dates.toList.reverse.head == after)
    }

    def makeSut(start: LocalDate): DatesProvider = {
        new DatesProvider(start)
    }
}
