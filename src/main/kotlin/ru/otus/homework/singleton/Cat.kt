package ru.otus.homework.singleton

class Cat private constructor() {
    init {
        println("The cat is created!")
    }

    fun meow() {
        println("Meow!")
    }

    companion object {
        val instance: Cat by lazy { Cat() }
    }
}
