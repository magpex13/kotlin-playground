fun main() {
    val lst = mutableListOf("aaaa", "bbbb", "cccc")
    for(item in lst) {
        println(item)
    }
    
    val mp = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    
    for((key, value) in mp) {
        println("$key = $value")
    }
    
    for((index, element) in lst.withIndex()) {
        println("$index = $element")
    }
    
    for(i in 1..9){ //123456789
        println(i)
    }
    
    for(i in 1 until 9){ //12345678
        println(i)
    }
    
    for(i in 9 downTo 1 step 2) { //97531
        println(i)
    }
    
    for(ch in "conejo") {
        println("$ch != ${ch + 1}")
    }
}