## Guess My PIN

A terminal game written in Kotlin. The computer picks a secret 3-digit number (100 to 999), and you have 7 attempts to guess it.

 Features
- Hints after each guess: VERY HOT, warm, too high or too low
- Invalid input never crashes the game and never costs an attempt
- Summary at the end: attempts used, the secret number and all your guesses
- Play again option
- Type `quit` at any time to leave

 ## Run it
Needs JDK (Java Development Kit) 11 or higher.

    java -jar guess-my-pin.jar

 ## Built with
Kotlin and Gradle. No external libraries. Everything runs in memory.