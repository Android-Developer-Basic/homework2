import builder.Customer
import builder.CustomerBuilderImpl
import builder.Status
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
    dbSimple.insert(sasha)
    dbSimple.insert(pasha)
    dbSimple.insert(dasha)

    println(dbSimple.select(sasha, dasha))

    val dbThreadSafe: DataBase<Customer> = DataBaseThreadSafeImpl.getInstance()
    dbThreadSafe.insert(natasha)
    dbThreadSafe.insert(pasha)
    println(dbThreadSafe.select(pasha, dasha))
}