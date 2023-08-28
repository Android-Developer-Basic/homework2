class Command {

    interface Command {
        fun execute()
    }

    class DummyManager {
        fun copyDocuments() {
            println("Снова эти бумажки...") }

        fun bossyTeam() {
            println("Какие проблемы? Когда будет готово?") }

        fun clientChat() {
            println("Да-да, завтра всё сделаем.") }

        fun findResouces() {
            println("Мне бы еще одного разработчика...") }

        fun calculateBudget() {
            println("Опять денег нет!") }
    }

    class CopyDocumentsCommand(private val dummyManager: DummyManager) : Command {
        override fun execute() {
            dummyManager.copyDocuments()
        }
    }
    class BossyTeamCommand(private val dummyManager: DummyManager) : Command {
        override fun execute() {
            dummyManager.bossyTeam()
        }
    }
    class ClientChatCommand(private val dummyManager: DummyManager) : Command {
        override fun execute() {
            dummyManager.clientChat()
        }
    }
    class FindResourcesCommand(private val dummyManager: DummyManager) : Command {
        override fun execute() {
            dummyManager.findResouces()
        }
    }
    class CalculateBudgetCommand(private val dummyManager: DummyManager) : Command {
        override fun execute() {
            dummyManager.calculateBudget()
        }
    }

    class ManagerInvoker {
        private val commands = mutableListOf<Command>()

        fun executeCommand(command: Command) {
            commands.add(command)
            command.execute()
        }
    }


    fun main() {
        val manager = DummyManager()
        val invoker = ManagerInvoker()

        invoker.executeCommand(CopyDocumentsCommand(manager))
        invoker.executeCommand(BossyTeamCommand(manager))
        invoker.executeCommand(ClientChatCommand(manager))
        invoker.executeCommand(FindResourcesCommand(manager))
        invoker.executeCommand(CalculateBudgetCommand(manager))
    }

}