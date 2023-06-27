package myclass

import myclass.Color.*

enum class Color {
    ORANGE,
    BLUE,
    RED
}

enum class Color2(val r: Int, val g: Int, val b: Int) {
    ORANGE(255,0,0),
    BLUE(0,255,0),
    RED(0,0,255);

    fun rgb() = (r * 255 + g) * 256 + b
}

fun getDescription(color: Color): String =
    when(color) {
        ORANGE -> "mind"
        BLUE -> "cold"
        RED -> "hot"
    }

data class Contact(val name: String, val address: String)

class Foo(val first: Int, val second: Int)

fun main(){
    println(getDescription(ORANGE))
    println(Color2.ORANGE.r)
    println(Color2.ORANGE.rgb())
    
    val contact = Contact("conejo1", "Las zanahoras 123")
    println(contact.copy(address="Las zanahorias 321"))

    val f1 = Foo(0, 1)
    val f2 = Foo(0, 1)
    println(f1 == f2) //false

    val c1 = Contact("cone1", "a")
    val c2 = Contact("cone1", "a")
    println(c1 == c2) //true
}