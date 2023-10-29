class Person {
    private var name: String? = null
    private var surname: String? = null
    private var age = 0

    class Builder {
        private val newPerson: Person
        fun withName(name: String?): Builder {
            newPerson.name = name
            return this
        }

        fun withSurname(surname: String?): Builder {
            newPerson.surname = surname
            return this
        }

        fun withAge(age: Int): Builder {
            newPerson.age = age
            return this
        }

        fun build(): Person {
            return newPerson
        }

        init {
            newPerson = Person()
        }
    }
}

fun main(){
    val myPerson = Person.Builder()
        .withName("John")
        .withSurname("Connor")
        .withAge(39)
        .build()
}