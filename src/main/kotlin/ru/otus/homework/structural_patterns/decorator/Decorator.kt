package ru.otus.homework.structural_patterns.decorator

interface Printer{
    fun printedString() : String
}

class HelloPrinter : Printer {
    override fun printedString(): String = "Hello"
}

class ComaPrinter(
    private val printer: Printer
) : Printer {
    override fun printedString(): String = "${printer.printedString()},"
}

class SpacePrinter(
    private val printer: Printer
) : Printer {
    override fun printedString(): String = "${printer.printedString()} "
}

class WorldPrinter(
    private val printer: Printer
) : Printer {
    override fun printedString(): String = "${printer.printedString()}World"
}

class ExclamationPointPrinter(
    private val printer: Printer
) : Printer {
    override fun printedString(): String = "${printer.printedString()}!"
}