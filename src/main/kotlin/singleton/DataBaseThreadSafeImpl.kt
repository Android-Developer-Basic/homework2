package singleton

class DataBaseThreadSafeImpl private constructor() : DataBase {
    override fun insert() {
        println("DataBaseThreadSafe: item inserted")
    }

    override fun delete() {
        println("DataBaseThreadSafe: item deleted")
    }

    override fun update() {
        println("DataBaseThreadSafe: item updated")
    }

    override fun select() {
        println("DataBaseThreadSafe: item selected")
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