package ru.otus.homework.creational_patterns

class SingletonLazy {

    init {
        callChain.add("constructor")
    }

    fun sayHello(str: String) : String {
        callChain.add("sayHello")
        return str
    }

    companion object {
        var callChain = mutableListOf<String>()

        val INSTANCE by lazy {
            callChain.add("INSTANCE")
            SingletonLazy()
        }
    }
}