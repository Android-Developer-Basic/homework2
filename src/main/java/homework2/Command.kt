package homework2

import java.util.Stack

interface Command{
    fun executeCommand()
}

class CommandHandler{
    private val commandHistory = Stack<Command>()
    fun pushCommand(command: Command) {
        command.executeCommand()
        commandHistory.push(command)
    }
}

enum class GuestCloth(val type: String){
    Sport("Спортивки"),
    Costume("Костюм")
}

class MeetGuestCommand(private val cloth: GuestCloth = GuestCloth.Sport, private val booked: Boolean) : Command{
    fun kickOut(){
        println("Выгоняем гостя.")
    }

    fun seatGuest(){
        println("Сажаем гостя за свободный стол.")
    }

    fun pleaseWait(){
        println("Просим гостя подождать, свободных столов нет.")
    }

    override fun executeCommand() {
        when{
            (cloth.ordinal < GuestCloth.Costume.ordinal) -> kickOut()
            (!booked) -> pleaseWait()
            else -> seatGuest()
        }
    }
}

class AcceptGuestOrderCommand(private val order: Array<String> = arrayOf("Салфетка")) : Command{

    val availableDishes = arrayOf(
        "Железный майк",
        "Папа чиз",
        "Дэни трэхо",
        "Картофель фри",
        "Салфетка"
    )

    val unavailableDishes = arrayOf(
        availableDishes[2]
    )

    fun dishesNot(dishes: String){
        println("Простите, блюда $dishes у нас нет.")
    }

    fun acceptOrder(dishes: Array<String>){
        println("Ваш заказ:")
        println(dishes.joinToString())
    }

    fun dishesStop(dishes: String){
        println("Сегодня блюдо $dishes в стоп листе.")
    }

    override fun executeCommand() {
        var resultOrder = emptyArray<String>()
        order.forEach {element ->
            when{
                availableDishes.contains(element) and unavailableDishes.contains(element) -> dishesStop(element)
                !availableDishes.contains(element) -> dishesNot(element)
                else -> resultOrder += element
            }
        }
        if(resultOrder.isNotEmpty())
            acceptOrder(resultOrder)
    }
}

fun main(){
    val history = CommandHandler()
    println("Гость пришёл")
    history.pushCommand(MeetGuestCommand(GuestCloth.Costume, true))
    val order = AcceptGuestOrderCommand(arrayOf("Филадельфия", "Картофель фри", "Дэни трэхо"))
    history.pushCommand(order)
    println("Ещё гость пришёл")
    history.pushCommand(MeetGuestCommand(GuestCloth.Sport, false))
}