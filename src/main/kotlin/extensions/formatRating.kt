package extensions

import kotlin.math.floor
import kotlin.math.roundToInt

fun Double.formatRating(): String {
    if ((this - floor(this)) == 0.0) {
        return this.roundToInt().toString()
    }
    return String.format("%.1f", this)
}