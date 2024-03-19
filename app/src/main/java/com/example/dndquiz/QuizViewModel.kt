package com.example.dndquiz

import Question
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel (private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val questionBank = listOf(
        Question(R.string.question_beholder, false),
        Question(R.string.question_fireball, true),
        Question(R.string.question_dragon, true),
        Question(R.string.question_thief, false),
        Question(R.string.question_ranger, false),
        Question(R.string.question_priest, false)
    )

    var currentIndex = 0

    /*var isCheater: Boolean
        get() = savedStateHandle[IS_CHEATER_KEY] ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)
    */

    // this function keep track of current question's answer
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
    // once I remember the current question's position
    // I'll write a function that move to the next question
    fun moveToNext(){
        currentIndex = (currentIndex+1) % questionBank.size
    }

}