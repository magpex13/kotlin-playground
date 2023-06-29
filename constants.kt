const val cone1= 5 //compile-time constant, only primitive types

@JvmField
val cone2 = 10

class MyClass

class A {
    @JvmField //Jvmfield for objects constants
    val prop = MyClass()
}

object B {
    @JvmField
    val prop = MyClass()
}

fun main() {
    println(A().prop)
}