package colorCase

import kotlin.math.pow

class Color(val rgb: String) {

    val redHex = "${rgb[1]}${rgb[2]}"
    val greenHex = "${rgb[3]}${rgb[4]}"
    val blueHex = "${rgb[5]}${rgb[6]}"

    val red = convertHexToInt(redHex)
    val green = convertHexToInt(greenHex)
    val blue = convertHexToInt(blueHex)

    val redPow2 = red.pow(2)
    val greenPow2 = green.pow(2)
    val bluePow2 = blue.pow(2)

    private fun convertHexToInt(hex: String): Int {
        return Integer.parseInt(hex, 16)
    }

    private fun Int.pow(exponent: Int): Int {
        return this.toDouble().pow(exponent.toDouble()).toInt()
    }

    //

    fun withoutSharp(): String {
        return rgb.drop(1)
    }
}
