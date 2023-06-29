fun <T> List<T>.average(): Double where T: Int {
    val size = this.size
    if(size == 0) return 0.0

    // var sum = 0.0
    // for (item in this) {
    //     sum = sum + item
    // }
    val sum = this.sumOf {it}
    return sum / size * 1.0
}

fun main() {
    val t1 = listOf(1,2,3)
    println(t1.average())
}