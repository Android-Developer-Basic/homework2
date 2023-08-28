class SingletonLazy {

    class Singleton private constructor() {

        fun singletonCreated () {
            println("Singleton instance created")
        }

        companion object {
            val instance:Singleton by lazy {
                Singleton()
            }
        }


    }

    fun main() {
        val instance = Singleton.instance
    }


}