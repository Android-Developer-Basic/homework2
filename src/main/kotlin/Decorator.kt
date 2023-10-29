interface Lemonade {
    fun getCost(): Int
    fun getSugarPercent(): Double
    fun getCompound(): String

}

class OrdinaryLemonade: Lemonade {
    override fun getCost(): Int {
        return 10
    }

    override fun getSugarPercent(): Double {
        return 10.0
    }

    override fun getCompound(): String {
        return "Вода, сахар, джем"
    }
}

abstract class LemonadeDecorator(private val decoratedLemonade: Lemonade): Lemonade {
    override fun getCost(): Int {
        return decoratedLemonade.getCost()
    }

    override fun getSugarPercent(): Double {
        return decoratedLemonade.getSugarPercent()
    }

    override fun getCompound(): String {
       return decoratedLemonade.getCompound()
    }
}

class NoSugarLemonade(decoratedLemonade: Lemonade): LemonadeDecorator(decoratedLemonade) {
    override fun getCost(): Int {
        return 5
    }

    override fun getSugarPercent(): Double {
        return 0.0
    }

    override fun getCompound(): String {
        return "Вода, джем"
    }
}

fun main() {
    val ordinaryLemonade = OrdinaryLemonade()
    val lemonadeWithoutSugar = NoSugarLemonade(ordinaryLemonade)
    println("Стоимость - ${ordinaryLemonade.getCost()}, Сахара - ${ordinaryLemonade.getSugarPercent()}, Состав - ${ordinaryLemonade.getCompound()}")
    println("Стоимость - ${lemonadeWithoutSugar.getCost()}, Сахара - ${lemonadeWithoutSugar.getSugarPercent()}, Состав - ${lemonadeWithoutSugar.getCompound()}")
}