package vcmsa.ci.trueorfalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val txtReview = findViewById<TextView>(R.id.txtReview)
        val btnRetake = findViewById<Button>(R.id.btnRetake)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                //Code attribution
                //This method was taken from IMAD5112 part 2 notes
                //page 9
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append("  Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            txtReview.text = reviewText.toString()
        } else {
            txtReview.text = "Oops! we can't load the reviews"
        }

        btnRetake.setOnClickListener {
            startActivity(Intent(this, Quiz::class.java))
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}