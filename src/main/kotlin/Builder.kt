
class House(
    val numberOfStoreys: Int?,
    val color: String?,
    val type: String?) {

    data class Builder(
        var numberOfStoreys: Int? = null,
        var color: String? = null,
        var type: String? = null) {

        fun numberOfStoreys(storey: Int) = apply { this.numberOfStoreys = storey }
        fun color(color: String) = apply { this.color = color }
        fun type(type: String) = apply { this.type = type }
        fun build() = House(numberOfStoreys, color, type)
    }
}

fun main() {
    val house = House.Builder()
        .numberOfStoreys(3)
        .color("yellow")
        .type("Country house")
        .build()

    house.hashCode()
}





