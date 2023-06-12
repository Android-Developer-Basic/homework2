package decorator

import builder.CustomerDiscountCalculator

class VipCustomerDecorator(
    customer: CustomerDiscountCalculator
) : CustomerDecorator(customer) {

    private val vipAdditionalDiscount: Double = 0.10

    override fun applyPersonalDiscount(price: Int): Int {
        return super.applyPersonalDiscount(applyVipDiscount(price))
    }

    private fun applyVipDiscount(price: Int): Int {
        return (price - price * vipAdditionalDiscount).toInt()
    }
}