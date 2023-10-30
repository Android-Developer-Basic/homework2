package ru.otus.homework

interface Logger {
  fun log(text: String)
}

class PrintLogger : Logger {
  override fun log(text: String) {
    println(text)
  }
}

class MapLoggerDecorator<K, V>(
  private val map: MutableMap<K, V> = mutableMapOf(),
  private val logger: Logger,
): MutableMap<K, V> by map {
  override fun put(key: K, value: V): V? {
    return map.put(key, value).apply {
      logger.log("MapLoggerDecorator putted key: $key, value: $value. Result map: $map")
    }
  }
}

fun main() {
  val mapLoggerDecorator = MapLoggerDecorator<String, String>(
    logger = PrintLogger(),
  )
  mapLoggerDecorator["artem"] = "tim"
  mapLoggerDecorator["andrey"] = "drew"
  mapLoggerDecorator["alexei"] = "alex"
}