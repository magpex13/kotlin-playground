fun main(){
    val a: String? = "cone"
    if(a is String) {
        println(a.length) //Smart cast
    }

    val b = a as? String //'?' retuns null
    println(b)
}