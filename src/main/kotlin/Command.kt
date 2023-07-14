class Command {
    class TV {
        fun turnOn() {
            println("TV is on")
        }

        fun turnOff() {
            println("TV is off")
        }
    }

    interface Command {
        fun execute()
        fun undo()
    }

    class TurnOnTVCommand(private val theTV: TV) : Command {
        override fun execute() {
            theTV.turnOn()
        }

        override fun undo() {
            theTV.turnOff()
        }
    }

    class TurnOffTVCommand(private val theTV: TV) : Command {
        override fun execute() {
            theTV.turnOff()
        }

        override fun undo() {
            theTV.turnOn()
        }
    }

    class Switch(private val pressButton: Command, private val pressUndo: Command) {
        fun flipUp() {
            pressButton.execute()
        }

        fun flipDown() {
            pressUndo.execute()
        }
    }
}

fun main() {
    val tv = Command.TV()
    val switchUp: Command.Command = Command.TurnOnTVCommand(tv)
    val switchDown: Command.Command = Command.TurnOffTVCommand(tv)
    val s = Command.Switch(switchUp, switchDown)

    s.flipUp()
    s.flipDown()
}
