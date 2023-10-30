package ru.otus.homework

interface Command {
  fun execute()
  fun undo()
}

data class Clipboard(var content: String = "")

class Editor(initialContent: String) {
  private var content = initialContent

  fun write(text: String) {
    content += text
  }

  fun remove(text: String) {
    content = content.removeSuffix(text)
  }

  fun read(): String = content
}

class PasteCommand(
  private val editor: Editor,
  private val clipboard: Clipboard,
) : Command {
  override fun execute() {
    editor.write(clipboard.content)
  }

  override fun undo() {
    editor.remove(clipboard.content)
  }
}

class EditorInvoker {
  private val commandsCache = mutableListOf<Command>()

  fun executeCommand(command: Command) {
    commandsCache.add(command)
    command.execute()
  }

  fun undoLastCommand() {
    if (commandsCache.isNotEmpty()) {
      commandsCache.removeLast().undo()
    }
  }
}

fun main() {
  val editor = Editor("artem")
  val invoker = EditorInvoker()

  println("initial editor: ${editor.read()}")

  invoker.executeCommand(PasteCommand(editor, Clipboard("test")))
  invoker.executeCommand(PasteCommand(editor, Clipboard("boo")))

  println("after paste: ${editor.read()}")

  invoker.undoLastCommand()

  println("after undo: ${editor.read()}")
}