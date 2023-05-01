package PatternDecorator

interface Coffee {
    fun cost(): Int

    fun ingredient() : String
}

open class CoffeeDecorator(_coffee: Coffee) : Coffee{

    private var coffee: Coffee

    init {
        coffee = _coffee
    }

    override fun cost(): Int {
        return coffee.cost()
    }

    override fun ingredient(): String {
        return coffee.ingredient()
    }

}

class Espresso() : Coffee{
    override fun cost(): Int {
        return 100
    }

    override fun ingredient(): String {
        return "Espresso"
    }
}

class Milk(_coffee: Coffee) : CoffeeDecorator(_coffee){
    override fun cost(): Int {
        return super.cost() + 20
    }
    override fun ingredient(): String {
        return super.ingredient() + ", milk"
    }
}

class SyrupChocolate(_coffee: Coffee): CoffeeDecorator(_coffee){
    override fun cost(): Int {
        return super.cost() + 30
    }
    override fun ingredient(): String {
        return super.ingredient() + ", Syrup Chocolate"
    }

}


class SyrupVanilla(_coffee: Coffee): CoffeeDecorator(_coffee){
    override fun cost(): Int {
        return super.cost() + 35
    }
    override fun ingredient(): String {
        return super.ingredient() + ", Syrup Vanilla"
    }

}


fun main(){
    val espresso = Espresso()

    val cappuccino = Milk(espresso)

    val cappuccinoSyrup = SyrupChocolate(Milk(Espresso()))

    println("${espresso.cost()} ${espresso.ingredient()}")
    println("${cappuccino.cost()} ${cappuccino.ingredient()}")
    println("${cappuccinoSyrup.cost()} ${cappuccinoSyrup.ingredient()}")
}