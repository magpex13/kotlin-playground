
val isEven: (Int) -> Boolean = { it % 2 == 0 }
val isOdd: Int.() -> Boolean = { this % 2 != 0 }

inline fun buildString2(builder: StringBuilder.() -> StringBuilder): String {
    val sb = StringBuilder()
    sb.builder()
    return sb.toString()
}

fun main() {
    val sb = StringBuilder()
    
    val t1 = with(sb) {
        appendLine("co")
        for(ch in 'a'..'e') {
            append(ch)
        }
        appendLine("jo")
        toString()
    }
    println(t1)

    println(isEven(4))
    println(1.isOdd())

    val t2 = buildString {
        appendLine("cone")
        appendLine("jo")
    }
    println(t2)

    val t3 = buildString2 {
        appendLine("jone")
        appendLine("co")
    }
    println(t3)
}