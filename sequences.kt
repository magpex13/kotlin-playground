import java.lang.Thread.yield
fun fibonacci(): Sequence<Int> = sequence {
    val a = mutableListOf(0, 1)
    yieldAll(a)
    var i = 2
	while(true) {
        a += a[i - 2] + a[i - 1]
        yield(a[i])
        i++
    }
}

fun fibonacci2(): Sequence<Int> = sequence {
    var a = Pair(0, 1)

    while(true) {
        yield(a.first)
        a = Pair(a.second, a.first + a.second)
    }
}

fun main() {
    val r1 = listOf(1,2,3,4,5).asSequence().map {it * it}.filter {it > 4}.toList()
    println(r1)

    val r2 = generateSequence {
        readLine().takeIf { it != "exit" }
    }.toList()
    println(r2)

    val r3 = generateSequence(0) { it + 1 }.take(5).toList()
    println(r3)

    val r4 = generateSequence {
        var x = 0
        while(true) {
            yield(x++)
        }
    }.take(5).toList()
    
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"

    fibonacci2().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci2().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}

infix fun <T> T.eq(other: T) = if(this==other) println("OK") else println("Error: $this != $other")