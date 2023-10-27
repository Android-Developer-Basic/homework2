package ru.otus.homework.team

class RemoteControl (private val command: Command) {
    fun pressButton() {
        command.execute()
    }
}