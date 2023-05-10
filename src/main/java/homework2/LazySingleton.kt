package homework2

class LazySingleton private constructor(){
    var someStringValue = "Just a singleton string value"
    var someMutableMap = mutableMapOf(1 to "One")
    companion object {
        val classObject by lazy {
            println("Lazy init")
            LazySingleton()
        }
    }

    init {
        println("LazySingleton primary constructor")
    }
}

object LazySingletonObject{
    var someStringValue = "Just a singleton object string value"
    var someMutableMap = mutableMapOf(1 to "One")

    init {
        println("LazySingleton object primary constructor")
    }
}

fun main()
{
    println("*-----------Space-----------*")
    //-----------------------------------Первый вариант реализации синглтона----------------------------------------------------//
    println(LazySingleton.classObject.someStringValue)//Тут можно заметить, что синглтон инициализируется при первом обращении
    println(LazySingleton.classObject.someMutableMap)
    val temporaryObject = LazySingleton.classObject//Запоминаем объект перед изменениями
    LazySingleton.classObject.someStringValue = "New singleton string value"
    LazySingleton.classObject.someMutableMap.putAll(setOf(2 to "Two", 3 to "Three", 4 to "Four"))
    if(LazySingleton.classObject == temporaryObject)
        println("Object temporaryValue equals base singleton object")
    println("Map values of temporaryObject = ${temporaryObject.someMutableMap}; and string value = ${temporaryObject.someStringValue}")

    //-----------------------------------Второй вариант реализации синглтона----------------------------------------------------//
    println("*-----------Space-----------*")
    println(LazySingletonObject.someStringValue)//Тут можно заметить, что синглтон инициализируется при первом обращении
    println(LazySingletonObject.someMutableMap)
    val temporaryObjectSecond = LazySingletonObject//Запоминаем объект перед изменениями
    LazySingletonObject.someStringValue = "New singleton object string value"
    LazySingletonObject.someMutableMap.putAll(setOf(5 to "Five", 6 to "Six", 7 to "Seven"))
    if(LazySingletonObject == temporaryObjectSecond)
        println("Object temporaryObjectSecond equals base singleton object")
    println("Map values of temporaryObjectSecond = ${temporaryObjectSecond.someMutableMap}; and string value = ${temporaryObjectSecond.someStringValue}")
    println("*-----------Space-----------*")
}