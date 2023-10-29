data class Customer(
    val name: String,
    val timeVisit: Double,
    val queueNumber: Int
)

class CustomerBuilder() {
    private var name = "Какой-то покупатель"
    private var timeVisit = 9.00
    private var queueNumber = 0

    fun setName(name: String): CustomerBuilder {
        this.name = name
        return this
    }

    fun setTimeVisit(timeVisit: Double): CustomerBuilder {
        this.timeVisit = timeVisit
        return this
    }

    fun setQueueNumber(queueNumber: Int): CustomerBuilder {
        this.queueNumber = queueNumber
        return this
    }

    fun build(): Customer {
        return Customer(
            name, timeVisit, queueNumber
        )
    }
}

fun main() {
    val ordinaryCustomer: Customer = CustomerBuilder().build()
    val someCustomer: Customer = CustomerBuilder().setName("Жора").setTimeVisit(12.00).setQueueNumber(1).build()
    println(ordinaryCustomer.toString())
    println(someCustomer.toString())
}