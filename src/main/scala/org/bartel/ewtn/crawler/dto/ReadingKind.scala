package org.bartel.ewtn.crawler.dto

object ReadingKind {
    val Reading1 = new ReadingKind("Reading", number = 1, priority = 17)
    val Psalm1   = new ReadingKind("Psalm", number   = 1, priority = 16)
    val Reading2 = new ReadingKind("Reading", number = 2, priority = 15)
    val Psalm2   = new ReadingKind("Psalm", number   = 2, priority = 14)
    val Reading3 = new ReadingKind("Reading", number = 3, priority = 13)
    val Psalm3   = new ReadingKind("Psalm", number   = 3, priority = 12)
    val Reading4 = new ReadingKind("Reading", number = 4, priority = 11)
    val Psalm4   = new ReadingKind("Psalm", number   = 4, priority = 10)
    val Reading5 = new ReadingKind("Reading", number = 5, priority = 9)
    val Psalm5   = new ReadingKind("Psalm", number   = 5, priority = 8)
    val Reading6 = new ReadingKind("Reading", number = 6, priority = 7)
    val Psalm6   = new ReadingKind("Psalm", number   = 6, priority = 6)
    val Reading7 = new ReadingKind("Reading", number = 7, priority = 5)
    val Psalm7   = new ReadingKind("Psalm", number   = 7, priority = 4)
    val Reading8 = new ReadingKind("Reading", number = 8, priority = 3)
    val Psalm8   = new ReadingKind("Psalm", number   = 8, priority = 2)
    val Gospel   = new ReadingKind("Gospel", number  = 1, priority = 1)
    val Unknown  = new ReadingKind("Unknown", number = -1, priority = 100)
}

sealed class ReadingKind private (val value: String, val number: Int, val priority: Int) {
    override def toString = s"ReadingKind($value, $number, $priority)"
}