interface Drink {
    fun getDescription(): String
}

class Shake: Drink {
    override fun getDescription(): String {
        return "Shake"
    }
}

class MangoDecorator(private val drink: Drink): Drink {
    override fun getDescription(): String {
        return drink.getDescription() + " & mango"
    }
}

class PassionFruitDecorator(private val drink: Drink): Drink {
    override fun getDescription(): String {
        return drink.getDescription() + " & passion fruit"
    }
}

class SugarDecorator(private val drink: Drink): Drink {
    override fun getDescription(): String {
        return drink.getDescription() + " & sugar"
    }
}