interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

class BasicCoffee : Coffee {
    override fun getCost(): Double {
        return 1.0
    }

    override fun getDescription(): String {
        return "Basic Coffee"
    }
}

open class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun getCost(): Double {
        return coffee.getCost()
    }

    override fun getDescription(): String {
        return coffee.getDescription()
    }
}

class Milk(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.5
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Milk"
    }
}

class Sugar(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.3
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Sugar"
    }
}

fun main() {
    val coffee: Coffee = BasicCoffee()
    println(coffee.getDescription() + " - Cost: $" + coffee.getCost())

    val coffeeWithMilk: Coffee = Milk(coffee)
    println(coffeeWithMilk.getDescription() + " - Cost: $" + coffeeWithMilk.getCost())

    val coffeeWithMilkAndSugar: Coffee = Sugar(coffeeWithMilk)
    println(coffeeWithMilkAndSugar.getDescription() + " - Cost: $" + coffeeWithMilkAndSugar.getCost())
}
