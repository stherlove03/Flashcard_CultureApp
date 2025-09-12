package com.example.cultureapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import com.google.android.material.snackbar.Snackbar

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
        val add_button= findViewById<ImageView>(R.id.add_button)
        val edit_button= findViewById<ImageView>(R.id.edit_button)
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

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            if (data != null) { // Check that we have data returned
                val added_question = data.getStringExtra("added_question") // 'string1' needs to match the key we used when we put the string in the Intent
                val added_answer= data.getStringExtra("added_answer")
                val added_wrong_answer = data.getStringExtra("added_wrong_answer")
                val added_wrong_answer1 = data.getStringExtra("added_wrong_answer1")

                flashcardQuestion.text = added_question
                flashcardAnswer2.text=added_answer
                flashcardAnswer.text=added_wrong_answer
                flashcardAnswer1.text=added_wrong_answer1
            } else {
                Log.i("MainActivity", "Returned null data from AddCardActivity")
            }
            Snackbar.make(findViewById(R.id.flashcard_question),
                "Card Successfully Created",
                Snackbar.LENGTH_SHORT)
                .show()
        }
        add_button.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)
        }
        edit_button.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            intent.putExtra("added_question", flashcardQuestion.text.toString());
            intent.putExtra("added_answer", flashcardAnswer2.text.toString());
            intent.putExtra("added_wrong_answer", flashcardAnswer.text.toString());
            intent.putExtra("added_wrong_answer1", flashcardAnswer1.text.toString());
            resultLauncher.launch(intent)
        }
    }
}












