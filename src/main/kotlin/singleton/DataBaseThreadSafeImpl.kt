package singleton

import builder.Customer

class DataBaseThreadSafeImpl private constructor() : DataBase<Customer> {

    private var list: MutableList<Customer> = mutableListOf()

    override fun insert(item: Customer) {
        if (list.add(item)) {
            println("DataBaseThreadSafe: $item inserted")
        }
    }

    override fun delete(id: Int) {
        list = list.filter { customer -> customer.id != id }.toMutableList()
        println("DataBaseThreadSafe: item with id $id deleted")
    }

    override fun update(item: Customer) {
        val newList = list.map { customer ->
            if (customer.id == item.id)
                customer.copy(
                    customer.id,
                    item.name,
                    item.age,
                    item.status
                )
            else customer
        }
        list = newList.toMutableList()
        println("DataBaseThreadSafe: $item updated")
    }

    override fun select(id: Int): Customer {
        return list.find { customer -> customer.id == id } ?: error("Customer not found")
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