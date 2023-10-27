package ru.otus.homework.creational_patterns

import org.junit.jupiter.api.Assertions
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class MailBuilderTest{
    @Test
    fun testMain(){
        val expectedTo = "hello@world.com"
        val expectedCc = "helloCc@world.com"
        val expectedMessage = "expectedMessage"
        val expectedTitle = "expectedTitle"
        val expectedImportant = false

        val mailBuilder = MailBuilder()
            .addTo(expectedTo)
            .addCc(expectedCc)
            .addMessage(expectedMessage)
            .addTitle(expectedTitle)
            .addImportant(expectedImportant)
            .build()

        Assertions.assertEquals(expectedTo, mailBuilder.to)
        Assertions.assertEquals(expectedCc, mailBuilder.cc)
        Assertions.assertEquals(expectedMessage, mailBuilder.message)
        Assertions.assertEquals(expectedTitle, mailBuilder.title)
        Assertions.assertEquals(expectedImportant, mailBuilder.important)
    }

    @Test
    fun textExceptionForTo(){
        assertThrows<RuntimeException>("to property is empty"){
            val mailBuilder = MailBuilder().build()
        }
    }
}