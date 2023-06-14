package singleton

import builder.Customer

class DataBaseLazyThreadSafeImpl private constructor() : DataBase<Customer> {

    private var _list: MutableList<Customer> = mutableListOf()
    val list: List<Customer> get() = _list

    override fun insert(item: Customer) {
        if (_list.add(item)) {
            println("DataBaseSimple: $item inserted")
        }
    }

    override fun delete(id: Int) {
        _list = _list.filter { customer -> customer.id != id }.toMutableList()
        println("DataBaseSimple: item with id $id deleted")
    }

    override fun update(item: Customer) {
        val newList = _list.map { customer ->
            if (customer.id == item.id)
                customer.copy(
                    customer.id,
                    item.name,
                    item.age,
                    item.status
                )
            else customer
        }
        _list = newList.toMutableList()
        println("DataBaseSimple: $item updated")
    }

    override fun select(id: Int): Customer {
        return _list.find { customer -> customer.id == id } ?: error("Customer not found")
    }

    companion object {
        val INSTANCE: DataBaseLazyThreadSafeImpl by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { DataBaseLazyThreadSafeImpl() }
    }
}