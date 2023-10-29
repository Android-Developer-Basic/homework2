interface Command{
    fun execute()
}
class Lamp{
    fun on(){
        println("Lamp is on")
    }
    fun off(){
        println("Lamp is off")
    }
}
class OnLamp(val lamp: Lamp): Command {
    override fun execute() {
        lamp.on()
    }
}
class OffLamp(val lamp: Lamp): Command {
    override fun execute() {
        lamp.off()
    }
}
class LampInvoker(var command: Command) {
    fun execute() {
        command.execute()
    }
}
fun main(){
    val lamp = Lamp()
    val onLamp = OnLamp(lamp)
    val offLamp = OffLamp(lamp)
    val lampInvoker = LampInvoker(onLamp)
    lampInvoker.execute()
}