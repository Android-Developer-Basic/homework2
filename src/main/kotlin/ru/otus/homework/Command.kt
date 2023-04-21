package ru.otus.homework

//Команда

interface Command {
    fun execute()
}

class LawOrganization {
    fun handleCriminalCase() {
        println("Обработка уголовного дела.")
    }

    fun handleFamilyCase() {
        println("Обработка семейного дела.")
    }

    fun handleCivilCase() {
        println("Обработка гражданского дела.")
    }

    fun handleAdministrativeCase() {
        println("Обработка административного дела.")
    }
}

class CriminalCaseCommand(private val lawOrganization: LawOrganization) : Command {
    override fun execute() {
        lawOrganization.handleCriminalCase()
    }
}

class FamilyCaseCommand(private val lawOrganization: LawOrganization) : Command {
    override fun execute() {
        lawOrganization.handleFamilyCase()
    }
}

class CivilCaseCommand(private val lawOrganization: LawOrganization) : Command {
    override fun execute() {
        lawOrganization.handleCivilCase()
    }
}

class AdministrativeCaseCommand(private val lawOrganization: LawOrganization) : Command {
    override fun execute() {
        lawOrganization.handleAdministrativeCase()
    }
}


class CaseInvoker(var command: Command) {
    fun executeCommand() {
        command.execute()
    }
}

fun main() {
    val lawOrganization = LawOrganization()

    val criminalCaseCommand = CriminalCaseCommand(lawOrganization)
    val familyCaseCommand = FamilyCaseCommand(lawOrganization)
    val civilCaseCommand = CivilCaseCommand(lawOrganization)
    val administrativeCaseCommand = AdministrativeCaseCommand(lawOrganization)

    val caseInvoker = CaseInvoker(criminalCaseCommand)
    caseInvoker.executeCommand()

    caseInvoker.command = familyCaseCommand
    caseInvoker.executeCommand()

    caseInvoker.command = civilCaseCommand
    caseInvoker.executeCommand()

    caseInvoker.command = administrativeCaseCommand
    caseInvoker.executeCommand()
}
