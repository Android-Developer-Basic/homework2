package homework2

abstract class Decorator(private val prevDecorator: Decorator?=null) {
    fun getDescription(description: String): String {
        val returnDescription = prevDecorator?.getDescription(description) ?: description
        return returnDescription + description(description)
    }
    protected abstract fun description(description: String) : String

    fun getPrice(price: Float): Float {
        val returnPrice = prevDecorator?.getPrice(price)?:0f
        return (returnPrice + price(price))
    }
    protected abstract fun price(price: Float) : Float
}

class Bun() : Decorator(null){
    override fun description(description: String): String = "\nБулка"
    override fun price(price: Float): Float = 50f
}

class Cutlet(prevDecorator: Decorator, val roasting: Roasting = Roasting.None) : Decorator(prevDecorator){
    enum class Roasting(val type: String){
        None("Сырая"),
        Medium("Средняя"),
        WellDone("Полная")
    }

    override fun price(price: Float): Float  = 80.0f
    override fun description(description: String): String = "\n+Котлета; Прожарка: ${roasting.type}"
}

class Beacon(prevDecorator: Decorator) : Decorator(prevDecorator){
    override fun description(description: String): String = "\n+Бекон"
    override fun price(price: Float): Float = 10f
}

class Cheese(prevDecorator: Decorator, val cheeseType: CheeseType = CheeseType.Chedder) : Decorator(prevDecorator){
    enum class CheeseType(val type: String){
        Emmental("Эмменталь"),
        Blue("Уставший"),
        Chedder("Чеддер")
    }

    override fun description(description: String): String = "\n+Сыр: ${cheeseType.type}"

    override fun price(price: Float): Float = 10.0f
}

class Tomato(prevDecorator: Decorator) : Decorator(prevDecorator){
    override fun description(description: String): String = "\n+Помидор"

    override fun price(price: Float): Float = 15.0f
}

fun main(){
    println("-----------------------------")
    val bigMikeBurger = Cutlet(Cheese(Beacon(Tomato(Bun()))), Cutlet.Roasting.WellDone)
    println("${bigMikeBurger.getDescription("Бургер Железный Майк")}; \nСтоимость: ${bigMikeBurger.getPrice(0f)}")
    println("-----------------------------")
    val daddyCheeseBurger =   Cutlet(Cutlet(Cheese(Cheese(Bun(), Cheese.CheeseType.Blue), Cheese.CheeseType.Emmental), Cutlet.Roasting.Medium))
    println("${daddyCheeseBurger.getDescription("Бургер Папа Чиз")}; \nСтоимость: ${daddyCheeseBurger.getPrice(0f)}")
    println("-----------------------------")
}