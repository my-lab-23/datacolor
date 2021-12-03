import my_rgb.MyRGB
import my_utility.MyUtility

import scala.collection.mutable.ListBuffer

object Main {
   def main(args: Array[String]): Unit = {

      /*
      val rgb_list = MyRGB.get_rbg_list(4)

      for(l <- rgb_list) {
         println(l)
      }

      MyRGB.save_rgb_list(rgb_list)
      */

      val l = MyRGB.average_combo()
      val r = MyRGB.final_combo(List(l.head, l(1)))
      r.foreach(println)
   }
}
