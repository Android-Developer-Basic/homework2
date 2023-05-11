package decorator

abstract class Lesson {
    abstract val title: String
    abstract val description: String

    abstract fun learn()

}

class EnglishLesson(override val title: String, override val description: String) : Lesson() {
    override fun learn() {
        println("изучение английского: $title  - $description")
    }
}

class SpanishLesson(override val title: String, override val description: String) : Lesson() {
    override fun learn() {
        println("изучение испанского: $title - $description")
    }
}

class VocabularyLessonDecorator(private val lesson: Lesson) : Lesson() {
    override val description: String
        get() = lesson.description
    override val title: String
        get() = lesson.title

    override fun learn() {
        lesson.learn()
        println("новые слова")
    }
}

class GrammarLessonDecorator(private val lesson: Lesson) : Lesson() {
    override val description: String
        get() = lesson.description
    override val title: String
        get() = lesson.title

    override fun learn() {
        lesson.learn()
        println("новая грамматика")
    }
}


fun main() {
    val spanish = SpanishLesson("урок 1", "введение в испанский")

    val vocabularySpanish = VocabularyLessonDecorator(spanish)
    vocabularySpanish.learn()
    val vocabularyAndGrammarSpanish = GrammarLessonDecorator(vocabularySpanish)

    vocabularyAndGrammarSpanish.learn()


}