package singleton

class DataBaseSimpleImpl private constructor() : DataBase {

    override fun insert() {
        println("DataBaseSimple: item inserted")
    }

    override fun delete() {
        println("DataBaseSimple: item deleted")
    }

    override fun update() {
        println("DataBaseSimple: item updated")
    }

    override fun select() {
        println("DataBaseSimple: item read")
    }

    companion object {

        val INSTANCE: DataBaseSimpleImpl by lazy { DataBaseSimpleImpl() }
    }
}