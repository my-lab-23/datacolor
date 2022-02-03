package colorCase

import myRGB.MyRGB

class ColorPool {

    private val colors = mutableListOf<Color>()

    //

    fun saveColorPool() {
        val temp = mutableListOf<String>()
        for(c in colors) { temp.add(c.rgb) }
        MyRGB.saveRGB(temp)
    }

    fun getSavedColorPool(nColor: Int): ColorPool {
        TODO()
    }

    fun averageColorPool(): Color {
        val red = (sumPow2("RED")/colors.size).sqrt()
        val green = (sumPow2("GREEN")/colors.size).sqrt()
        val blue = (sumPow2("BLUE")/colors.size).sqrt()

        val redHex = convertIntToHexString(red)
        val greenHex = convertIntToHexString(green)
        val blueHex = convertIntToHexString(blue)

        return Color("#$redHex$greenHex$blueHex")
    }

    //

    private fun Int.sqrt(): Int {
        return kotlin.math.sqrt(this.toDouble()).toInt()
    }

    private fun sumPow2(flag: String): Int {
        var sum = 0

        if(flag == "RED")   colors.forEach { sum += it.redPow2 }
        if(flag == "GREEN") colors.forEach { sum += it.greenPow2 }
        if(flag == "BLUE")  colors.forEach { sum += it.bluePow2 }

        return sum
    }

    private fun convertIntToHexString(n: Int): String {
        val s = Integer.toHexString(n)

        return if(s.length == 1) { "0$s" }
        else { s }
    }

    //

    fun getColor(i: Int): Color {
        return colors[i]
    }

    fun addColor(c: Color) {
       colors.add(c)
    }
}
