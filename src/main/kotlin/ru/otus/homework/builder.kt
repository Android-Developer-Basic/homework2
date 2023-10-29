package ru.otus.homework

/**
 * Паттерн Builder
 */

class House(
    private var floors: Int,
    private var area: Double,
    private var painting: Boolean?,
    private var material: String?
) {
    private constructor(builder: Builder) : this(builder.floors, builder.area, builder.painting, builder.material)

    companion object {
        inline fun build(floors: Int, area: Double, otherParam: Builder.() -> Unit) = Builder(floors, area).apply(otherParam).build()
    }
    class Builder(var floors: Int, var area: Double) {
        var painting: Boolean? = null
        var material: String? = null

        fun build(): House {
            return House(this)
        }
    }

    override fun toString(): String {
        return """Ваш новый дом 
            Этажей: ${this.floors}
            Площадь: ${this.area}
            Покраска: ${this.painting}
            Материал стен: ${this.material}
            """
    }
}

fun main() {

    val house1 = House.build(2, 200.0){}
    println(house1)

    // вариант создания дома с доп параметрами
    val house2 = House.build(1, 150.0) { material="кирпич"; painting=true }
    println(house2)
}