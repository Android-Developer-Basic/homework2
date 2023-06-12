package decorator

import builder.CustomerDiscountCalculator

abstract class CustomerDecorator(
    private val customer: CustomerDiscountCalculator
) : CustomerDiscountCalculator {

    override fun applyPersonalDiscount(price: Int): Int {
        return customer.applyPersonalDiscount(price)
    }
}