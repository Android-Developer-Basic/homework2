package builder

data class Customer(
    val id: Int = 0,
    val name: String,
    val age: Int? = null,
    val status: Status? = null
) : CustomerDiscountCalculator {
    override fun applyPersonalDiscount(price: Int): Int {
        return when (status) {
            is Status.Silver -> (price - (price * status.discount)).toInt()
            is Status.Gold -> (price - (price * status.discount)).toInt()
            is Status.Platinum -> (price - (price * status.discount)).toInt()
            else -> price
        }
    }
}
