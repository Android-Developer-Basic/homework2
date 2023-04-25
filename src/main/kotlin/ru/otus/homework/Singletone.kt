package ru.otus.homework

// or
// object Singleton {
//  fun doSomething() = "Doing something"
// }

class Singleton private constructor() {

    companion object {
        val instance: Singleton by lazy {
            Singleton()
        }
    }

    fun doSomething() = "Doing something"
}
