package builder

data class Customer(
    val id: Int = 0,
    val name: String,
    val age: Int? = null,
    val status: Status? = null
)
