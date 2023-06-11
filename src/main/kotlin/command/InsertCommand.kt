package command

import builder.Customer
import singleton.DataBase

class InsertCommand(
    private val dataBase: DataBase<Customer>,
    private val item: Customer
) : Command<Unit> {
    override fun execute() {
        dataBase.insert(item)
    }
}