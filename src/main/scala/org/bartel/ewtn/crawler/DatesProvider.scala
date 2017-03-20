package org.bartel.ewtn.crawler

import java.time.LocalDate
import java.time.temporal.ChronoUnit


class DatesProvider(private val endOfYear: LocalDate = LocalDate.of(LocalDate.now().getYear, 11, 30)) {
    def provide(): Seq[LocalDate] = {
        val now = LocalDate.now()
        (0L until ChronoUnit.DAYS.between(now, endOfYear.plusDays(1))).map(now.plusDays)
    }
}

object DatesProvider {
    val datesProvider = new DatesProvider()
    def provide(): Seq[LocalDate] = datesProvider.provide()
}
