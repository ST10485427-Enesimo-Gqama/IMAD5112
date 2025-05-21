package vcmsa.ci.trueorfalsequiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Current fields
    private lateinit var btnStart: Button
    private lateinit var btnExit: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)
        val appDescription = findViewById<TextView>(R.id.appDescription)
        btnStart = findViewById(R.id.btnStart)
        btnExit = findViewById(R.id.btnExit)

        //Welcome message and description
        welcomeMessage.text = "Welcome to the True or False random History Quiz"
        appDescription.text = "This quiz will test your knowledge with fun questions"

        //Setting click listener for start button
        btnStart.setOnClickListener {
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
        //This starts the Quiz Game
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}

