package command

interface Command<R> {
    fun execute(): R
}