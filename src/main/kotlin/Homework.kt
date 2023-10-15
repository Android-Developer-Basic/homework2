import kotlin.system.measureTimeMillis

//Задание #1
fun task1() {
    (0..99)
        .toList() //Создайте список и заполните его целыми числами 0-99
        .filter { it % 2 == 0 } //Удаляет из цепочки все нечетные числа
        .slice(10..20) //Берет слайс с 10 по 20 элементы
        .map { it + 1 } //Добавляет к каждому элементу 1
        .sum() //Суммирует все оставшиеся числа и возвращает сумму
}

//    Задание #2

//    Реализуйте свой дата класс Person
//    Добавьте в него следующие проперти name:String, surname:String, age:Int
data class Person(val name: String, val surname: String, val age: Int)

//    Реализуйте экстеншен функцию на список типизированный Person, которая сортирует список по возрасту в порядке убывания
fun List<Person>.sortByAge(): List<Person> {
    return this.sortedByDescending { it.age }
}

//    Реализуйте экстеншен функцию на список типизированный Person,
//    которая сортирует список в алфавитном порядке по имени. Если имена одинаковые, то учитывается фамилия
fun List<Person>.sortByName(): List<Person> {
    return this.sortedWith(compareBy({ it.name }, { it.surname }))
}

//Задание #3
//Реализуйте функцию высшего порядка, которая вычисляет время выполнения функции-аргумента и возвращает результат результат в миллисекунд
fun calcFuncTime(func: ()-> Unit): Long {
    return measureTimeMillis(func)
}