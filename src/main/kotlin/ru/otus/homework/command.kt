package ru.otus.homework

/**
 * Паттерн Command
 */

interface Command {
    fun execute()
}

class OpenCommand(val device: Device) : Command {
    override fun execute() {
        device.unlockDevice()
    }
}
class LockAllCommand(val device: ArrayList<Device>) : Command {
    override fun execute() {
        device.forEach { it.lockDevice() }
    }
}


interface Device {
    fun unlockDevice()
    fun lockDevice()
}

class Safe : Device {
    override fun unlockDevice() {
        println("Сейф открыт")
    }

    override fun lockDevice() {
        println("Сейф закрыт")
    }
}


class SmartDoor : Device {
    override fun unlockDevice() {
        println("Дверь разблокирована")
    }

    override fun lockDevice() {
        println("Дверь заблокирована")
    }
}

class Switcher(var c:Command) {
    fun accept() {
        c.execute()
    }
}

fun main() {
    val safeDevice : Device = Safe()     // сейф
    val cmdOpenSafe = OpenCommand(safeDevice)
    val switcherSafe = Switcher(cmdOpenSafe)
    switcherSafe.accept() // откроем сейф

    val smartDoor : Device = SmartDoor() // умная дверь
    val cmdOpenDoor = OpenCommand(smartDoor)
    val switcherDoor = Switcher(cmdOpenDoor)
    switcherDoor.accept() // откроем дверь

    // все сразу закроем
    val allDevices = ArrayList<Device>()
    allDevices.add(safeDevice)
    allDevices.add(smartDoor)
    val cmdAllLock = LockAllCommand(allDevices)
    val switchAll = Switcher(cmdAllLock)
    switchAll.accept()
}