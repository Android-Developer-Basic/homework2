package command

import builder.Customer
import singleton.DataBase

class SelectCommand (
    private val dataBase: DataBase<Customer>,
    private val id: Int
) : Command<Customer> {
    override fun execute(): Customer {
        return dataBase.select(id)
    }
}