//Singleton in Kotlin
object User {
    val name: String = "Cone"
}

interface TestInterface1<T> {
    fun test1(): T
}

class A {
    companion object: TestInterface1<Int> {
        fun foo() = 1
        override fun test1() = 4
    }
}

interface Factory<T> {
    fun create(): T
}

//static functions on Kotlin doesn't exists, use companion object instead
class B {
    private constructor()
    companion object: Factory<B> {
        override fun create() = B() //In Java call this by B.Companion.create()
    }
}

class C {
    object Test1 {
        fun foo() = 5
    }
}

fun main() {
    println(User.name)
    println(A.foo())
    println(A.test1())
    println(B.create())
    println(C.Test1.foo())
}