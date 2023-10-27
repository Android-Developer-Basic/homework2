package ru.otus.homework.builder

class Person private constructor(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val address: String
) {
    class Builder {
        private var firstName: String = ""
        private var lastName: String = ""
        private var age: Int = 0
        private var address: String = ""

        fun setFirstName(firstName: String) = apply { this.firstName = firstName }
        fun setLastName(lastName: String) = apply { this.lastName = lastName }
        fun setAge(age: Int) = apply { this.age = age }
        fun setAddress(address: String) = apply { this.address = address }

        fun build(): Person {
            return Person(firstName, lastName, age, address)
        }
    }
}