package org.bartel.ewtn.crawler.utils


object FunctionalUtils {
    implicit class Forward[TIn, TIntermediate](f: TIn => TIntermediate) {
        def >> [TOut](g: TIntermediate => TOut): TIn => TOut = source => g(f(source))
    }
}
