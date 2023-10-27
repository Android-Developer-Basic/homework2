package ru.otus.homework.decorator

class CheeseDecorator (pizza: Pizza) : PizzaDecorator(pizza) {
    override fun makePizza(): String {
        val basePizza = super.makePizza()
        return "$basePizza with Cheese"
    }
}