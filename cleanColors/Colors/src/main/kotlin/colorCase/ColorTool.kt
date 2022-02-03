package colorCase

import myRGB.MyRGB

object ColorTool {

    fun genRandomColor(): Color {
        val rgb = MyRGB.getRGB()
        return Color(rgb)
    }

    //

    private fun averageCombo(): ColorPool {
        TODO()
    }

    fun finalCombo(): ColorPool {
        TODO()
    }
}
