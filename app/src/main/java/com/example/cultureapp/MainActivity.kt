package com.example.cultureapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val flashcardAnswer1 = findViewById<TextView>(R.id.flashcard_answer1)
        val flashcardAnswer2 = findViewById<TextView>(R.id.flashcard_answer2)
        val toggleIcon = findViewById<ImageView>(R.id.toggleIcon)
        var isShowingAnswers = true

        // Quand on clique sur la question, elle disparaît et la réponse apparaît
/*        flashcardQuestion.setOnClickListener {
            flashcardQuestion.visibility = View.INVISIBLE
            flashcardAnswer.visibility = View.VISIBLE
        }
        flashcardAnswer.setOnClickListener {
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility = View.VISIBLE
        }*/
        flashcardAnswer.setOnClickListener {
            flashcardAnswer.setBackgroundColor(getResources().getColor(R.color.rouge, null))
            flashcardAnswer2.setBackgroundColor(getResources().getColor(R.color.vert, null))
        }
        flashcardAnswer1.setOnClickListener {
            flashcardAnswer1.setBackgroundColor(getResources().getColor(R.color.rouge, null))
            flashcardAnswer2.setBackgroundColor(getResources().getColor(R.color.vert, null))
        }
        flashcardAnswer2.setOnClickListener {
            flashcardAnswer2.setBackgroundColor(getResources().getColor(R.color.vert, null))
        }
        toggleIcon.setOnClickListener {
            isShowingAnswers = !isShowingAnswers

            val visibility = if (isShowingAnswers) View.VISIBLE else View.INVISIBLE
            flashcardAnswer.visibility = visibility
            flashcardAnswer1.visibility = visibility
            flashcardAnswer2.visibility = visibility

            toggleIcon.setImageResource(
                if (isShowingAnswers) R.drawable.eye_off_lined
                else R.drawable.eye_lined
            )
        }

    }
}












