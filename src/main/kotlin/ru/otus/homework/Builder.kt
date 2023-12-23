package ru.otus.homework

abstract class Meat
class Chicken: Meat()
class Beef: Meat()

abstract class Sauce
class CheeseSauce: Sauce()
class SpicySauce: Sauce()


interface Builder {
    var name: String
    var meat: Meat
    var sauce: Sauce
    var cost: Int
    var cheese: Boolean

    fun getBurger(): Burger
}

class BurgerBuilder : Builder {
    override var name: String = "NoName"

    override lateinit var meat: Meat

    override lateinit var sauce: Sauce

    override var cost: Int = 100

    override var cheese: Boolean = false
    override fun getBurger(): Burger {
        return Burger(name, meat, sauce, cost, cheese)
    }
}

data class Burger(val name: String, val meat: Meat, val sauce: Sauce, val cost: Int, val cheese: Boolean)

class Director {
    fun createKfcBurger(builder: BurgerBuilder) {
        builder.name = "KFC burger"
        builder.cost = 150
        builder.meat = Chicken()
        builder.sauce = CheeseSauce()
        builder.cheese = true
    }
    fun createMacBurger(builder: BurgerBuilder) {
        builder.name = "MacDonald's Burger"
        builder.cost = 120
        builder.meat = Beef()
        builder.sauce = SpicySauce()
        builder.cheese = false
    }
}

fun main() {
    val director = Director()
    val burgerBuilder = BurgerBuilder()
    director.createKfcBurger(burgerBuilder)
    val kfcBurger = burgerBuilder.getBurger()
    println(kfcBurger.toString())

    director.createMacBurger(burgerBuilder)
    val macBurger = burgerBuilder.getBurger()
    println(macBurger.toString())

}