fun main() {
    // singleton with lazy init
    val singleton by lazy {
        object {
            val singletonVariable = 10
        }
    }
}