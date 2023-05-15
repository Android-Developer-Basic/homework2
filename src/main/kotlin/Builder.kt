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