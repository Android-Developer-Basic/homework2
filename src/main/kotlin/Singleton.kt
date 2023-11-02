class Singleton private constructor() {
    companion object {
        val instance: Singleton by lazy { Singleton() }
    }
}
fun main() {
    val singleton: Singleton = Singleton.instance
    val singleton2: Singleton = Singleton.instance

    println(singleton === singleton2)
}