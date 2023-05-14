// class Singl {
//     object ManagerDriver{
//         init {
//             println("Manager Initialized: $this")
//         }
//         fun log():ManagerDriver = apply { println("Manager Driver: $this") }
//     }
// }

// class Test{
//     @org.junit.jupiter.api.Test
//     fun testsingl(){
//         println("Start")
//         val ManagerDriver1:Singl.ManagerDriver = Singl.ManagerDriver.log()
//         val ManagerDriver2:Singl.ManagerDriver = Singl.ManagerDriver.log()
//     }
// }

package ru.otus.empty

class Singl1 private constructor() {

    init {
        println("Singl1 done")
    }

    companion object {
        val instance: Singl1 by lazy {
            Singl1()
        }
    }


}
fun main() {

    val testSingl1 = Singl1.instance

}
