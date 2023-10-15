interface DrinkMakerCommand {
    fun execute()
}

class FruitsAddCommand(private val drinkId: String): DrinkMakerCommand {
    override fun execute() = println("Adding fruits to drink id: $drinkId")
}

class IceAddCommand(private val drinkId: String): DrinkMakerCommand {
    override fun execute() = println("Adding ice to drink id: $drinkId")
}

class WaterAddCommand(private val drinkId: String): DrinkMakerCommand {
    override fun execute() = println("Adding water to drink id: $drinkId")
}

class DrinkCommandProcessor {
    private val queue = ArrayList<DrinkMakerCommand>()

    fun addToQueue(command: DrinkMakerCommand): DrinkCommandProcessor =
        apply {
            queue.add(command)
        }

    fun processCommands(): DrinkCommandProcessor =
        apply {
            queue.forEach { it.execute() }
            queue.clear()
        }
}