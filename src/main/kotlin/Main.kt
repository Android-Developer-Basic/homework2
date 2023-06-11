import builder.Customer
import builder.CustomerBuilderImpl
import builder.Status
import command.*
import singleton.DataBase
import singleton.DataBaseSimpleImpl
import singleton.DataBaseThreadSafeImpl

fun main() {

    val customerBuilderImpl = CustomerBuilderImpl.instance

    val sasha: Customer = customerBuilderImpl.setName("Sasha").setAge(33).build()
    val natasha: Customer = customerBuilderImpl.setName("Natasha").setAge(44).build()
    val pasha: Customer = customerBuilderImpl.setName("Pasha").setStatus(Status.Gold(0.15)).build()
    val dasha: Customer = customerBuilderImpl.setName("Dasha").setAge(23).setStatus(Status.Silver(0.10)).build()

    val dbSimple: DataBase<Customer> = DataBaseSimpleImpl.INSTANCE
    val dbThreadSafe: DataBase<Customer> = DataBaseThreadSafeImpl.getInstance()

    val commandsList =
        listOf(InsertCommand(dbSimple,sasha),
            InsertCommand(dbSimple,pasha),
            InsertCommand(dbSimple,dasha),
            UpdateCommand(dbSimple, Customer(sasha.id, "SASHA", 34, Status.Silver(0.10))),
            SelectCommand(dbSimple, sasha.id),
            InsertCommand(dbThreadSafe, natasha),
            InsertCommand(dbThreadSafe,dasha),
            DeleteCommand(dbThreadSafe, natasha.id))

    commandsList.forEach { command -> command.execute() }

}