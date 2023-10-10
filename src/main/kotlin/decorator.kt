interface Decorator {
    fun printPath() = println(
        this::class.annotations
            .firstNotNullOfOrNull { it as? Path }
            ?.value
            ?: "https://otus.ru"
    )

}

@Path("https://otus.ru/online")
class Decorated : Decorator

annotation class Path(val value: String)


fun main() = Decorated().printPath()