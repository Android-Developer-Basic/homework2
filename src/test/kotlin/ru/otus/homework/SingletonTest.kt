package ru.otus.homework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class SingletonTest {
  @Test
  @Order(1)
  fun instance1Increment() {
    val instance1: Singleton = Singleton.instance

    assertEquals(
      1,
      instance1.doSomething()
    )
  }

  @Test
  @Order(2)
  fun instance2Increment() {
    val instance2: Singleton = Singleton.instance

    assertEquals(
      2,
      instance2.doSomething()
    )
  }
}