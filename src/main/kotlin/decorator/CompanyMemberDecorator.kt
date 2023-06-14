package decorator

import builder.CustomerDiscountCalculator

class CompanyMemberDecorator(
    customer: CustomerDiscountCalculator
) : CustomerDecorator(customer) {

    private val onEachPurchaseBonusSize = 0.10

    private var _memberBonus: Int = 0
    val memberBonus
        get() = _memberBonus

    override fun applyPersonalDiscount(price: Int): Int {
        getBonus(price)
        return super.applyPersonalDiscount(price)
    }

    fun spendBonus(price: Int): Int {
        var newPrice = 0
            if (price >= _memberBonus) {
                newPrice = price - _memberBonus
                _memberBonus = 0
            } else {
                _memberBonus -= price
            }
        return newPrice
    }

    private fun getBonus(purchasePrice: Int) {
        _memberBonus += (purchasePrice * onEachPurchaseBonusSize).toInt()
    }
}