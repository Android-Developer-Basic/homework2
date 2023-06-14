package builder

interface CustomerDiscountCalculator {
    fun applyPersonalDiscount(price: Int): Int
}