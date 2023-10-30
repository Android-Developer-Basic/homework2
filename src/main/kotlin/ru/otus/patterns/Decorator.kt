package ru.otus.patterns

import kotlin.random.Random

fun main() {
    WithRepeat(PhoneInstance()).makeCall()
}


interface Phone {
    fun makeCall(): Boolean
}


class PhoneInstance() : Phone {
    override fun makeCall(): Boolean {
        println("Try calling...")

        val success = Random.nextInt(0, 10)
        return success == 1
    }
}


class WithRepeat(private val phone: PhoneInstance) : Phone {
    override fun makeCall(): Boolean {
        fun trying() {
            val success = phone.makeCall()

            if (!success) {
                println("Error Call")
                println("Calling a second time")
                trying()
            }
        }

        trying()

        return true
    }
}


