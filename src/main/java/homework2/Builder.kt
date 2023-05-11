package homework2

enum class Education(val type: String){
    None("Отсутствует"),
    Secondary("Среднее"),
    Higher("Высшее")
}
enum class Skill(val type: String){
    Student("Студент"),
    Junior("Джун"),
    Middle("Хороший программист"),
    Senior("Отец")
}

interface Builder
{
    fun name(value: String) : Builder
    fun education(value: Education) : Builder
    fun skill(value: Skill) : Builder
    fun age(value: Int) : Builder
    fun requiredSalary(value: Int) : Builder
    fun build():Progger
}

class Progger : Builder  {
    fun validateProgger(needSkill: Skill, moneyAvailable: Int) : String{
        return when{
            (name == "") -> "Имя не указано, о ком речь?"
            ((skill.ordinal >= needSkill.ordinal) and (education.ordinal >= Education.Secondary.ordinal) and (requiredSalary <= moneyAvailable)) -> "Принимаем"
            else -> "Перезвоним"
        }
    }

    fun information(): String {
        return "Имя: ${name}\nОбразование: ${education.type}\nУровень: ${skill.type}\nВозраст: ${age}\nТребуемая ЗП: ${requiredSalary}\n"
    }

    var name : String = ""
    var education  : Education = Education.None
    var skill: Skill = Skill.Student
    var age : Int = -1
    var requiredSalary : Int = 0


    override fun name(value: String) = apply { name = value }
    override fun education(value: Education) = apply { education = value }
    override fun skill(value: Skill) = apply { skill = value }
    override fun age(value: Int) = apply { age = value }
    override fun requiredSalary(value: Int) = apply { requiredSalary = value }
    override fun build() = Progger().name(name).age(age).education(education).skill(skill).requiredSalary(requiredSalary)
}

fun main() {
    println("-----------------------------")
    val builder = Progger()
        .name("Семён Слепаков")
        .age(25)
        .education(Education.Secondary)
        .skill(Skill.Senior)
        .requiredSalary(125444)

    val progger1 = builder.build()
    val progger2 = builder.build()
    println("-----------------------------")
    println(progger1.information())
    println(progger1.validateProgger(Skill.Senior, 123123))
    println("-----------------------------")
    println(progger2.information())
    println(progger2.validateProgger(Skill.Senior, 321321))

    println("-----------------------------")
    val firstProgger = Progger()
        .name("Сергей Антипов")
        .age(25)
        .education(Education.Secondary)
        .skill(Skill.Senior)
        .requiredSalary(250000)
        .build()

    println(firstProgger.information())
    println(firstProgger.validateProgger(Skill.Senior, 400000))
    println("-----------------------------")

    val secondProgger = Progger()
        .name("Василий Прошкин")
        .age(44)
        .education(Education.Higher)
        .skill(Skill.Senior)
        .requiredSalary(160000)
        .build()

    println(secondProgger.information())
    println(secondProgger.validateProgger(Skill.Middle, 170000))

    println("-----------------------------")

    val thirdProgger = Progger()
        .name("Андрей Петрушкин")
        .age(37)
        .education(Education.None)
        .skill(Skill.Junior)
        .requiredSalary(75000)
        .build()

    println(thirdProgger.information())
    println(thirdProgger.validateProgger(Skill.Junior, 100000))
    println("-----------------------------")
}