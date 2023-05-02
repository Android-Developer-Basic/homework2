class Singleton private constructor() {
    companion object {
        val shared: Singleton by lazy { Singleton() }
    }

    init {
        print("Singleton Init")
    }
}