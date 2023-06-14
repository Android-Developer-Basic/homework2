package builder


interface CustomerBuilder {
    fun build(): Customer
    fun setName(name: String): CustomerBuilder
    fun setAge(age: Int): CustomerBuilder
    fun setStatus(status: Status): CustomerBuilder
}