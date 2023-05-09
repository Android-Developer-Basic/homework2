package homework2

interface Burger{
    fun getPrice() : Float
    fun getDescription() : String
}

abstract class Decorator(private val burger: Burger) : Burger{
    override fun getDescription(): String {
        return burger.getDescription()
    }

    override fun getPrice(): Float {
        return burger.getPrice()
    }
}

class DefaultBurger: Burger{
    override fun getPrice(): Float {
        return  200.0f
    }

    override fun getDescription(): String {
        return "Бургер"
    }
}

class Beacon(burger: Burger) : Decorator(burger){
    override fun getPrice(): Float {
        return super.getPrice() + 10.0f
    }

    override fun getDescription(): String {
        return super.getDescription() + "\n+Бекон"
    }
}

class Cutlet(burger: Burger, val roasting: Roasting = Roasting.None) : Decorator(burger){
    enum class Roasting(val type: String){
        None("Сырая"),
        Medium("Средняя"),
        WellDone("Полная")
    }

    override fun getPrice(): Float {
        return super.getPrice() + 80.0f
    }

    override fun getDescription(): String {
        return super.getDescription() + "\n+Котлета; Прожарка: ${roasting.type}"
    }
}

class Cheese(burger: Burger, val cheeseType: CheeseType = CheeseType.Chedder) : Decorator(burger){
    enum class CheeseType(val type: String){
        Emmental("Эмменталь"),
        Blue("Уставший"),
        Chedder("Чеддер")
    }

    override fun getPrice(): Float {
        return super.getPrice() + 10.0f
    }

    override fun getDescription(): String {
        return super.getDescription() + "\n+Сыр: ${cheeseType.type}"
    }
}

class Tomato(burger: Burger) : Decorator(burger){
    override fun getPrice(): Float {
        return super.getPrice() + 15.0f
    }

    override fun getDescription(): String {
        return super.getDescription() + "\n+Помидор"
    }
}

fun main(){
    val bigMikeBurger = Cutlet(Cheese(Beacon(Tomato(DefaultBurger()))), Cutlet.Roasting.WellDone)
    println("Железный Майк = ${bigMikeBurger.getDescription()}; \nСтоимость: ${bigMikeBurger.getPrice()}")
    val daddyCheeseBurger =   Cutlet(Cutlet(Cheese(Cheese(DefaultBurger(), Cheese.CheeseType.Blue), Cheese.CheeseType.Emmental), Cutlet.Roasting.Medium))
    println("Папа Чиз = ${daddyCheeseBurger.getDescription()}; \nСтоимость: ${daddyCheeseBurger.getPrice()}")
}