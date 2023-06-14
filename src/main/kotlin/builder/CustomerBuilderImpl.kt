package builder

class CustomerBuilderImpl : CustomerBuilder {

    private var _name: String = DEFAULT_NAME
    private var _age: Int? = null
    private var _status: Status? = Status.NewCustomer

    override fun build(): Customer {
        return Customer(++id, _name, _age, _status)
    }

    override fun setName(name: String): CustomerBuilderImpl {
        _name = name
        return this
    }

    override fun setAge(age: Int): CustomerBuilderImpl {
        if (age < MIN_AGE) {
            error("Invalid argument")
        }
        _age = age
        return this
    }

    override fun setStatus(status: Status): CustomerBuilderImpl {
        _status = status
        return this
    }

    companion object {
        private var id: Int = 0
        private const val DEFAULT_NAME: String = "New customer"
        private const val MIN_AGE = 18
    }
}