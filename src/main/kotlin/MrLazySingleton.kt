package ru.otus.homework2

//реализация паттерна Singleton

object MrLazySingleton {

    fun isFibonacci(number: Int): Boolean {
        var a = 0
        var b = 1
        while (b < number) {
            val temp = b
            b += a
            a = temp
        }
        return b == number
    }
}