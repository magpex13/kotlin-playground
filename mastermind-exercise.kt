data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun String.removeByIndex(index: Int): String = if(index > -1) this.removeRange(index..index) else this

fun String.removeByIndexes(indexes: HashSet<Int>): String {
    var newString: String = ""
    for ((index, item) in this.withIndex()) {
        if(index !in indexes) {
            newString += item
        }
    }

    return newString
}

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val keyLength = secret.length
    if(secret == guess){
        return Evaluation(keyLength, 0)
    }

    var rightPosition = 0
    var wrongPosition = 0

    val guessedKeyIndexes = hashSetOf<Int>()
    for (index in 0 until keyLength) {
        if(secret[index] == guess[index]){
            rightPosition += 1
            guessedKeyIndexes.add(index)
        }
    }

    var simplifiedSecret = secret.removeByIndexes(guessedKeyIndexes)
    val simplifiedGuess = guess.removeByIndexes(guessedKeyIndexes)

    for(guessKey in simplifiedGuess) {
        val secretKeyIndex = simplifiedSecret.indexOf(guessKey)
        if(secretKeyIndex > -1) {
            wrongPosition += 1
            simplifiedSecret = simplifiedSecret.removeByIndex(secretKeyIndex)
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
