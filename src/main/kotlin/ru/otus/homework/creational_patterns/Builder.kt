package ru.otus.homework.creational_patterns

interface Builder {
    class Mail internal constructor(
        val to: String?,
        val cc: String?,
        val title: String?,
        val message: String?,
        val important: Boolean
    )

    fun build(): Mail
    fun addTo(to: String = ""): MailBuilder
    fun addCc(cc: String = ""): MailBuilder
    fun addTitle(title: String = ""): MailBuilder
    fun addMessage(message: String = ""): MailBuilder
    fun addImportant(important: Boolean = false): MailBuilder
}

class MailBuilder : Builder {
    private var to: String = ""
    private var cc: String = ""
    private var title: String = ""
    private var message: String = ""
    private var important: Boolean = false

    override fun build(): Builder.Mail {
        if (to.isEmpty()) {
            throw RuntimeException("to property is empty")
        }

        return Builder.Mail(to, cc, title, message, important)
    }

    override fun addTo(to: String): MailBuilder {
        this.to = to
        return this
    }

    override fun addCc(cc: String): MailBuilder {
        this.cc = cc
        return this
    }

    override fun addTitle(title: String): MailBuilder {
        this.title = title
        return this
    }

    override fun addMessage(message: String): MailBuilder {
        this.message = message
        return this
    }

    override fun addImportant(important: Boolean): MailBuilder {
        this.important = important
        return this
    }
}