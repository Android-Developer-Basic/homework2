interface Machine{
    fun drive(){
    }
}

open class Car: Machine{
    override fun drive() {
        println("This is car")
    }
}

class ColoredCar(val sample:Car, val color: String): Car(){
    override fun drive() {
        sample.drive()
        println("Color of car is $color")
    }
}

fun main() {
    val car = Car()
    car.drive()
    val color = readLine()!!.toString()
    val coloredCar = ColoredCar(car,color)
    coloredCar.drive()
}