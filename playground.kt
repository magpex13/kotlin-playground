// fun max(a: Int, b: Int): Int {
//     return if (a > b) a else b
// }

fun max(c1: Int, c2: Int) : Int = if (c1 > c2) c1 else c2

fun display(character: String = "*", size: Int = 10) {
    repeat(size) {
        println(character)
    }
}

fun temperature(temp: Int): String {
    val description: String

    if(temp < 10) {
        description = "coolest"
    } else if(temp < 30) {
        description = "masomenos"
    } else {
        description = "harm"
    }

    return description
}

val test1 = mutableListOf("aaaa", "bbbb", "cccc")
for(item in test1) {
    println(item)
}