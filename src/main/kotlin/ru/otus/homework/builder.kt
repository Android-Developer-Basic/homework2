package ru.otus.homework

class Notification private constructor(
  val iconRes: String?,
  val title: String,
  val subTitle: String?,
) {
  data class Builder(
    var iconRes: String? = null,
    var title: String? = null,
    var subTitle: String? = null,
  ) {
    fun iconRes(iconRes: String) = apply {
      this.iconRes = iconRes
    }
    fun title(title: String) = apply {
      this.title = title
    }
    fun subTitle(subTitle: String) = apply {
      this.subTitle = subTitle
    }

    fun build() = Notification(
      iconRes = iconRes,
      title = title ?: "",
      subTitle = subTitle
    )
  }
}

fun main() {
  val notification = Notification.Builder()
    .title("test notification title")
    .subTitle("test notification subtitle")
    .build()

  println("Result notification iconRes: ${notification.iconRes}, title: ${notification.title}, subTitle: ${notification.subTitle}")
}