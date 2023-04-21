package ru.otus.homework

//Декоратор

interface LegalService {
    fun handleCase()
}

class CriminalService : LegalService {
    override fun handleCase() {
        println("Обработка уголовного дела")
    }
}

class FamilyService : LegalService {
    override fun handleCase() {
        println("Обработка семейного дела")
    }
}

abstract class LegalServiceDecorator(private val legalService: LegalService) : LegalService {
    override fun handleCase() {
        legalService.handleCase()
    }
}

class UrgentCaseDecorator(legalService: LegalService) : LegalServiceDecorator(legalService) {
    private fun markAsUrgent() {
        println("Дело помечено срочным")
    }

    override fun handleCase() {
        markAsUrgent()
        super.handleCase()
    }
}

class ConfidentialCaseDecorator(legalService: LegalService) : LegalServiceDecorator(legalService) {
    private fun applyConfidentiality() {
        println("Дело обрабатывается конфиденциально")
    }

    override fun handleCase() {
        applyConfidentiality()
        super.handleCase()
    }
}

fun main() {
    val criminalService = CriminalService()
    val urgentCriminalService = UrgentCaseDecorator(criminalService)
    val familyService = FamilyService()
    val confidentialFamilyService = ConfidentialCaseDecorator(familyService)
    val urgentConfidentialFamilyService = UrgentCaseDecorator(confidentialFamilyService)

    urgentCriminalService.handleCase()
    println()
    confidentialFamilyService.handleCase()
    println()
    urgentConfidentialFamilyService.handleCase()
}

