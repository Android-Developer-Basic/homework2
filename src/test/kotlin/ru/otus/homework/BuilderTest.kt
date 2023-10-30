package ru.otus.homework

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

private const val notificationTitle = "test notification title"
private const val notificationSubTitle = "test notification subtitle"

class BuilderTest {
  private companion object {
    val notification = Notification.Builder()
      .title(notificationTitle)
      .subTitle(notificationSubTitle)
      .build()
  }

  @Test
  fun notificationIconRes() {
    assertNull(notification.iconRes)
  }

  @Test
  fun notificationTitle() {
    assertEquals(
      notificationTitle,
      notification.title
    )
  }

  @Test
  fun notificationSubTitle() {
    assertEquals(
      notificationSubTitle,
      notification.subTitle
    )
  }
}