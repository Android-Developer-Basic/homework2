package ru.otus.homework

/**
 * Паттерн Decorator на примере шиномнтажа))
 */
interface TireService {
    fun description(): String
    fun cost(): Double
}

class ChangeTire : TireService {
    override fun description(): String {
        return "Замена колеса (снять/поставить)"
    }

    override fun cost(): Double {
        return 1000.0
    }
}

class RepairTire : TireService {
    override fun description(): String {
        return "Ремонт прокола шины"
    }

    override fun cost(): Double {
        return 300.0
    }
}

abstract class DecoratorAddService(private val service: TireService) : TireService {
    abstract override fun description(): String

    abstract override fun cost(): Double
}

class Difficult(private val service: TireService) : DecoratorAddService(service) {
    override fun description(): String {
        return service.description() + ", высокая сложность работы"
    }

    override fun cost(): Double {
        return service.cost() + 500.0
    }
}

class VipClient(private val service: TireService) : DecoratorAddService(service) {
    override fun description(): String {
        return service.description() + ", VIP"
    }

    override fun cost(): Double {
        return service.cost() + 1000.0
    }
}

fun main() {
    println("Шинка СУПЕР")
    val changeTire : TireService  = ChangeTire() // замена колес
    println("${changeTire.description()} = ${changeTire.cost()}")

    var repairTire : TireService = RepairTire() // ремонт колес
    repairTire = Difficult(repairTire)    // + сложность
    repairTire = VipClient(repairTire)    // + vip обслуживание

    println("${repairTire.description()} = ${repairTire.cost()}")
}