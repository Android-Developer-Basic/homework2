class decorator {
    interface Drink {
        fun getComposition(): String
    }

    class Cocktail: Drink {
        override fun getComposition(): String {
            return "Cocktail"
        }
    }

    class WithVodka(private val drink: Drink): Drink {
        override fun getComposition(): String {
            return drink.getComposition() + "Vodka"
        }
    }

    class WithWiskey(private val drink: Drink): Drink {
        override fun getComposition(): String {
            return drink.getComposition() + "Wiskey"
        }
    }

    class WithIce(private val drink: Drink): Drink {
        override fun getComposition(): String {
            return drink.getComposition() + "with Ice"
        }
    }

}
