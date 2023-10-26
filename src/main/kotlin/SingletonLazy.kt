class Singleton private constructor() {
    companion object {
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!!//можно использовать без проверки на Null - всегда не null вввиду реализации
        }
    }
}