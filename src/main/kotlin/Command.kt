interface Command {
    fun execute()
}

class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.on()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.off()
    }
}


class Light {
    fun on() {
        println("Light on")
    }

    fun off() {
        println("Light off")
    }
}


class RemoteControl {
    private val commands = mutableListOf<Command>()

    fun setCommand(command: Command) {
        commands.add(command)
    }

    fun executeCommands() {
        for (command in commands) {
            command.execute()
        }
        commands.clear()
    }
}


fun main() {
    val remoteControl = RemoteControl()

    val light = Light()
    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)

    remoteControl.setCommand(lightOnCommand)
    remoteControl.setCommand(lightOffCommand)

    remoteControl.executeCommands()
}