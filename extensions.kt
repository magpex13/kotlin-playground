fun String.toConejo() = this + "conejos"

fun String.repeat(n: Int): String {
    var concatenatedString: String = ""
    for(i in 1..n) {
        concatenatedString += this
    }

    return concatenatedString
}

open class Parent
class Child: Parent()

fun Parent.foo() = "abc"
fun Child.foo() = "cba"

fun String.get(i: Int) = "conejo"

fun main() {
    println("hola ".toConejo())
    println("hola".repeat(5))

    val parent: Parent = Child()
    println(parent.foo()) //abc

    println("con".get(2)) //n
}
