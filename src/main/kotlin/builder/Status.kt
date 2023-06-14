package builder

sealed class Status {
    object NewCustomer: Status()
    object Silver: Status() {const val discount: Double = 0.05}
    object Gold: Status() {const val discount: Double = 0.10}
    object Platinum: Status() {const val discount: Double = 0.15}
}