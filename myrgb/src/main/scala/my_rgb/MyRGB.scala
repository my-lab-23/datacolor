package my_rgb

import my_utility.MyUtility

import scala.collection.mutable.ListBuffer

object MyRGB {

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

      val path = sys.env("MY_DATA_PATH")
      val mode = true
      MyUtility.write_file(rgb_list_csv, s"$path/rgb.txt", mode)
   }
}
