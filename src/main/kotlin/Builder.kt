class Pizza private constructor(
    val size: String,
    val cheese: Boolean,
    val pepperoni: Boolean,
    val mushrooms: Boolean,
    val tomatoes: Boolean
) {

    data class Builder(
        var size: String = "Medium",
        var cheese: Boolean = false,
        var pepperoni: Boolean = false,
        var mushrooms: Boolean = false,
        var tomatoes: Boolean = false
    ) {
        fun size(size: String) = apply { this.size = size }
        fun cheese(cheese: Boolean) = apply { this.cheese = cheese }
        fun pepperoni(pepperoni: Boolean) = apply { this.pepperoni = pepperoni }
        fun mushrooms(mushrooms: Boolean) = apply { this.mushrooms = mushrooms }
        fun tomatoes(tomatoes: Boolean) = apply { this.tomatoes = tomatoes }

        fun build() = Pizza(size, cheese, pepperoni, mushrooms, tomatoes)
    }

    override fun toString(): String {
        return "Pizza [size=$size, cheese=$cheese, pepperoni=$pepperoni, mushrooms=$mushrooms, tomatoes=$tomatoes]"
    }
}

fun main() {
    // пицца через билдер
    val pizza = Pizza.Builder()
        .size("Large")
        .cheese(true)
        .pepperoni(true)
        .mushrooms(true)
        .build()

    println(pizza)
}