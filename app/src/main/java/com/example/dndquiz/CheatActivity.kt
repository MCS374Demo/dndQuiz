package com.example.dndquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.dndquiz.databinding.ActivityCheatBinding
// have a constant
const val EXTRA_ANSWER_SHOWN = "com.example.dndquiz.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE = "com.example.dndquiz.answer_is_true"
private const val WAS_CHEATED = "was_cheated"
class CheatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheatBinding
    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button
    private var wasCheated = false
    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // activate the binding
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        wasCheated = savedInstanceState?.getBoolean(WAS_CHEATED, false) ?: false
        setAnswerShownResult(wasCheated)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        answerTextView = findViewById(R.id.answer_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)

        showAnswerButton.setOnClickListener {
            wasCheated = true
            setAnswerShownResult(true)
            fillTextIfCheated()
        }

        fillTextIfCheated()
    }

    private fun fillTextIfCheated() {
        if (wasCheated) {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(WAS_CHEATED, wasCheated)
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        if (wasCheated) {
            val data = Intent().apply {
                putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
            }
            setResult(Activity.RESULT_OK, data)
        }
    }
    // set a cheating button listener

    companion object{
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent{
            return Intent (packageContext, CheatActivity::class.java).apply{
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}