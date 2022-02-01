package my_rgb

import scala.collection.mutable.ListBuffer

object MyRGBAux {

   private def convertHexStringToInt(hexString : String): Int = {
      Integer.parseInt(hexString, 16)
   }

   def convertIntToHexString(n: Int): String = {
      val s = Integer.toHexString(n)

      if(s.length == 1) { s"0$s" }
      else { s }
   }

   def split_hex_to_int(colors: List[String]): List[List[Int]] = {

      val result = ListBuffer[List[Int]]()

      val reds = ListBuffer[Int]()
      val greens = ListBuffer[Int]()
      val blues = ListBuffer[Int]()

      for(c <- colors) {
         val replaced = c.replace("#", "")
         val splitted = replaced.split("")
         val red = this.convertHexStringToInt(splitted(0)+splitted(1))
         val green = this.convertHexStringToInt(splitted(2)+splitted(3))
         val blue = this.convertHexStringToInt(splitted(4)+splitted(5))
         reds.addOne(red)
         greens.addOne(green)
         blues.addOne(blue)
      }

      result.addOne(reds.toList)
      result.addOne(greens.toList)
      result.addOne(blues.toList)

      result.toList
   }

   def double_to_hex_string(rgb_double: List[Double]): String = {

      val rI = rgb_double.head.toInt
      val gI = rgb_double(1).toInt
      val bI = rgb_double(2).toInt

      val result = this.int_to_hex_string(List(rI, gI, bI))
      result
   }

   def int_to_hex_string(rgb_int: List[Int]): String = {

      val resR = this.convertIntToHexString(rgb_int.head)
      val resG = this.convertIntToHexString(rgb_int(1))
      val resB = this.convertIntToHexString(rgb_int(2))

      val result = s"#$resR$resG$resB"
      result
   }
}
