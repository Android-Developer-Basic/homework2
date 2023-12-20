package ru.otus.homework

interface Coffee {
    fun getCost() : Int
    fun getMessage() : String
}

class SimpleCoffee : Coffee {
    override fun getCost() : Int {
        return 100
    }

    override fun getMessage() : String {
        return "Coffee"
    }
}

abstract class Decorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun getCost(): Int {
        return decoratedCoffee.getCost()
    }

    override fun getMessage(): String {
        return decoratedCoffee.getMessage()
    }
}

class SugarDecorator(decoratedCoffee: Coffee) : Decorator(decoratedCoffee) {
    override fun getCost(): Int {
        return super.getCost() + 20
    }

    override fun getMessage(): String {
        return super.getMessage() + " with sugar"
    }
}

fun main() {
    val coffee = SimpleCoffee()
    val sugarCoffee = SugarDecorator(coffee)
    println(sugarCoffee.getCost())
    println(sugarCoffee.getMessage())
}
