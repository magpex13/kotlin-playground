fun isLetter(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z'
fun isNotDigit(ch: Char)  = ch !in '0'..'9'

fun recognize(ch: Char): String = when(ch) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know"
}

fun main(){
    println(recognize('&'))
    val stringRange: ClosedRange<String> = "ab".."az"
    println(stringRange)

    val test1 = "rabbit" in "aa".."lieb"
    println(test1)

    val tlst = listOf('a', 'b', 'c')
    val test2 = 'a' in tlst
    println(test2)
}