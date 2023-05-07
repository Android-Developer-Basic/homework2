package ru.otus.homework2

class Singleton private constructor(){

    init {
        println("Singleton class вызван.")
    }
    fun start(){
        println("Начали")
    }
    fun end(){
        println("Закончили")
    }
    companion object {
        val instance: Singleton by lazy { Singleton() }
    }
}

fun main() {
    val one = Singleton.instance
    one.start()
    one.end()
    val two = Singleton.instance
    two.start()
    two.end()
    println(one === two)
}