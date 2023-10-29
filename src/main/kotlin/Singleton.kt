class Singleton private constructor() {
    companion object {
        val instance: Singleton by lazy { Singleton() }
    }

    fun testSingleton() = println("Test Singleton")
}

fun main() {
    Singleton.instance.testSingleton()
}