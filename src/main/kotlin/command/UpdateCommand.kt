package command

import builder.Customer
import singleton.DataBase

class UpdateCommand (
    private val dataBase: DataBase<Customer>,
    private val item: Customer
) : Command<Unit> {
    override fun execute() {
        dataBase.update(item)
    }
}