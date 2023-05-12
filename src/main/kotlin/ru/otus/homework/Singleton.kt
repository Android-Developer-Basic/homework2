package ru.otus.homework

class Singleton private constructor() {

    companion object {
        val instance:Singleton by lazy {
            Singleton()
        }
    }
}

fun main() {
    val instance = Singleton.instance
}
