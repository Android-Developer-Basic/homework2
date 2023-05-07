package ru.otus.homework2


class Account(private val config: Builder) {

    fun info(): String {
        return "Имя: ${config.name}. Никнейм: ${config.nickname}"
    }

    fun mail(): String {
            return "Email: ${config.email}"
    }

    companion object Builder {
        private var name: String? = null
        private var nickname: String? = null
        private var email: String? = null

        fun name(value: String) = apply { name = value }
        fun nickname(value: String) = apply { nickname = value }
        fun email() = apply { email = "$nickname@mail.ru" }

        fun build(): Account {
            return Account(this)
        }
    }
}
fun main() {
    val account = Account
        .name("Evgeniy")
        .nickname("zackzevs")
        .email()
        .build()
    println(account.info())
    println(account.mail())
}