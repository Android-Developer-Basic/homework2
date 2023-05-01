package PatternSingleton

class ExampleSingleton private constructor(
) {
    var name = "Alexey"
    companion object {
        val Example by lazy { ExampleSingleton() }
        fun createExample() : ExampleSingleton {
            return Example
        }
    }
}

fun main(){

    var Example = ExampleSingleton.createExample()
    println(Example.name)

    Example.name = "Alex"
    var ex2 = ExampleSingleton.createExample()
    println(ex2.name)
}