package ru.otus.homework2

//реализация паттерна Decorator

interface Artist {
    fun perform()
}

class Musician: Artist{
    override fun perform() {
        println("Let's get this party started!!!\n")
    }
}

open class MusicDecorator(private val artist: Artist): Artist {
    override fun perform(){
        artist.perform()
    }
}

class Guitarist(artist: Artist): MusicDecorator(artist) {
    override fun perform() {
        super.perform()
        println("My guitar gently weeps...")
    }
}

class Bluesman(artist: Artist): MusicDecorator(artist) {
    override fun perform() {
        super.perform()
        println("Give me something to sing!")
    }
}

fun main() {
    val johnLeeHooker: Artist = Guitarist(Bluesman(Musician()))
    johnLeeHooker.perform()
}