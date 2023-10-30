import java.util.WeakHashMap

interface Calculator {
    fun sum(i: Int, j: Int): Int
}

class BaseCalculator : Calculator {
    override fun sum(i: Int, j: Int): Int {
        return i + j
    }
}

class FastCalculator(private var calculator: Calculator): Calculator {
    override fun sum(i: Int, j: Int): Int {
        System.out.println("sum is ${i + j}") // logging for example. Hard to create smthng unique as example (
        return calculator.sum(i, j)
    }

}