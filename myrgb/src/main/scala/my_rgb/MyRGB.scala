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
      var rbg_list_buffer = ListBuffer[String]()

      for( i <- 1 to list_len) {
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

   // AverageColor = sqrt((R1^2+R2^2)/2),sqrt((G1^2+G2^2)/2),sqrt((B1^2+B2^2)/2)
   def average_rgb_list(rgb_list: List[String]): String = {
      val rgb_int_list = MyRGBAux.split_hex_to_int(rgb_list)

      val red_DL: List[Double] = rgb_int_list.head.map(_.toDouble)
      val green_DL: List[Double] = rgb_int_list(1).map(_.toDouble)
      val blue_DL: List[Double] = rgb_int_list(2).map(_.toDouble)

      val red_DLPS = red_DL.map(Math.pow(_,2)).sum/red_DL.length
      val green_DLPS = green_DL.map(Math.pow(_,2)).sum/green_DL.length
      val blue_DLPS = blue_DL.map(Math.pow(_,2)).sum/blue_DL.length

      val res1 = Math.sqrt(red_DLPS)
      val res2 = Math.sqrt(green_DLPS)
      val res3 = Math.sqrt(blue_DLPS)

      val result = MyRGBAux.double_to_hex_string(List(res1, res2, res3))
      result
   }

   //

   def average_combo(): List[String] = {
      val rgb_list_csv = MyUtility.read_file("/home/ema/data/rgb.txt")
      var splitted = ListBuffer[List[String]]()

      for(l <- rgb_list_csv) {
         splitted += l.split(",").toList
      }

      var pari = ListBuffer[String]()
      var dispari = ListBuffer[String]()

      for(l <- splitted) {
         if(l.nonEmpty) {
            pari += l.head
            dispari += l(1)
         }
      }

      val color1 = MyRGB.average_rgb_list(pari.toList)
      val color2 = MyRGB.average_rgb_list(dispari.toList)

      println(color1)
      println(color2)

      List(color1, color2)
   }

   def final_combo(rgb_list: List[String]): List[String] = {
      val ril = MyRGBAux.split_hex_to_int(rgb_list)

      val l0 = ril(0)
      val l1 = ril(1)
      val l2 = ril(2)

      val m1 = List(l0.head, l1.head, l2.head).min
      val m2 = List(l0(1), l1(1), l2(1)).min
      println(s"--- $m1 - $m2 ---")

      def replace_min(x: Int): Int = {
         if(x==m1 || x==m2 ) { 0 }
         else { x }
      }

      val res0 = ril.head.map(replace_min)
      val res1 = ril(1).map(replace_min)
      val res2 = ril(2).map(replace_min)
      println(s"$res0 - $res1 - $res2")

      val result1 = MyRGBAux.int_to_hex_string(List(res0.head, res1.head, res2.head))
      val result2 = MyRGBAux.int_to_hex_string(List(res0(1), res1(1), res2(1)))
      List(result1, result2)
   }
}
