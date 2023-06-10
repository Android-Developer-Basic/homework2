import singleton.DataBase
import singleton.DataBaseSimpleImpl
import singleton.DataBaseThreadSafeImpl

fun main() {

    val dbSimple: DataBase = DataBaseSimpleImpl.INSTANCE
    dbSimple.insert()
    
    val dbThreadSafe: DataBase = DataBaseThreadSafeImpl.getInstance()
    dbThreadSafe.select()
}