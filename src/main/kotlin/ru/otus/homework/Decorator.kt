package src.main.kotlin.ru.otus.homework

interface MyNotification {
    fun myNotify()
}

class MyMsgNotification(private val message:String?) : MyNotification {
    override fun myNotify(){
        println(message)
    }
}

open class BasedMsgDecorator constructor (protected val myWrapper: MyNotification) : MyNotification {
    override fun myNotify(){
        myWrapper.myNotify()
    }
}

class PhoneMsgDecorator constructor (myWrapper : MyNotification) : BasedMsgDecorator(myWrapper) {
    override fun myNotify(){
        println("Notify by phone")
        myWrapper.myNotify()
    }
}

class EmailMsgDecorator(myWrapper: MyNotification) : BasedMsgDecorator(myWrapper) {
    override fun myNotify(){
        println("Notify by email")
        myWrapper.myNotify()
    }
}

fun main() {
    val myMessage = MyMsgNotification("Hello world")
    // myMessage.myNotify()
    val myMessageByPhone = PhoneMsgDecorator(myMessage)
    // myMessageByPhone.myNotify()
    val myMessageByEmail = EmailMsgDecorator(myMessageByPhone)
    myMessageByEmail.myNotify()
}