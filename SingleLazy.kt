object Singleton{

    init {
        println("1")
    }

    object Holder {
        val INSTANCE = Singleton
    }

    object Lazy {
        val instance: Singleton by lazy {
            Holder.INSTANCE
        }
    }

    var b: String = "2"
}
fun main() {
    println(Singleton.Lazy.instance.b)
    Singleton.Lazy.instance.b = "3"
    println(Singleton.Lazy.instance.b)
    println(Singleton.Lazy.instance.b)
}