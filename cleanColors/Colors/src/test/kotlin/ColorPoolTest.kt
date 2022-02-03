import colorCase.Color
import colorCase.ColorPool
import org.junit.Test
import kotlin.test.assertEquals

class ColorPoolTest {

    @Test
    fun addColorTest() {
        val rgb = "#AABBCC"
        val expectedOutput = "#AABBCC"
        val color = Color(rgb)
        val colors = ColorPool()
        colors.addColor(color)
        assertEquals(expectedOutput, colors.getColor(0).rgb)
    }
}
