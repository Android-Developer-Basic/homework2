class Light {
    fun turnOn() {
        kotlin.io.println("The light is on")
    }

    fun turnOff() {
        kotlin.io.println("The light is off")
    }
}

interface Command {
    fun execute()
}

class TurnOnLightCommand(private val theLight: Light) : Command {
    override fun execute() {
        theLight.turnOn()
    }
}

class TurnOffLightCommand(private val theLight: Light) : Command {
    override fun execute() {
        theLight.turnOff()
    }
}

class Switch(private val flipUpCommand: Command, private val flipDownCommand: Command) {
    fun flipUp() {
        flipUpCommand.execute()
    }

    fun flipDown() {
        flipDownCommand.execute()
    }
}

fun main() {
    val l = Light()
    val switchUp: Command = TurnOnLightCommand(l)
    val switchDown: Command = TurnOffLightCommand(l)
    val s = Switch(switchUp, switchDown)

    s.flipUp()
    s.flipDown()
}
