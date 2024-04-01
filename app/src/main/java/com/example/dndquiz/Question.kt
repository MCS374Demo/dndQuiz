import androidx.annotation.StringRes
import androidx.annotation.DrawableRes
data class Question(@StringRes val textResId: Int, val answer: Boolean, @DrawableRes var picture: Int, var wasAnswered: Boolean = false)
