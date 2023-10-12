class Singleton private constructor() {

    fun sayHello() = println("Hello from singleton")

    companion object {
        val INSTANCE by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { Singleton() }
    }

}

fun main() = Singleton.INSTANCE.sayHello()