package ru.otus.homework2

//реализация паттерна Decorator

class Cheese (val name: String, val fat: Int, var storageLifeInDays: Int, val country: String) {
    fun isFresh(): String = if (this.storageLifeInDays > 0) "The cheese is still fresh."
    else throw IllegalArgumentException("Sell $name at a discount immediately!!!")
}

fun Cheese.isRoquefort() {
    if(name == "Roquefort") println("Its smell will make you beg for mercy") else println("$name is not Roquefort")
}