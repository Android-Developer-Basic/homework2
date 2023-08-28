import org.w3c.dom.Text

class Decorator {

    interface TextMessage {
        fun baseMessage()
    }

    class BaseMessage : TextMessage {
        override fun baseMessage() {
            println("Just an ordinary message")
        }
    }


    class FormattedMessage (val textMessage: TextMessage) : TextMessage {

        fun formattedMessage() {
            println("HeRe's a FoRmAtTeD mEsSaGe")
        }

        override fun baseMessage() {
            println("Here's how an ORDINARY MESSAGE looks like now!")
        }
    }

    fun main() {
        val baseMessage = BaseMessage()
        val formattedMessage = FormattedMessage(baseMessage)

        formattedMessage.baseMessage()
        formattedMessage.formattedMessage()
    }

}