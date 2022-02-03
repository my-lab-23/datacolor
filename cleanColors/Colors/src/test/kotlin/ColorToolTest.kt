import colorCase.ColorTool
import org.junit.Test
import kotlin.test.assertEquals

class ColorToolTest {

    @Test
    fun getRandomColor() {
        val color = ColorTool.genRandomColor()
        assertEquals(7, color.rgb.length)
    }
}
