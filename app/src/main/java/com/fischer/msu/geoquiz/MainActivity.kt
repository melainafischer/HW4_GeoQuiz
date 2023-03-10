package com.fischer.msu.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fischer.msu.geoquiz.QuizViewModel
import android.widget.Toast
import androidx.activity.viewModels
import com.fischer.msu.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quizViewModel:QuizViewModel by viewModels()

/*    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentIndex = 0
    private var counterCorrect = 0
    private var counterIncorrect = 0
    private var scorePercentage = 0
    private var scoreString = ""*/

    private var counterCorrect = 0
    private var counterIncorrect = 0
    //private var scorePercentage = 0
    //private var scoreString = ""
    //private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate (Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Got a QuizViewModel:$quizViewModel")

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
            binding.trueButton.isEnabled = !(binding.trueButton.isEnabled)
            binding.falseButton.isEnabled = !(binding.falseButton.isEnabled)
        }

        binding.falseButton.setOnClickListener {
            checkAnswer(false)
            binding.trueButton.isEnabled = !(binding.trueButton.isEnabled)
            binding.falseButton.isEnabled = !(binding.falseButton.isEnabled)
        }

        binding.nextButton.setOnClickListener {
            //currentIndex = (currentIndex + 1) % questionBank.size
            quizViewModel.moveToNext()
            updateQuestion()
            binding.trueButton.isEnabled = true
            binding.falseButton.isEnabled = true
        }
        updateQuestion()

       /* binding.previousButton.setOnClickListener{
            currentIndex = (currentIndex - 1) % questionBank.size
            updateQuestion()
            binding.trueButton.isEnabled = !(binding.trueButton.isEnabled)
            binding.falseButton.isEnabled = !(binding.falseButton.isEnabled)
        }*/

/*        binding.questionTextview.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
            binding.trueButton.isEnabled = true
            binding.falseButton.isEnabled = true
        }*/
    }

    private fun updateQuestion() {
        //val questionTextResId = questionBank[currentIndex].textResId
        val questionTextResId = quizViewModel.currentQuestionText

        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        //val correctAnswer = questionBank[currentIndex].answer
        val correctAnswer = quizViewModel.currentQuestionAnswer

        //val correctAnswer = questionBank[currentIndex + 1] as Boolean

        if (userAnswer == correctAnswer) {
            //R.string.correct_toast
            // add counter variable here to count number of correct answers
            counterCorrect++
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG).show()

        } else {
            //R.string.incorrect_toast
            counterIncorrect++
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_LONG).show()
        }
        //Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show()
        //calculateScore()
    }
/*    private fun calculateScore() {
        if (currentIndex == questionBank.size - 1){
            //val scorePercentage = (counterCorrect.toDouble() / questionBank.size * 100)
            // String.format("%.1f", number2digits).toDouble()
            val scorePercentage = (counterCorrect.toDouble() / questionBank.size.toDouble() * 100)
            val scoreString = String.format("%.1f", scorePercentage) + "%"
            Toast.makeText(this, scoreString, Toast.LENGTH_LONG).show()
            counterCorrect = 0
        //displayToast(scoreString)
        }

            //•	Reset number correct to 0
        }*/
/*    private fun displayToast(text: String) {
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this, text, duration)
        toast.show()
    }*/

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}