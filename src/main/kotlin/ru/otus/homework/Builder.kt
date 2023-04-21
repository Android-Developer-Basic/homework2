package ru.otus.homework

//Строитель

interface CaseBuilder {
    fun setClientName(clientName: String): CaseBuilder
    fun setCaseType(caseType: String): CaseBuilder
    fun setDescription(description: String): CaseBuilder
    fun setDate(date: String): CaseBuilder
    fun build(): LegalCase
}

data class LegalCase(
    val clientName: String,
    val caseType: String,
    val description: String,
    val date: String
) {
    override fun toString(): String {
        return "Заведено $caseType от $date на $clientName по статье $description"
    }
}

class LegalCaseBuilder : CaseBuilder {
    private lateinit var clientName: String
    private lateinit var caseType: String
    private lateinit var description: String
    private lateinit var date: String


    override fun setClientName(clientName: String): CaseBuilder {
        this.clientName = clientName
        return this
    }

    override fun setCaseType(caseType: String): CaseBuilder {
        this.caseType = caseType
        return this
    }

    override fun setDescription(description: String): CaseBuilder {
        this.description = description
        return this
    }

    override fun setDate(date: String): CaseBuilder {
        this.date = date
        return this
    }

    override fun build(): LegalCase {
        return LegalCase(clientName, caseType, description, date)
    }
}

fun main() {
    val criminalCase = LegalCaseBuilder()
        .setClientName("Иванов Иван")
        .setCaseType("Уголовное дело")
        .setDescription("Кража")
        .setDate("18.04.2023")
        .build()

    val familyCase = LegalCaseBuilder()
        .setClientName("Петров Петр")
        .setCaseType("Семейное дело")
        .setDescription("Развод")
        .setDate("25.04.2023")
        .build()

    val civilCase = LegalCaseBuilder()
        .setClientName("Сергеев Сергей")
        .setCaseType("Гражданское дело")
        .setDescription("Убытки")
        .setDate("27.04.2023")
        .build()

    val administrativeCase = LegalCaseBuilder()
        .setClientName("Николаев Николай")
        .setCaseType("Административное дело")
        .setDescription("Невменяемость")
        .setDate("30.04.2023")
        .build()

    listOf(
        criminalCase,
        familyCase,
        civilCase,
        administrativeCase
    ).forEach { println(it) }
}
