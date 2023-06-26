@Throws(Exception::class)
fun test1(){
    throw Exception("CONEJO")
}

fun main() {
    val number: Int = try {
        Integer.parseInt("5")
    }
    catch(e: Exception) {
        return
    }

    val percentage = if(number in 0..100)
                        number
                    else
                        throw IllegalArgumentException(
                            "A percentage $number" 
                        )

    println(percentage)
    
    test1()
}
