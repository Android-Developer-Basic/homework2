interface Calculate {
    var result: Number
    fun exec()
}

class Sum(var num1: Int, var num2: Int): Calculate {
    override var result: Number = 0

    override fun exec() {
        result = num1 + num2
    }
}

class Multiply(var num1: Double, var num2: Double): Calculate {
    override var result: Number = 0

    override fun exec() {
        result = num1 * num2
    }
}

class CalculatorInvoker {
    private var lock = Any()
    private var queue = mutableListOf<Calculate>()

    fun calculate(procedure: Calculate) {
        queue.add(procedure)
        if (queue.size >= 9) {
            synchronized(lock) {
                exec()
            }
        }
    }
    private fun exec() {
        queue.forEach {it.exec()}
        queue.clear()
    }
}

class Worker() {
    var invoker = CalculatorInvoker()
    var sum = Sum(1, 7)
    var multiply = Multiply(1.0, 9.0)

    fun start() {
        invoker.calculate(sum)
        invoker.calculate(multiply)
    }
}