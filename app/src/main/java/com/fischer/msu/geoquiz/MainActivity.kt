package com.fischer.msu.geoquiz


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.fischer.msu.geoquiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
   // private lateinit var trueButton: Button
   // private lateinit var falseButton: Button


    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  trueButton = findViewById(R.id.true_button)
      //  falseButton = findViewById(R.id.false_button)

        binding.trueButton.setOnClickListener{
            val snackbar = Snackbar.make(
                it,
                "Correct",
                Snackbar.LENGTH_LONG
            )
            snackbar.show()
        }

        binding.falseButton.setOnClickListener{
            val snackbar = Snackbar.make(
                it,
                "Incorrect",
                Snackbar.LENGTH_LONG
            )
            snackbar.setTextColor(Color.BLACK)
            snackbar.setBackgroundTint(Color.RED)
            snackbar.show()
        }

        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            binding.questionTextview.setText(questionTextResId)
            //updateQuestion()
        }

        binding.previousButton.setOnClickListener{
            currentIndex = (currentIndex - 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            binding.questionTextview.setText(questionTextResId)
            //updateQuestion()
        }

        binding.questionTextview.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            binding.questionTextview.setText(questionTextResId)
        }

    }

/*    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextview.setText(questionTextResId)
    }*/
}
