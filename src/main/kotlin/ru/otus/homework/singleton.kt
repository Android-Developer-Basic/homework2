package ru.otus.homework

class Singleton private constructor() {
  companion object {
    val instance: Singleton by lazy {
      Singleton()
    }
  }

  private var i = 0

  fun doSomething() = ++i
}

fun main() {
  val instance1 = Singleton.instance
  println("instance1 increment: ${instance1.doSomething()}")

  val instance2 = Singleton.instance
  println("instance2 increment: ${instance2.doSomething()}")
}
