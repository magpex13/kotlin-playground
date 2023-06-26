val lazyValue: String by lazy {
    println("conejos?!")
    "come1"
}

class MyClass {
    lateinit var lateInitVar: String

    fun init() {
        println(this::lateInitVar.isInitialized)
        lateInitVar = "cone"
        println(this::lateInitVar.isInitialized)
    }
}

fun main(){
    println(lazyValue)
    println(lazyValue)
    
    val t1 = MyClass()
    t1.init()
}