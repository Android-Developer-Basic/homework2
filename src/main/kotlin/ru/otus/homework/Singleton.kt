package ru.otus.homework

class Singleton private constructor(){
    private lateinit var list: MutableList<String>
    fun addValue(str: String) {
        list.add(str)
    }

    companion object {
        var tempObj: Singleton? = null
        fun getInstance() : Singleton {
            tempObj?.let {
                return it
            }
            val instance = Singleton()
            instance.list = mutableListOf<String>()
            tempObj = instance
            return instance
        }
    }
    fun show() {
        for (str in list) {
            println(str)
        }
    }
}

object SingleTon2 {
    private var list: MutableList<String> = mutableListOf<String>()
    fun addValue(str: String) {
        list.add(str)
    }
    fun show() {
        for (str in list) {
            println(str)
        }
    }
}

fun main() {
    //используем класс с подробной реализацией
    val db = Singleton.getInstance()
    db.addValue("Denis")
    db.addValue("Ivan")
    val db2 = Singleton.getInstance()
    db2.addValue("Petya")
    db2.show()

    //используем в стиле котлин
    val dbKotlin = SingleTon2
    dbKotlin.addValue("Java")
    val dbKotlin2 = SingleTon2
    dbKotlin2.addValue("Kotlin")
    dbKotlin2.show()
}