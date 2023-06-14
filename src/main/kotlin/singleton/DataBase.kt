package singleton

interface DataBase<T> {
    fun insert(item: T)
    fun delete(id: Int)
    fun update(item: T)
    fun select(id: Int): T
}

