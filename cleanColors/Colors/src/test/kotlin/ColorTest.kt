import colorCase.Color
import org.junit.Test
import kotlin.test.assertEquals

class ColorTest {

    @Test
    fun initTest() {
        val rgb = "#AABBCC"
        val expectedOutput = "#AABBCC"
        val color = Color(rgb)
        assertEquals(expectedOutput, color.rgb)
    }

    @Test
    fun withoutSharpTest() {
        val rgb = "#AABBCC"
        val expectedOutput = "AABBCC"
        val color = Color(rgb)
        assertEquals(expectedOutput, color.withoutSharp())
    }

    @Test
    fun redTest() {
        val rgb = "#AABBCC"
        val expectedOutput = "AA"
        val color = Color(rgb)
        assertEquals(expectedOutput, color.redHex)
    }

    @Test
    fun greenTest() {
        val rgb = "#AABBCC"
        val expectedOutput = "BB"
        val color = Color(rgb)
        assertEquals(expectedOutput, color.greenHex)
    }

    @Test
    fun blueTest() {
        val rgb = "#AABBCC"
        val expectedOutput = "CC"
        val color = Color(rgb)
        assertEquals(expectedOutput, color.blueHex)
    }
}
