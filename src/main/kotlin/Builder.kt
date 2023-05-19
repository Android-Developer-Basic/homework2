package ru.otus.homework2

//реализация паттерна Builder

class Product private constructor(
    val name: String,
    val price: Double,
    val description: String
) {
    class Builder {
        private var name: String = ""
        private var price: Double = 0.0
        private var description: String = ""

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setPrice(price: Double): Builder {
            this.price = price
            return this
        }

        fun setDescription(description: String): Builder {
            this.description = description
            return this
        }

        fun build(): Product {
            return Product(name, price, description)
        }
    }
}

fun main() {

    println("Введите сумму депозита:")

    val drMartens = Product.Builder()
        .setName("Dr.Martens 69's Stompers")
        .setPrice(19999.0)
        .setDescription("Ботинки из кожи розового единорога")
        .build()

    val cashMoney = readln().toDouble()

    println(if (cashMoney >= drMartens.price) "Пришла пора заказать ${drMartens.name}!" else "Не тратьте ваши $cashMoney, накопите ещё, и ждите Чёрную Пятницу.")
}