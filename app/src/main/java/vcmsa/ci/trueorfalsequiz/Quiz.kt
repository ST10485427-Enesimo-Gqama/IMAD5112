package vcmsa.ci.trueorfalsequiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {

    private lateinit var qnTextView: TextView
    private lateinit var reportTextView: TextView
    private lateinit var btnTrue : Button
    private lateinit var btnFalse : Button
    private lateinit var btnNext : Button

    //Questions for the quiz.
    companion object {
        val questions = arrayOf(
            "George Washington was the first president of the United States.",
            "The pyramids of Egypt were built in the last 100 years.",
            "The apartheid system ended in the 1990s.",
            "The great wall of China can be see from the moon with the naked eye",
            "Nelson Mandela was the first back president in RSA."
        )
        val answers = booleanArrayOf(true, false, true, false, true)
    }

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        qnTextView = findViewById(R.id.qnTextView)
        reportTextView = findViewById(R.id.reportTextView)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)

        //Show the first question.
        displayQuestion()

        //Setting click listener on answer buttons.
        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }

        //Setting click listener on next button to continue on the next part of the quiz.
        //Code attribution
        //This method was taken from the module manual
        //page 55-56
        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                reportTextView.text = ""
                //Code attribution
                //This method was taken from the module manual
                //page 53
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
            } else {
                //Takes users to ScoreActivity.
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
        btnNext.isEnabled = false

    }

    private fun displayQuestion() {
        qnTextView.text = questions[currentQuestionIndex]

    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        //Setting color for different answers.
        if (userAnswer == correctAnswer) {
            reportTextView.text = "Perfect"
            reportTextView.setTextColor(Color.GREEN)
            score++
        } else {
            reportTextView.text = "Wrong"
            reportTextView.setTextColor(Color.RED)
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true
    }    }