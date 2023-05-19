package ru.otus.homework2

//реализация паттерна Singleton

class LazySingleton private constructor() {
    companion object {
        val instance: LazySingleton by lazy { LazySingleton() }
    }

    fun isFibonacci(number: Int): Boolean {
        return if (number == 0) true else {
            var a = 0
            var temp: Int
            var b = 1
            while (b < number) {
                temp = b
                b += a
                a = temp
            }
            b == number
        }
    }
}

fun main() {

    println("Введите целое число:")

    val number = readln().toInt()

    println(if (!LazySingleton.instance.isFibonacci(number)) "$number - не число Фибоначчи" else "$number - число Фибоначчи")
}