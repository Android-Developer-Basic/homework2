package src.main.kotlin.ru.otus.homework

class House

class Catalogue

interface Builder {
    fun reset()
    fun buildDoor(door:String?)
    fun buildWall(wall:String?)
    fun buildStairs(stairs:String?)
    fun buildWindow(window:String?)
    fun buildRoof(roof:String?)
}

class HouseBuilder() : Builder {
    private lateinit var house:House
    override fun reset() {
       house = House()
       println("build New House")
    }

    override fun buildDoor(door:String?) {
        println("build $door")
    }

    override fun buildWall(wall:String?) {
        println("build $wall")
    }

    override fun buildStairs(stairs:String?) {
        println("build $stairs")
    }

    override fun buildWindow(window:String?) {
        println("build $window")
    }

    override fun buildRoof(roof:String?) {
        println("build $roof")
    }

    fun getResult() : House {
        return house
    }
}

class CatalogueBuilder() : Builder {
    private lateinit var catalogue:Catalogue
    override fun reset() {
        catalogue = Catalogue()
        println("create New Catalog")
    }

    override fun buildDoor(door:String?) {
        println("add to catalog $door")
    }

    override fun buildWall(wall:String?) {
        println("add to catalog $wall")
    }

    override fun buildStairs(stairs:String?) {
        println("add to catalog $stairs ladder")
    }

    override fun buildWindow(window:String?) {
        println("add to catalog $window")
    }

    override fun buildRoof(roof:String?) {
        println("add to catalog $roof sloping tiled roof")
    }

    fun getResult() : Catalogue {
        return catalogue
    }
}

class Director() {
    fun constructCottage(builder: Builder) {
        builder.reset();
        builder.buildDoor("2 wood doors")
        builder.buildWall("4 stone wall")
        builder.buildStairs("ladder")
        builder.buildWindow("6 small window")
        builder.buildRoof("sloping tiled roof")
    }
    fun constructSkyscraper(builder: Builder) {
        builder.reset();
        builder.buildDoor("12 12 automatic glass doors")
        builder.buildWall("4 glass and concrete walls")
        builder.buildStairs("5 escalators and two fire escapes")
        builder.buildWindow("100 panoramic windows")
        builder.buildRoof("Flat roof")
    }
}

fun main() {
    val director = Director()

    var builder : Builder = HouseBuilder()
    director.constructCottage(builder)
    val house = (builder as HouseBuilder).getResult()

    builder = CatalogueBuilder()
    director.constructCottage(builder)
    val catalogue = builder.getResult()

    builder = HouseBuilder()
    director.constructSkyscraper(builder)
    val skyscraper = builder.getResult()
}