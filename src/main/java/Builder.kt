class Builder {

    class Stairs(
        val numberOfStairs: Int?,
        val length: Int?,
        val width: Int?,
        val height: Int?,
        val color: String?,
        val floor: Boolean?) {

        data class StairsBuilder(
            var numberOfStairs: Int? = null,
            var length: Int? = null,
            var width: Int? = null,
            var height: Int? = null,
            var color: String? = null,
            var floor: Boolean? = false) {

            fun numberOfStairs (number: Int) = apply { this.numberOfStairs = number }
            fun length (number: Int) = apply { this.length = number }
            fun width (number: Int) = apply { this.width = number }
            fun height (number: Int) = apply { this.height = number }
            fun color(color: String) = apply { this.color = color }
            fun floor(floor: Boolean) = apply { this.floor = floor }
            fun build() = Stairs(numberOfStairs, length, width, height, color, floor)
        }
    }

    fun main() {
        val myStairs = Stairs.StairsBuilder()
            .numberOfStairs(3)
            .length(150)
            .width(30)
            .height(18)
            .color("brown")
            .floor(true)
            .build()
    }


}