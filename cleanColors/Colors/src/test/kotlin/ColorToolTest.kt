import colorCase.ColorPool
import colorCase.ColorTool
import org.junit.Test
import kotlin.test.assertEquals

class ColorToolTest {

    @Test
    fun getRandomColorTest() {
        val color = ColorTool.genRandomColor()

    }

    @Test
    fun finalComboTest() {
        val finCombo = ColorTool.finalCombo(ColorTool.loadColorPool(9))
        val color1 = finCombo.getColor(0).rgb
        val color2 = finCombo.getColor(1).rgb
        assertEquals(listOf("#84007c", "#00979f"), listOf(color1, color2))
    }
}
