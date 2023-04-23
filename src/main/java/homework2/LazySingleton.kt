package homework2

class LazySingleton private constructor(){
    var someStringValue = "Just a singleton string value"
    var someMutableMap = mutableMapOf(1 to "One")
    companion object {
        val classObject by lazy {
            println("Lazy init")
            LazySingleton()
        }
    }

    init {
        println("LazySingleton primary constructor")
    }
}

object LazySingletonObject{
    var someStringValue = "Just a singleton object string value"
    var someMutableMap = mutableMapOf(1 to "One")

    init {
        println("LazySingleton object primary constructor")
    }
}