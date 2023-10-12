data class Person(val firstName: String, val lastName: String)

class PersonBuilder {

    private lateinit var firstName: String
    private lateinit var lastName: String

    fun firstName(value: String) = this.also { firstName = value }

    fun lastName(value: String) = this.also { lastName = value }

    fun build() = Person(firstName, lastName)
}

fun main() = println(PersonBuilder().firstName("John").lastName("Smith").build())