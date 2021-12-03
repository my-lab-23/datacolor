package my_rgb

import scala.collection.mutable.ListBuffer

object MyRGBAux {

   private def convertHexStringToInt(hexString : String): Int = {
      Integer.parseInt(hexString, 16)
   }

   private def convertIntToHexString(n: Int): String = {
      Integer.toHexString(n)
   }

   def split_hex_to_int(rgb_list: List[String]): List[List[Int]] = {
      var r = ListBuffer[String]()
      var g = ListBuffer[String]()
      var b = ListBuffer[String]()

      for(l <- rgb_list) {
         r += l(1).toString + l(2).toString
         g += l(2).toString + l(3).toString
         b += l(4).toString + l(5).toString
      }

      val rI = r.map(this.convertHexStringToInt)
      val gI = g.map(this.convertHexStringToInt)
      val bI = b.map(this.convertHexStringToInt)

      List(rI.toList, gI.toList, bI.toList)
   }

   def double_to_hex_string(rgb_double: List[Double]): String = {

      val rI = rgb_double.head.toInt
      val gI = rgb_double(1).toInt
      val bI = rgb_double(2).toInt

      val result = this.int_to_hex_string(List(rI, gI, bI))
      result
   }

   def int_to_hex_string(rgb_int: List[Int]): String = {
      val resR = this.convertIntToHexString(rgb_int.head).replace("0", "00")
      val resG = this.convertIntToHexString(rgb_int(1)).replace("0", "00")
      val resB = this.convertIntToHexString(rgb_int(2)).replace("0", "00")

      val result = s"#$resR$resG$resB"
      result
   }
}
