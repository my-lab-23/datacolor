import colorCase.Color
import colorCase.ColorPool
import colorCase.ColorTool

fun main(args: Array<String>) {

    val cP = ColorPool()
    val c1 = Color("#AABBCC")
    val c2 = Color("#CCBBAA")
    cP.addColor(c1)
    cP.addColor(c2)
    val aC = cP.averageColorPool()
    println(aC.rgb)

    cP.saveColorPool()
}
