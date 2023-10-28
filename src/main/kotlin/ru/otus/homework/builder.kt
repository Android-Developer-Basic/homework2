package ru.otus.homework

/**
 * Паттерн Builder
 */
open class HouseBuilder {
    private var floors: Int? = null
    private var area: Double? = null
    private var painting: Boolean? = null
    private var material: String? = null

    fun setFloors(i: Int){
        this.floors=i
    }
    fun getFloors(): Int?{
        return this.floors
    }
    fun setArea(d: Double){
        this.area=d
    }
    fun getArea(): Double?{
        return this.area
    }
    fun setPainting(b: Boolean){
        this.painting=b
    }
    fun getPainting(): Boolean? {
        return this.painting
    }
    fun setMaterial(s: String){
        this.material=s
    }
    fun getMaterial(): String? {
        return this.material
    }
}

class House(var houseBuilder: HouseBuilder) {
    fun build(): String {
        return """Ваш новый дом 
            Этажей: ${houseBuilder.getFloors()}
            Площадь: ${houseBuilder.getArea()}
            Покраска: ${houseBuilder.getPainting()}
            Материал стен: ${houseBuilder.getMaterial()}
            """
    }
}

fun main() {
    val builder = HouseBuilder()
    builder.setFloors(2)
    builder.setArea(230.4)
    builder.setMaterial("кирпич")

    val house = House(builder)
    println( house.build() )
}