package my_rgb

import my_utility.MyUtility

import scala.collection.mutable.ListBuffer

object MyRGB {

   private val path = sys.env("MY_DATA_PATH")

   //

   private def get_rbg_string: String = {
      val rgb_string = "#%06x".format(scala.util.Random.nextInt(1 << 24))
      rgb_string
   }

   def get_rbg_list(list_len: Int): List[String] = {
      val rbg_list_buffer = ListBuffer[String]()

      for(_ <- 1 to list_len) {
         rbg_list_buffer += this.get_rbg_string
      }

      val rgb_list = rbg_list_buffer.toList
      rgb_list
   }

   def save_rgb_list(rgb_list: List[String]): Unit = {
      var rgb_list_csv = ""

      for(l <- rgb_list) {
         rgb_list_csv = l + "," + rgb_list_csv
      }

      val mode = true
      MyUtility.write_file(rgb_list_csv, s"$path/rgb.txt", mode)
   }

   //

   private implicit class ExtendedInt(i: Int) {
      def pow(esponente: Int): Int = {
         Math.pow(i.toDouble, esponente.toDouble).toInt
      }

      def sqrt(): Int = {
         Math.sqrt(i.toDouble).toInt
      }
   }

   // AverageColor = sqrt((R1^2+R2^2)/2),sqrt((G1^2+G2^2)/2),sqrt((B1^2+B2^2)/2)
   def average_rgb_list(rgb_list: List[String]): String = {
      val colors = MyRGBAux.split_hex_to_int(rgb_list)

      val powered_colors = ListBuffer[List[Int]]()

      for(c <- colors) {
         val powered = c.map { _.pow(2) }
         powered_colors.addOne(powered)
      }

      val sum1 = powered_colors.head.sum/2
      val sum2 = powered_colors(1).sum/2
      val sum3 = powered_colors(2).sum/2

      val res1 = MyRGBAux.convertIntToHexString(sum1.sqrt())
      val res2 = MyRGBAux.convertIntToHexString(sum2.sqrt())
      val res3 = MyRGBAux.convertIntToHexString(sum3.sqrt())

      s"#$res1$res2$res3"
   }

   //

   def average_combo(): List[String] = {
      val rgb_list_csv = MyUtility.read_file(s"$path/rgb.txt")
      val rgb_list_last9 = rgb_list_csv.take(9)

      val splitted = ListBuffer[List[String]]()

      for(l <- rgb_list_last9) {
         splitted += l.split(",").toList
      }

      for(l <- splitted) {
         println(l)
      }

      val pari = ListBuffer[String]()
      val dispari = ListBuffer[String]()

      for(l <- splitted) {
         if(l.nonEmpty) {
            pari += l.head
            dispari += l(1)
         }
      }

      val color1 = MyRGB.average_rgb_list(pari.toList)
      val color2 = MyRGB.average_rgb_list(dispari.toList)

      List(color1, color2)
   }

   def final_combo(rgb_list: List[String]): List[String] = {
      val ril = MyRGBAux.split_hex_to_int(rgb_list)

      val l0 = ril.head
      val l1 = ril(1)
      val l2 = ril(2)

      val m1 = List(l0.head, l1.head, l2.head).min
      val m2 = List(l0(1), l1(1), l2(1)).min

      def replace_min(x: Int): Int = {
         if(x==m1 || x==m2 ) { 0 }
         else { x }
      }

      val res0 = ril.head.map(replace_min)
      val res1 = ril(1).map(replace_min)
      val res2 = ril(2).map(replace_min)

      val result1 = MyRGBAux.int_to_hex_string(List(res0.head, res1.head, res2.head))
      val result2 = MyRGBAux.int_to_hex_string(List(res0(1), res1(1), res2(1)))
      List(result1, result2)
   }
}
