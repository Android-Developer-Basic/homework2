package ru.otus.homework.decorator

open class PizzaDecorator (private val pizza: Pizza) : Pizza {
    override fun makePizza(): String {
        return pizza.makePizza()
    }
}