class BilderCocktail (var composition: String = "drink")


    class DrinkBuilder {
        private var drink = BilderCocktail()

        fun reset() = apply {
            drink = BilderCocktail()
        }

        fun build(): BilderCocktail { return drink }

        fun addWater() = apply {
            drink.composition += "Water"
        }

        fun addIce() = apply {
            drink.composition += "ICE"
        }
        fun addVodka() = apply {
            drink.composition += "VODKA"
        }

        fun addTomato() = apply {
            drink.composition += "Tomato"
        }

        fun addWhisky() = apply {
            drink.composition += "Whisky"
        }

        fun addCocaCola() = apply {
            drink.composition += "CocaCola"
        }


    }

    class Director() {
        fun makeDrink1(builder: DrinkBuilder): BilderCocktail {
            return builder
                .reset()
                .addWhisky()
                .addCocaCola()
                .addWater()
                .addIce()
                .build()
        }

        fun makeBloodMary(builder: DrinkBuilder): BilderCocktail {
            return  builder
                .reset()
                .addVodka()
                .addTomato()
                .addWater()
                .build()
        }
    }
