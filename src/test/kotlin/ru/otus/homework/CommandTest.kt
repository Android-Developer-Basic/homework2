package ru.otus.homework

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

private const val initialEditorContent = "artem"
private const val clipboardFirstContent = "test"
private const val clipboardSecondContent = "boo"

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class CommandTest {
  private companion object {
    private val editor: Editor = Editor(initialEditorContent)
    private val invoker = EditorInvoker()
  }

  @Test
  @Order(1)
  fun shouldInitialValue() {
    assertEquals(
      initialEditorContent,
      editor.read()
    )
  }

  @Test
  @Order(2)
  fun shouldPasteFirst() {
    invoker.executeCommand(PasteCommand(editor, Clipboard(clipboardFirstContent)))

    assertEquals(
      "$initialEditorContent$clipboardFirstContent",
      editor.read()
    )
  }

  @Test
  @Order(3)
  fun shouldPasteSecond() {
    invoker.executeCommand(PasteCommand(editor, Clipboard(clipboardSecondContent)))

    assertEquals(
      "$initialEditorContent$clipboardFirstContent$clipboardSecondContent",
      editor.read()
    )
  }

  @Test
  @Order(4)
  fun shouldLastCommandUndo() {
    invoker.undoLastCommand()

    assertEquals(
      "$initialEditorContent$clipboardFirstContent",
      editor.read()
    )
  }
}