import builder.Customer
import builder.CustomerBuilderImpl
import builder.Status
import command.*
import decorator.CompanyMemberDecorator
import decorator.VipCustomerDecorator
import singleton.DataBase
import singleton.DataBaseSimpleImpl
import singleton.DataBaseThreadSafeImpl

fun main() {

    val customerBuilderImpl = CustomerBuilderImpl.instance

    val sasha: Customer = customerBuilderImpl.setName("Sasha").setAge(33).build()
    val natasha: Customer = customerBuilderImpl.setName("Natasha").setAge(44).build()
    val pasha: Customer = customerBuilderImpl.setName("Pasha").setStatus(Status.Gold).build()
    val dasha: Customer = customerBuilderImpl.setName("Dasha").setAge(23).setStatus(Status.Silver).build()

    val dbSimple: DataBase<Customer> = DataBaseSimpleImpl.INSTANCE
    val dbThreadSafe: DataBase<Customer> = DataBaseThreadSafeImpl.getInstance()

    val commandsList =
        listOf(InsertCommand(dbSimple,sasha),
            InsertCommand(dbSimple,pasha),
            InsertCommand(dbSimple,dasha),
            UpdateCommand(dbSimple, Customer(sasha.id, "SASHA", 34, Status.Silver)),
            SelectCommand(dbSimple, sasha.id),
            InsertCommand(dbThreadSafe, natasha),
            InsertCommand(dbThreadSafe,dasha),
            DeleteCommand(dbThreadSafe, natasha.id))

    commandsList.forEach { command -> command.execute() }

    val productPrice = 400
    val anotherProductPrice = 30

    val sergeyPetrovich = customerBuilderImpl.setName("Sergey Petrovich").setAge(66).setStatus(Status.Platinum).build()
    println("sergeyPetrovich price: ${sergeyPetrovich.applyPersonalDiscount(productPrice)}")
    val vipSergeyPetrovich = VipCustomerDecorator(sergeyPetrovich)
    println("vipSergeyPetrovich price: ${vipSergeyPetrovich.applyPersonalDiscount(productPrice)}")

    val kolyaTheCompanyMember = CompanyMemberDecorator(customerBuilderImpl.setName("Kolya").build())
    println("KolyaTheMember product price ${kolyaTheCompanyMember.applyPersonalDiscount(productPrice)}")
    println("KolyaTheMember current bonus: ${kolyaTheCompanyMember.memberBonus}")

    val priceReducedByBonus = kolyaTheCompanyMember.spendBonus(anotherProductPrice)
    println("KolyaTheMember another product price $anotherProductPrice ReducedByBonus = $priceReducedByBonus")
    println("KolyaTheMember current bonus: ${kolyaTheCompanyMember.memberBonus}")

}