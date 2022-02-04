package colorCase

import myRGB.MyRGB

object ColorTool {

    fun genRandomColor(): Color {
        val rgb = MyRGB.getRGB()
        return Color(rgb)
    }

    //

    fun loadColorPool(n: Int): ColorPool {
        val rgbs: List<String> = MyRGB.readRGB()
            .filter { it.length == 16 }
            .take(n)

        val rgbsSplitted = mutableListOf<String>()
        rgbs.forEach {
            val splitted = it.split(",").filter { s -> s.length == 7 }
            splitted.forEach { s -> rgbsSplitted.add(s) }
        }

        val colors = ColorPool()
        rgbsSplitted.forEach { colors.addColor(Color(it)) }
        return colors
    }

    //

    private fun averageCombo(cP: ColorPool): ColorPool {
        val avgOdds = cP.getOddsElements().averageColorPool()
        val avgEvens = cP.getEvensElements().averageColorPool()
        val avgCombo = ColorPool()
        avgCombo.addColor(avgOdds)
        avgCombo.addColor(avgEvens)
        return avgCombo
    }

    fun finalCombo(cP: ColorPool): ColorPool {
        return averageCombo(cP).replaceMinWithZero()
    }
}
