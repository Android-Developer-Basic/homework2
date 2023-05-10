class Singl {
    object ManagerDriver{
        init {
            println("Manager Initialized: $this")
        }
        fun log():ManagerDriver = apply { println("Manager Driver: $this") }
    }
}

class Test{
    @org.junit.jupiter.api.Test
    fun testsingl(){
        println("Start")
        val ManagerDriver1:Singl.ManagerDriver = Singl.ManagerDriver.log()
        val ManagerDriver2:Singl.ManagerDriver = Singl.ManagerDriver.log()
    }
}
