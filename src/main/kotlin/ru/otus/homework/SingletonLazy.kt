package ru.otus.homework

//Одиночка

class LawService private constructor() {

    init {
        println("LawService создан")
    }

    fun handleCriminalCase() {
        println("Обработка уголовного дела")
    }

    fun handleFamilyCase() {
        println("Обработка семейного дела")
    }

    fun handleCivilCase() {
        println("Обработка гражданского дела")
    }

    fun handleAdministrativeCase() {
        println("Обработка административного дела")
    }

    companion object {
        val instance: LawService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { LawService() }
    }
}

fun main() {
    val lawService1 = LawService.instance
    lawService1.handleCriminalCase()
    lawService1.handleFamilyCase()
    lawService1.handleCivilCase()
    lawService1.handleAdministrativeCase()

    val lawService2 = LawService.instance
    lawService2.handleCriminalCase()
    lawService2.handleFamilyCase()
    lawService2.handleCivilCase()
    lawService2.handleAdministrativeCase()

    println(lawService1 === lawService2)
}
