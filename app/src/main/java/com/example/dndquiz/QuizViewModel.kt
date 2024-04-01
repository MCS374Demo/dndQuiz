package com.example.dndquiz

import Question
import androidx.lifecycle.ViewModel

//private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    val questionBank = listOf(
        Question(R.string.question_beholder, false, R.mipmap.beholder),
        Question(R.string.question_fireball, true, R.mipmap.fireball),
        Question(R.string.question_dragon, true, R.mipmap.dragon),
        Question(R.string.question_thief, false, R.drawable.ic_launcher_background),
        Question(R.string.question_ranger, false, R.drawable.ic_launcher_foreground),
        Question(R.string.question_priest, false, R.drawable.ic_launcher_background)
    )

    var currentIndex = 0

    /*var isCheater: Boolean
        get() = savedStateHandle[IS_CHEATER_KEY] ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)
    */

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val currentQuestionPicture: Int
        get() = questionBank[currentIndex].picture

    fun moveToNext(){
        currentIndex = (currentIndex+1) % questionBank.size
    }

}