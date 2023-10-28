package ru.otus.homework

/**
 * Паттерн Singleton
 */
class Singleton private constructor() {

    companion object {
        private var instance : Singleton? = null
        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!!
        }
    }

}

fun main() {
    // получим единственный экземпляр объекта
    val single = Singleton.getInstance()
}