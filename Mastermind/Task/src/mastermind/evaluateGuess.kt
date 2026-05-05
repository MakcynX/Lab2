package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { (s, g) -> s == g }


    val commonLetters = ('A'..'F').sumOf { char ->
        val countInSecret = secret.count { it == char }
        val countInGuess = guess.count { it == char }
        minOf(countInSecret, countInGuess)
    }

    val wrongPositions = commonLetters - rightPositions

    return Evaluation(rightPositions, wrongPositions)
}