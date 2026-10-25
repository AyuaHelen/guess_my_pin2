fun main() {
    val howTo = ClassLoader.getSystemResourceAsStream("how-to.md")
        ?.bufferedReader()
        ?.readText()
        ?: "How-to file not found."

    println(howTo)
    print("\nPress Enter to continue")
    readLine()
    println()

    var playing = true
    game@ while (playing) {
        val secret = (100..999).random()


        val guesses = mutableListOf<Int>()
        var won = false
        var attempt = 1

        while (attempt <= 7) {
            println("Attempt $attempt of 7")
            print("Enter your guess (or type quit): ")
            val input = readLine()?.trim()

// A plain break would only leave the guessing loop.
// break@game leaves the whole game at once.
            if (input == null || input == "quit") break@game

            val guess = input?.toIntOrNull()

            if (guess == null) {
                println("That's not a valid number, try again.")
                continue // doesn't use up an attempt
            }

            guesses.add(guess)
            val diff = if (guess > secret) guess - secret else secret - guess

            when {
                guess == secret -> {
                    println("You win!")
                    won = true
                    break
                }
                diff <= 10 -> println("VERY HOT")
                diff <= 50 -> println("warm")
                guess > secret -> println("Too high")
                else -> println("Too low")
            }
            attempt++
        }

        val result = if (won) "You won" else "You lost"
        println()
        println("--- Summary ---")
        println("$result! Attempts used: ${guesses.size}, secret: $secret")
        println("Your guesses: ${guesses.joinToString(", ")}")
        println()

        var answer = ""
        while (answer != "y" && answer != "n") {
            print("Play again? (y/n): ")
            answer = readLine()?.trim()?.lowercase() ?: "n"
            if (answer != "y" && answer != "n") {
                println("Please type y or n.")
            }
        }
        if (answer == "n") {
            playing = false
        }
    }

    println("Thanks for playing, goodbye!")
}