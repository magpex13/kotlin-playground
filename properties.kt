enum class Gender {
    MALE,
    FEMALE
}

interface User {
    val nickname: String
}

class Person(val name: String, val age: Int): User {
    private var boolGender: Boolean = false
    val isOlder: Boolean 
        get() {
            return age >= 80
        }
    var gender: Gender = Gender.FEMALE
        get() = if(boolGender) Gender.FEMALE else Gender.MALE
        set(value) {
            println("Change value from $field to $value")
            field = value
        }

    override val nickname: String
        get() = name.substring(1)
}

val test1: Boolean
    get() {
        return true
    }

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main(){
    val per1 = Person("cone1", 15)
    println(per1.isOlder)
    println(test1)
    per1.gender = Gender.MALE
    println(per1.gender)
    println(per1.nickname)

    val sb = StringBuilder("Conejos?")
    sb.lastChar = '!'
    println(sb)
}