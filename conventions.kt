data class Contact(val name: String, val email: String, val phoneNumber: String)

data class Value(val s: String)

fun equals1(v1: Value?, v2: Value?): Boolean {
    return v1 == v2
}

fun equals2(v1: Value?, v2: Value?): Boolean {
    if(v1 !== null) {
        return v1.equals(v2)
    }

    return v2 === null
}

fun equals3(v1: Value?, v2: Value?): Boolean = v1?.equals(v2) ?: (v2 === null)

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}

fun main() {
    val (name, _, phoneNumber) = Contact("Conejo1", "conejo@rabbits.com", "1234556")
    println(name)
    println(phoneNumber)

    equals1(Value("abc"), Value("abc")) eq true
    equals1(Value("abc"), null) eq false
    equals1(null, Value("abc")) eq false
    equals1(null, null) eq true

    equals2(Value("abc"), Value("abc")) eq true
    equals2(Value("abc"), null) eq false
    equals2(null, Value("abc")) eq false
    equals2(null, null) eq true

    equals3(Value("abc"), Value("abc")) eq true
    equals3(Value("abc"), null) eq false
    equals3(null, Value("abc")) eq false
    equals3(null, null) eq true
}