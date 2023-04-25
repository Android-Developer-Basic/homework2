package ru.otus.homework
import java.util.Stack

class Button() {
    private lateinit var command : Unit

    fun click(){
        command
    }

    fun setCommand(com: Unit) {
        command = com
    }
}

class ShortCut() {

}

object MyApplication {
    lateinit var clipboard: String
    private lateinit var activeEditor: MyEditor
    private val history: Stack<Command> = Stack()
    val copyButton : Button = Button()
    val cutButton : Button = Button()
    val pasteButton : Button = Button()
    val undoButton : Button = Button()

    fun createUI(){
        activeEditor = MyEditor()
        activeEditor.text = "simple editor"
        activeEditor.selection = "editor"

        commandExecute(CopyCommand(this, activeEditor))
        val copy = Unit
        copyButton.setCommand(copy)
        commandExecute(CutCommand(this, activeEditor))
        val cut = Unit
        cutButton.setCommand(cut)
        commandExecute(PasteCommand(this, activeEditor))
        val paste = Unit
        pasteButton.setCommand(paste)
        commandExecute(UndoCommand(this, activeEditor))
        val undo = Unit
        undoButton.setCommand(undo)
    }

    private fun commandExecute(command: Command){
        if (command.execute())
            history.push(command)
    }

    fun undo() {
        if (history.isEmpty())
            return
        history.pop()?.undo()
    }
}

class MyEditor() {
    fun deleteSelection() {
        text.replace(selection,"")
    }

    fun replaceSelection(clipboard: String) {
        text.replace(selection,clipboard)
    }

    lateinit var selection: String
    lateinit var text: String
}

abstract class Command(protected val app: MyApplication, protected val editor: MyEditor) {
    lateinit var backup: String

    fun saveBackup() {
        backup = editor.text
    }

    fun undo() {
        editor.text = backup
    }

    abstract fun execute() : Boolean
}

class CopyCommand(app: MyApplication, editor: MyEditor) : Command(app, editor) {
    override fun execute(): Boolean {
        app.clipboard = editor.selection
        return false
    }
}

class CutCommand(app: MyApplication, editor: MyEditor) : Command(app, editor){
    override fun execute(): Boolean {
        saveBackup()
        app.clipboard = editor.selection
        editor.deleteSelection()
        return true
    }
}

class PasteCommand(app: MyApplication, editor: MyEditor) : Command(app, editor) {
    override fun execute(): Boolean {
        saveBackup()
        editor.replaceSelection(app.clipboard)
        return true
    }
}

class UndoCommand(app: MyApplication, editor: MyEditor) : Command(app, editor) {
    override fun execute(): Boolean {
        app.undo()
        return false
    }
}

fun main(){
    MyApplication.createUI()
    MyApplication.copyButton.click()
}