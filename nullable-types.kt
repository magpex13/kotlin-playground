fun main() {
    val cone1: String? = null
    if(cone1 != null) {
        println(cone1 + "ga") //Smart cast
    }

    val cone2: String? = "coga"
    val cone2dereference: String = cone2 ?: "na"
    println(cone2dereference)

    val cone3: String = "gasu"
    val cone3dereference: String = if(cone3 == null) "" else cone3
    println(cone3dereference)
    
    val cone4: String? = "conejo"
    cone4!!
    println(cone4.length) //Smart cast
}