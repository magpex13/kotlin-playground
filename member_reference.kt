fun isEven(num: Int): Boolean = num % 2 == 0

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}

fun main(){
    val predicate = ::isEven
    println(predicate(2))
    val predicate2 = { num: Int -> isEven(num)}
    println(predicate2(5))

    val myList = listOf(1,2,3,4)
    println(myList.any(::isEven))
    println(myList.filter(::isEven))

    val predicateIsOlder1 = Person::isOlder //Non-bound reference
    val personOlder: Person = Person("Sergio", 80)
    println(predicateIsOlder1(personOlder, 70))
    
    val predicateOlder2 = personOlder::isOlder //Bound reference
    println(predicateOlder2(60))
}