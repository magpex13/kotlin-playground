enum class Color {
    BLUE, ORANGE, RED, YELLOW ,GREEN, VIOLET, INDIGO
}

fun getDescription(color: Color): String = 
    when(color) {
        Color.BLUE -> "cold"
        Color.ORANGE -> "mild"
        Color.RED -> "hot"
        else -> "nothing"
    }

fun respondToInput(input: String): String = when(input) {
        "y", "yes" -> "I'm glad"
        "n", "no" -> "Sorry to hear you"
        else -> "I don't understand you"
    }

fun mix(color1: Color, color2: Color): Color = when(setOf(color1, color2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun updateWeather(degress: Int) {
    val (description: String, color: Color) = when {
        degress < 5 -> "cold" to Color.BLUE
        degress < 23 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }
}

fun main() {
    println(getDescription(Color.BLUE))
    println(respondToInput("n"))
    println(mix(Color.BLUE, Color.VIOLET))
}