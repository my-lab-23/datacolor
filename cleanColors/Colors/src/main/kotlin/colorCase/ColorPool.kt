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

    //

    fun averageColorPool(): Color {
        val red = (sumPow2("RED")/colors.size).sqrt()
        val green = (sumPow2("GREEN")/colors.size).sqrt()
        val blue = (sumPow2("BLUE")/colors.size).sqrt()

        val redHex = convertIntToHexString(red)
        val greenHex = convertIntToHexString(green)
        val blueHex = convertIntToHexString(blue)

        return Color("#$redHex$greenHex$blueHex")
    }

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

    fun getSize(): Int {
        return  colors.size
    }

    fun addColor(c: Color) {
       colors.add(c)
    }

    //

    fun getOddsElements(): ColorPool {
        return getElements(0)
    }

    fun getEvensElements(): ColorPool {
        return getElements(1)
    }

    private fun getElements(j: Int): ColorPool {
        val temp = ColorPool()
        for (i in j until colors.size step 2) {
            temp.addColor(Color(colors[i].rgb))
        }
        return temp
    }

    //

    fun replaceMinWithZero(): ColorPool {
        val color1 = this.getColor(0)
        val color2 = this.getColor(1)

        val newCP = ColorPool()

        val min1 = listOf(color1.red, color1.green, color1.blue).minOrNull()!!
        newCP.addColor(Color(f(min1, 0)))

        val min2 = listOf(color2.red, color2.green, color2.blue).minOrNull()!!
        newCP.addColor(Color(f(min2, 1)))

        return newCP
    }

    private fun f(absoluteMin: Int, i: Int): String {
        val c = mutableListOf("#", "00", "00", "00")

        if(colors[i].red != absoluteMin)   { c[1] = colors[i].redHex  }
        if(colors[i].green != absoluteMin) { c[2] = colors[i].greenHex }
        if(colors[i].blue != absoluteMin)  { c[3] = colors[i].blueHex }

        return c.joinToString("")
    }
}
