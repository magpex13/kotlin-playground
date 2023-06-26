data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender {
    MALE,
    FEMALE
}

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE), 
        Hero("The Kid", 9, null), 
        Hero("Lady Lauren", 29, Gender.FEMALE), 
        Hero("First Mate", 29, Gender.MALE), 
        Hero("Sir Stephen", 37, Gender.MALE)
    )

    println(heroes.last().name)
    println(heroes.firstOrNull { it.age == 30 }?.name)
    println(heroes.map { it.age }.distinct().size)
    println(heroes.filter { it.age < 30 }.size)
    
    val(youngest, oldest) = heroes.partition { it.age < 30 }
    println("Young people: ${youngest.size}")
    println("Old people: ${oldest.size}")

    println(heroes.maxBy { it.age }?.name)
    println(heroes.all { it.age < 50 })
    println(heroes.any { it.gender == Gender.FEMALE })

    val grouped: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age, group) = grouped.maxBy { (_, group) -> group.size }
    println(age)

    val associated = heroes.associateBy { it.name }
    println(associated["Frenchy"]?: "")
    val unknowHero = Hero("Unknow", 0, null)
    println(associated.getOrElse("Unknow") { unknowHero }.age)
    
    val (first, second) = heroes
                            .flatMap { first -> heroes.map { second -> first to second } }
                            .maxBy { it.first.age - it.second.age }!!
    println(first.name)

    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    println(isEven(3))

    run { println("#") }

    val f: (() -> Int)? = null
    if(f != null) {
        println(f())
    }

    val f2: (() -> Int)? = null
    println(f2?.invoke())

    println(listOf(1,2,3,4,5).flatMap l@{ 
        if(!isEven(it)) return@l listOf<Boolean>()
        listOf(it)
    })
}