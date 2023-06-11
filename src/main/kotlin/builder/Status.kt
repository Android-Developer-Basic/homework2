package builder

sealed class Status {
    object NewCustomer: Status()
    class Silver(val discount: Double): Status()
    class Gold(val discount: Double): Status()
    class Platinum(val discount: Double): Status()
}