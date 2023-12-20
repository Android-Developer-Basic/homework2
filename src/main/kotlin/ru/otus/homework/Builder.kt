package ru.otus.homework


interface Component

class Meat : Component

class Sauce : Component

class Bread : Component

class Cheese : Component

data class Burger (val name: String) {
    var meat: Meat? = null
    var sauce: Sauce? = null
    var bread: Bread? = null
    var cheese: Cheese? = null
}

class MacBuilder {
    companion object {
        fun build() : Burger {
            val burger = Burger("MacDonalds burger")
            burger.bread = Bread()
            burger.cheese = Cheese()
            return burger
        }
    }
}

class KfcBuilder {
    companion object {
        fun build() : Burger {
            val burger = Burger("KFC Burger")
            burger.bread = Bread()
            burger.sauce = Sauce()
            burger.cheese = Cheese()
            burger.meat = Meat()
            return burger
        }
    }
}

fun main() {
    val kfc = KfcBuilder.build()
    val mac = MacBuilder.build()
    val burger = Burger("Simple Burger")

    println(kfc.toString())
    println(mac.toString())
    println(burger.toString())

}