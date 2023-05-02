package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {

    private var wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val guess1 = findViewById<TextView>(R.id.Guess1)
        val guess2 = findViewById<TextView>(R.id.Guess2)
        val guess3 = findViewById<TextView>(R.id.Guess3)
        val answer = findViewById<TextView>(R.id.Answer)

        val guess1Check = findViewById<TextView>(R.id.Guess1Check)
        val guess2Check = findViewById<TextView>(R.id.Guess2Check)
        val guess3Check = findViewById<TextView>(R.id.Guess3Check)

        // call the view that you want call text |   guess1.text() = userInput  | backend to frontend


        var counter = 0
        val button = findViewById<Button>(R.id.Button)
        val userGuess = findViewById<EditText>(R.id.et_simple) // assigns (EditText) value to userGuess |
        // make text view invisible| set it to be invisible at start | check if user has runn out of guess or guessed correct
        answer.text = wordToGuess
        button.setOnClickListener {
            counter++


            var userInput = userGuess.text.toString()
            userInput = userInput.uppercase()// assigns (String) value to userInput (holds user input)

            when (counter) {
                1 ->  { guess1.text = userInput
                        guess1Check.text = checkGuess(userInput) }
                2 ->  { guess2.text = userInput
                        guess2Check.text = checkGuess(userInput) }
                3 ->  { guess3.text = userInput
                        guess3Check.text = checkGuess(userInput) }
            }
            if (counter == 3 || userInput == wordToGuess) {
                answer.text = wordToGuess
            }

        }
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }



}


