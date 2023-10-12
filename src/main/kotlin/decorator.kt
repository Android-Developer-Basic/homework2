abstract class MenuItem(private val previous: MenuItem?) {
    fun process(name: String): String =
        "${previous?.let { "${it.process(name)}, " } ?: "$name's dinner: "}${serve()}"

    protected abstract fun serve(): String
}

class Soup(previous: MenuItem? = null) : MenuItem(previous) {
    override fun serve(): String = "soup"
}

class Salad(previous: MenuItem? = null) : MenuItem(previous) {
    override fun serve(): String = "salad"
}

class Entree(previous: MenuItem? = null) : MenuItem(previous) {
    override fun serve(): String = "entree"
}

class Dessert(previous: MenuItem? = null) : MenuItem(previous) {
    override fun serve(): String = "dessert"
}

fun main() {
    println(Dessert(Entree(Salad(Soup()))).process("Anton"))
    println(Dessert(Salad()).process("Maria"))
}