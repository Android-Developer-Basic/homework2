package ru.otus.homework.behavioral_patterns

interface CalculateCommand {
    fun execute(number: Int) : Int
}

class AddCommand(private val addendum: Int) : CalculateCommand {
    override fun execute(number: Int): Int {
        return number + addendum
    }
}

class MinusCommand(private val subtrahend: Int) : CalculateCommand {
    override fun execute(number: Int): Int {
        return number - subtrahend
    }
}

class MultiCommand(private val coefficient: Int) : CalculateCommand {
    override fun execute(number: Int): Int {
        return number * coefficient
    }
}

class DivisionCommand(private val coefficient: Int) : CalculateCommand {
    override fun execute(number: Int): Int {
        return number / coefficient
    }
}