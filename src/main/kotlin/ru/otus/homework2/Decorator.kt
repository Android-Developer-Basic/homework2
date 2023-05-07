package ru.otus.homework2

interface Coffee {
    fun decorate(): String
}

class BlackCoffee : Coffee {
    override fun decorate() = "Кофе"
}

abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun decorate(): String {
        return coffee.decorate()
    }
}
class WithMilk(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun decorate(): String {
        return super.decorate() + decorateWithMilk()
    }
    private fun decorateWithMilk(): String {
        return ", молоко"
    }
}
class WithSugar(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun decorate(): String {
        return super.decorate() + decorateWithSugar()
    }
    private fun decorateWithSugar(): String {
        return ", сахар"
    }
}
fun main() {
    val blackCoffee = BlackCoffee()
    val withMilkCoffee = WithMilk(blackCoffee)
    val withSugarCoffee = WithSugar(blackCoffee)
    val withSugarAndWithMilkCoffee = WithMilk(withSugarCoffee)
    println(blackCoffee.decorate())
    println(withMilkCoffee.decorate())
    println(withSugarCoffee.decorate())
    println(withSugarAndWithMilkCoffee.decorate())
}