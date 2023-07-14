class Decorator {

    interface Notification {
        fun notify()
    }

    class MessageNotification(private val message: String?) : Notification {
        override fun notify() {
            println(message)
        }
    }

    open class BasedMsgDecorator(private val myWrapper: Notification) : Notification {
        override fun notify() {
            myWrapper.notify()
        }
    }

    class PhoneMsgDecorator(private val myWrapper: Notification) : BasedMsgDecorator(myWrapper) {
        override fun notify() {
            println("Notify by phone")
            myWrapper.notify()
        }
    }

    class EmailMsgDecorator(private val myWrapper: Notification) : BasedMsgDecorator(myWrapper) {
        override fun notify() {
            println("Notify by email")
            myWrapper.notify()
        }
    }

    fun main() {
        val myMessage = MessageNotification("Hello world")
        val myMessageByPhone = PhoneMsgDecorator(myMessage)
        val myMessageByEmail = EmailMsgDecorator(myMessageByPhone)
        myMessageByEmail.notify()
    }
}

