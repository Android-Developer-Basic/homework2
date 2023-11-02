
interface Coffee {
    fun cost(): Double
    fun ingredients(): String
}


class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 1.0
    }

    override fun ingredients(): String {
        return "Simple coffee"
    }
}

abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun cost(): Double {
        return decoratedCoffee.cost()
    }

    override fun ingredients(): String {
        return decoratedCoffee.ingredients()
    }
}


class Milk(private val decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.5
    }

    override fun ingredients(): String {
        return super.ingredients() + ", Milk"
    }
}


class Whip(private val decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.7
    }

    override fun ingredients(): String {
        return super.ingredients() + ", Whip"
    }
}

fun main() {

    var someCoffee: Coffee = SimpleCoffee()

    someCoffee = Milk(someCoffee)
    someCoffee = Whip(someCoffee)

    println("Cost: ${someCoffee.cost()}; Ingredients: ${someCoffee.ingredients()}")
}