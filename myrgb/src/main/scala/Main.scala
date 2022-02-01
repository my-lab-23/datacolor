import my_rgb.MyRGB
import my_utility.MyUtility

import scala.collection.mutable.ListBuffer

object Main {
   def main(args: Array[String]): Unit = {

      val avg_combo = MyRGB.average_combo()
      val fin_combo = MyRGB.final_combo(avg_combo)
      println(fin_combo)
   }
}
