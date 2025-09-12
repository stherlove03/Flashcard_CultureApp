package com.example.cultureapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val cancel_button=findViewById<ImageView>(R.id.cancel_button)
        val save_button = findViewById<ImageView>(R.id.save_button)
        val editing_question= intent.getStringExtra("added_question");
        val editing_answer= intent.getStringExtra("added_answer");
        val editing_wrong_answer= intent.getStringExtra("added_wrong_answer");
        val editing_wrong_answer1= intent.getStringExtra("added_wrong_answer1");

        findViewById<EditText>(R.id.add_question).setText(editing_question)
        findViewById<EditText>(R.id.add_answer).setText(editing_answer)
        findViewById<EditText>(R.id.add_wrong_answer).setText(editing_wrong_answer)
        findViewById<EditText>(R.id.add_wrong_answer1).setText(editing_wrong_answer1)

        cancel_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }
        val toast = Toast.makeText(applicationContext, "Must enter both the Question and Answer", Toast.LENGTH_SHORT)
        //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)

        save_button.setOnClickListener {
            val add_question = findViewById<EditText>(R.id.add_question).text
            val add_answer = findViewById<EditText>(R.id.add_answer).text
            val add_wrong_answer = findViewById<EditText>(R.id.add_wrong_answer).text
            val add_wrong_answer1=findViewById<EditText>(R.id.add_wrong_answer1).text

            if (add_question.isBlank() || add_answer.isBlank() || add_wrong_answer.isBlank() || add_wrong_answer1.isBlank() ) {
                toast.show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                val data = Intent()

                data.putExtra(
                    "added_question",
                    findViewById<EditText>(R.id.add_question).text.toString()
                )

                data.putExtra(
                    "added_answer",
                    findViewById<EditText>(R.id.add_answer).text.toString()
                )
                data.putExtra(
                    "added_wrong_answer",
                    findViewById<EditText>(R.id.add_wrong_answer).text.toString()
                )
                data.putExtra(
                    "added_wrong_answer1",
                    findViewById<EditText>(R.id.add_wrong_answer1).text.toString()
                )

                setResult(RESULT_OK, data) // set result code and bundle data for response

                finish()
            }

        }


    }
}