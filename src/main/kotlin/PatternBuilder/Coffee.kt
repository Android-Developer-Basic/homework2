package PatternBuilder

enum class Espresso {
    one, two
}

enum class Topping {
    sugar, chokolate, vanilla, nut, notTopping
}

data class Coffee(
    var espresso: Espresso,
    val milk: Boolean,
    val boilingWater: Boolean,
    val sugar: Boolean,
    val topping: Topping
)


interface iCoffeeBuilder {
    fun getEspresso(value: Espresso): iCoffeeBuilder
    fun getMilk(value: Boolean): iCoffeeBuilder
    fun getBoilingWater(value: Boolean): iCoffeeBuilder
    fun getSugar(value: Boolean): iCoffeeBuilder
    fun getTopping(value: Topping): iCoffeeBuilder

    fun build(): Coffee
}

class CoffeeBuilder : iCoffeeBuilder {
    private var espresso: Espresso = Espresso.one
    private var milk: Boolean = false
    private var boilingWater: Boolean = false
    private var sugar: Boolean = false
    private var topping: Topping = Topping.notTopping

    override fun getEspresso(value: Espresso): iCoffeeBuilder {
        espresso = value
        return this
    }

    override fun getMilk(value: Boolean): iCoffeeBuilder {
        milk = value
        return this
    }

    override fun getBoilingWater(value: Boolean): iCoffeeBuilder {
        boilingWater = value
        return this
    }

    override fun getSugar(value: Boolean): iCoffeeBuilder {
        sugar = value
        return this
    }

    override fun getTopping(value: Topping): iCoffeeBuilder {
        topping = value
        return this
    }

    override fun build(): Coffee {
        return Coffee(
            espresso = espresso,
            milk = milk,
            boilingWater = boilingWater,
            sugar = sugar,
            topping = topping
        )
    }
}


fun main() {
    val coffeeBuilder = CoffeeBuilder()
    val coffee =
        coffeeBuilder
        .getEspresso(Espresso.one)
        .getMilk(true)
        .getSugar(false)
        .getTopping(Topping.nut)
        .build()

    println(coffee.toString())

}