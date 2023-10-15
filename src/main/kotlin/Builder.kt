class DrinkItem(var description: String = "drink")

class DrinkBuilder {
    private var drink = DrinkItem()

    fun reset() = apply {
        drink = DrinkItem()
    }

    fun build(): DrinkItem { return drink }

    fun addColdWater() = apply {
        drink.description += " & cold water"
    }

    fun addHotWater() = apply {
        drink.description += " & hot water"
    }

    fun addBlackTea() = apply {
        drink.description += " & black tea"
    }

    fun addIce() = apply {
        drink.description += " & ice"
    }

    fun addSugar() = apply {
        drink.description += " & sugar"
    }

    fun addFruits() = apply {
        drink.description += " & fruits"
    }
}

class Director() {
    fun makeShake(builder: DrinkBuilder): DrinkItem {
        return builder
                .reset()
                .addIce()
                .addFruits()
                .addSugar()
                .build()
    }

    fun makeTea(builder: DrinkBuilder): DrinkItem {
        return  builder
                .reset()
                .addHotWater()
                .addBlackTea()
                .addSugar()
                .build()
    }
}