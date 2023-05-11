package builder


data class Person(
    val name: String,
    val email: String,
    val phone: Int,
    val address: String
)

class PersonBuilder {
    private var name: String = "default name"
    private var email: String = "default name"
    private var phone: Int = 0
    private var address: String = "default address"

    fun setName(value: String): PersonBuilder {
        name = value
        return this
    }

    fun setEmail(value: String): PersonBuilder {
        email = value
        return this
    }

    fun setPhone(value: Int): PersonBuilder {
        phone = value
        return this
    }

    fun setAddress(value: String): PersonBuilder {
        address = value
        return this
    }

    fun build(): Person {
        return Person(name, email, phone, address)
    }


}

fun main() {
    val somePerson =
        PersonBuilder().setName("some name").setEmail("some email").setPhone(1111111).setAddress("some address").build()
    println(somePerson)
    val defaultPerson = PersonBuilder().build()
    println(defaultPerson)


}