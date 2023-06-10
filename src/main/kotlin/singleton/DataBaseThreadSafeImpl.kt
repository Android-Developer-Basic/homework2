package singleton

import builder.Customer

class DataBaseThreadSafeImpl private constructor() : DataBase<Customer> {

    private var list: MutableList<Customer> = mutableListOf()

    override fun insert(item: Customer) {
        if (list.add(item)) {
            println("DataBaseSimple: $item inserted")
        }
    }

    override fun delete(item: Customer) {
        if (list.remove(item)) {
            println("DataBaseSimple: $item deleted")
        }
    }

    override fun update(item: Customer) {
        val newList = list.map {
            if (it.id == item.id)
                it.copy(
                    it.id,
                    item.name,
                    item.age,
                    item.status)
            else it
        }
        list = newList.toMutableList()
        println("DataBaseSimple: $item updated")
    }

    override fun select(vararg items: Customer): List<Customer> {
        val result = mutableListOf<Customer>()
        items.forEach {
            if (list.contains(it)) {
                result.add(it)
            }
        }
        return result
    }

    companion object {
        @Volatile
        private var instance: DataBaseThreadSafeImpl? = null

        fun getInstance(): DataBaseThreadSafeImpl {
            return instance ?: synchronized(DataBaseThreadSafeImpl) {
                instance ?: DataBaseThreadSafeImpl().also { dataBase ->
                    instance = dataBase
                }
            }
        }
    }
}