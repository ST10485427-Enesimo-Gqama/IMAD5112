package vcmsa.ci.trueorfalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val commentTextView = findViewById<TextView>(R.id.commentTextView)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExit)

        //Code attribution
        //This method was taken from IMAD5112 part 2 notes
        //page 12
        val score = intent.getIntExtra("score", 0)
        scoreTextView.text = "Your score: $score/5"

        //Code attribution
        //This method was taken from IMAD5112 part 2 notes
        //page 14
        val feedback = if (score >=3) {
            "Excellent!"
        } else {
            "You'll do better next time :)"
        }
        commentTextView.text = feedback

        reviewButton.setOnClickListener {
            //Creating the ReviewActivity and provide with questions and answers.
            //Code attribution
            //This method was taken from IMAD5112 part 2 notes
            //page 7
            val intent = Intent(this, Review::class.java)
            intent.putExtra("questions", Quiz.questions)
            intent.putExtra("answers", Quiz.answers)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}