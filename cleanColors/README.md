# cleanColors

Riscrittura di [myRGB](https://github.com/my-lab-23/datacolor-p/tree/master/myrgb) con un altro approccio (da completare).

Evoluzione della funzione per il calcolo del colore medio di un vettore di colori RGB:

```kotlin
    fun averageColorPool(): Color {
        val red = (sumPow2("RED")/colors.size).sqrt()
        val green = (sumPow2("GREEN")/colors.size).sqrt()
        val blue = (sumPow2("BLUE")/colors.size).sqrt()

        val redHex = convertIntToHexString(red)
        val greenHex = convertIntToHexString(green)
        val blueHex = convertIntToHexString(blue)

        return Color("#$redHex$greenHex$blueHex")
    }
```

```scala
   def average_rgb_list(rgb_list: List[String]): String = {
      val colors = MyRGBAux.split_hex_to_int(rgb_list)

      val powered_colors = ListBuffer[List[Int]]()

      for(c <- colors) {
         val powered = c.map { _.pow(2) }
         powered_colors.addOne(powered)
      }

      val n_colors = powered_colors.head.length

      val sum1 = powered_colors.head.sum/n_colors
      val sum2 = powered_colors(1).sum/n_colors
      val sum3 = powered_colors(2).sum/n_colors

      val res1 = MyRGBAux.convertIntToHexString(sum1.sqrt())
      val res2 = MyRGBAux.convertIntToHexString(sum2.sqrt())
      val res3 = MyRGBAux.convertIntToHexString(sum3.sqrt())

      s"#$res1$res2$res3"
   }
```

```scala
   def average_rgb_list(rgb_list: List[String]): String = {
      var r = ListBuffer[String]()
      var g = ListBuffer[String]()
      var b = ListBuffer[String]()

      for(l <- rgb_list) {
         r += l(1).toString + l(2).toString
         g += l(2).toString + l(3).toString
         b += l(4).toString + l(5).toString
         println(s"$r - $g - $b")
      }

      val rI = r.map(convertHexStringToInt)
      val gI = g.map(convertHexStringToInt)
      val bI = b.map(convertHexStringToInt)
      println(s"$rI - $gI - $bI")

      val rD: ListBuffer[Double] = rI.map(_.toDouble)
      val gD: ListBuffer[Double] = gI.map(_.toDouble)
      val bD: ListBuffer[Double] = bI.map(_.toDouble)
      println(s"$rD - $gD - $bD")

      val rDp = rD.map(Math.pow(_,2))
      val gDp = gD.map(Math.pow(_,2))
      val bDp = bD.map(Math.pow(_,2))
      println(s"$rDp - $gDp - $bDp")

      val rIa = rI.sum/rI.length
      val gIa = gI.sum/gI.length
      val bIa = bI.sum/bI.length
      println(s"$rIa - $gIa - $bIa")

      val resR = this.convertIntToHexString(rIa)
      val resG = this.convertIntToHexString(gIa)
      val resB = this.convertIntToHexString(bIa)
      println(s"$resR - $resG - $resB")

      val result = s"#$resR$resG$resB"
      println(result)
      result
   }
```
