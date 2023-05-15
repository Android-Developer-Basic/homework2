package ru.otus.homework2
/*
Попытка реализации Паттерна "Command"
* */

// as a Command interface
interface Command {
    fun execute()
    fun undo()
}
// as a concrete Command
class BandCommand(private val receiver: Band) : Command {
    override fun execute() {
        receiver.playMusic()
    }

    override fun undo() {
        receiver.stopPlayingMusic()
    }
}
// as a concrete Command
class SingerCommand(private val receiver: Singer): Command {
    override fun execute() {
        receiver.singASong()
    }

    override fun undo() {
        receiver.isNotSinging()
    }
}

// as a Receiver
class Band(private val bandName: String) {
    fun playMusic() {
        println("The $bandName are playing music, as hard as they only can")
    }

    fun stopPlayingMusic() {
        println("Have a good night, folks!")
    }
}

// as a Receiver
class Singer(private val name: String){
    fun singASong() {
        println("$name is singing like a nightingale")
    }

    fun isNotSinging(){
        println("$name has left the building")
    }
}
// as an Invoker
class Festival {
    private val commands = mutableListOf<Command>()

    fun addCommand(command: Command) {
        commands.add(command)
    }

    fun run() {
        commands.forEach { it.execute() }
    }
}