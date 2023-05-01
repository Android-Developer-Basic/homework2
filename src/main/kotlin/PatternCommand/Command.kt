package PatternCommand

//интерфейс команда
interface Command {
    fun execute()
}

//Отправитель - мужик который делает заказ
class Man(
    val coffee: Command,
    val tea: Command,
    val food: Command,
    val check: Command
){
    fun getMeCoffee(){
        coffee.execute()
    }
    fun getMeTea(){
        tea.execute()
    }
    fun getMeFood(){
        food.execute()
    }
    fun getMeCheck(){
        check.execute()
    }
}

//получатель
class Barista(){
    fun cookCoffee(){
        println("Coffee")
    }
    fun gotFood(){
        println("Food")
    }
    fun cookTea(){
        println("Tea")
    }
    fun calcCast(){
        println("Check")
    }
}

//конкретные команды
class CookCoffe(
    val barista: Barista
):Command{
    override fun execute() {
        barista.cookCoffee()
    }

}
class CookTea(
    val barista: Barista
):Command{
    override fun execute() {
        barista.cookTea()
    }

}
class GotFood(
    val barista: Barista
):Command{
    override fun execute() {
        barista.gotFood()
    }

}
class CalcCheck(
    val barista: Barista
):Command{
    override fun execute() {
        barista.calcCast()
    }
}

fun main(){
    val Barista = Barista()
    val Kent = Man(CookCoffe(Barista), CookTea(Barista), GotFood(Barista), CalcCheck(Barista) )
    Kent.getMeCoffee()
    Kent.getMeTea()
    Kent.getMeFood()
    Kent.getMeCheck()
}







