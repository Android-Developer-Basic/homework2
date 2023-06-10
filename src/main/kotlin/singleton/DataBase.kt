package singleton

interface DataBase<T> {
    fun insert(item: T)
    fun delete(item: T)
    fun update(item: T)
    fun select(vararg items: T): List<T>
}

