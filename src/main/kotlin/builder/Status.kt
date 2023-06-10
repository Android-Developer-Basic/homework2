package builder

sealed class Status {
    object NewCustomer: Status()
    class Silver(discount: Double): Status()
    class Gold(discount: Double): Status()
    class Platinum(discount: Double): Status()
}