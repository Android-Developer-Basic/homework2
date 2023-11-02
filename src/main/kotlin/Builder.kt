class Product(private val name: String, private val price: Double, private val weight: Double, private val color: String) {
    override fun toString(): String {
        return "Product(name='$name', price=$price, weight=$weight, color='$color')"
    }
}

class ProductBuilder {
    private var name: String = ""
    private var price: Double = 0.0
    private var weight: Double = 0.0
    private var color: String = ""

    fun setName(name: String): ProductBuilder {
        this.name = name
        return this
    }

    fun setPrice(price: Double): ProductBuilder {
        this.price = price
        return this
    }

    fun setWeight(weight: Double): ProductBuilder {
        this.weight = weight
        return this
    }

    fun setColor(color: String): ProductBuilder {
        this.color = color
        return this
    }

    fun build(): Product {
        return Product(name, price, weight, color)
    }
}

fun main() {

    val product = ProductBuilder()
        .setName("Example Product")
        .setPrice(50.5)
        .setWeight(2.2)
        .setColor("Red")
        .build()

    println(product)
}