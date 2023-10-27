package ru.otus.homework.creational_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions

class PrinterDriverTest {

    @Test
    fun singletonLazy() {
        val instance1 =  SingletonLazy.INSTANCE
        val instance2 =  SingletonLazy.INSTANCE

        Assertions.assertSame(instance1, instance2)

        val sayHello = instance1.sayHello("Hello from singleton")

        Assertions.assertEquals("Hello from singleton", sayHello)

        val callChain = SingletonLazy.callChain
        Assertions.assertEquals("INSTANCE", callChain[0])
        Assertions.assertEquals("constructor", callChain[1])
        Assertions.assertEquals("sayHello", callChain[2])
    }
}