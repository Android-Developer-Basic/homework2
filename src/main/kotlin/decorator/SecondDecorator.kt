package decorator

interface Pizza {
    val price: Int

    fun getTotalPrice(): Int
    fun getDescription(): String
}

class BasicPizza : Pizza {
    override val price: Int = 100

    override fun getTotalPrice(): Int = price
    override fun getDescription(): String = "Базовая пицца"
}

abstract class PizzaDecorator(protected val pizza: Pizza) : Pizza {
    abstract override val price: Int
    override fun getTotalPrice(): Int = price + pizza.getTotalPrice()
}

class Meat(pizza: Pizza) : PizzaDecorator(pizza){
    override val price: Int = 50
    override fun getDescription(): String = "${pizza.getDescription()} с мясом"
}

class Cheese(pizza: Pizza) : PizzaDecorator(pizza){
    override val price: Int = 100
    override fun getDescription(): String = "${pizza.getDescription()} с сыром"
}

class Vegetables(pizza: Pizza) : PizzaDecorator(pizza){
    override val price: Int = 150
    override fun getDescription(): String = "${pizza.getDescription()} с овощами"
    override fun getTotalPrice(): Int = price + this.pizza.getTotalPrice()
}

fun main(){
    val badPizza = BasicPizza()
    println("${badPizza.getDescription()} ${badPizza.getTotalPrice()}")

    val normalPizza = Meat(badPizza)
    println("${normalPizza.getDescription()} ${normalPizza.getTotalPrice()}")

    val goodPizza = Cheese(normalPizza)
    println("${goodPizza.getDescription()} ${goodPizza.getTotalPrice()}")

    val awesomePizza = Vegetables(goodPizza)
    println("${awesomePizza.getDescription()} ${awesomePizza.getTotalPrice()}")

    val allIngredients = Meat(Cheese(Vegetables(pizza = BasicPizza())))

    println("${allIngredients.getDescription()} ${allIngredients.getTotalPrice()}")


}