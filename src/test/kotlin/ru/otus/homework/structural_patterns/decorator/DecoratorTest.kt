package ru.otus.homework.structural_patterns.decorator

import org.junit.jupiter.api.Assertions
import org.junit.Test

class DecoratorTest {
    @Test
    fun test() {
        val printer = ExclamationPointPrinter(
            WorldPrinter(
                SpacePrinter(
                    ComaPrinter(
                        HelloPrinter()
                    )
                )
            )
        )

        Assertions.assertEquals("Hello, World!", printer.printedString())
    }
}