class Singleton private constructor() {

    companion object {
        val instance: Singleton by lazy {
            Singleton()
        }
    }
}

