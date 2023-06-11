package command

import builder.Customer
import singleton.DataBase

class DeleteCommand (
    private val dataBase: DataBase<Customer>,
    private val id: Int
) : Command<Unit> {
    override fun execute() {
        dataBase.delete(id)
    }
}