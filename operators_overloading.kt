data class Point(val x: Int, val y: Int)

operator fun Point.minus(b: Point) = Point(this.x - b.x, this.y - b.y)
operator fun Point.div(b: Point) = Point(this.x / b.x, this.y / b.y)
operator fun Point.times(b: Point) = Point(this.x * b.x, this.y * b.y)

fun main() {
    val t1 = Point(5, 2)
    println(t1 - Point(3, 1))
    println(t1 / Point(5, 1))
    println(t1 * Point(5, 1))

    var list1 = listOf(1,2,3,4,5) //It's not recommended to use var for lists
    val list2 = list1
    list1 += 4
    println(list1) //[1,2,3,4,5,4]
    println(list2) //[1,2,3,4,5]

    val list3 = mutableListOf(1,2,3,4,5)
    val list4 = list3
    list3 += 4
    println(list3) //[1,2,3,4,5,4]
    println(list4) //[1,2,3,4,5,4]
}