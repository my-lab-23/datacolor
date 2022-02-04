import colorCase.Color
import colorCase.ColorPool
import colorCase.ColorTool

fun main(args: Array<String>) {

    val cP = ColorPool()

    cP.addColor(Color("#111111"))
    cP.addColor(Color("#222222"))
    cP.addColor(Color("#333333"))
    cP.addColor(Color("#444444"))
    cP.addColor(Color("#555555"))

    val cPOdds = cP.getOddsElements()
    val cPEvens = cP.getEvensElements()

    for(i in 0 until cPOdds.getSize()) {
        //println(cPOdds.getColor(i).rgb)
    }

    //println("\n")

    for(i in 0 until cPEvens.getSize()) {
        //println(cPEvens.getColor(i).rgb)
    }

    val finCombo = ColorTool.finalCombo(cP)

    for(i in 0 until finCombo.getSize()) {
        println(finCombo.getColor(i).rgb)
    }
}
