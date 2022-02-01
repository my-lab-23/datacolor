import my_rgb.MyRGB

import org.scalatest._
import flatspec._
import matchers._

class MyRGBTest extends AnyFlatSpec with should.Matchers {

   it should "calculate correct average 1" in {
      val two_colors_average = MyRGB.average_rgb_list(List("#0eebe7", "#e1b1a8"))
      two_colors_average should be ("#9fd0c9")
   }

   it should "calculate correct average 2" in {
      val two_colors_average = MyRGB.average_rgb_list(List("#0e0e0e", "#e1e1e1"))
      two_colors_average should be ("#9f9f9f")
   }

   it should "calculate correct average 3" in {
      val two_colors_average = MyRGB.average_rgb_list(List("#ebebeb", "#b1b1b1"))
      two_colors_average should be ("#d0d0d0")
   }

   it should "calculate correct average 4" in {
      val two_colors_average = MyRGB.average_rgb_list(List("#e7e7e7", "#a8a8a8"))
      two_colors_average should be ("#c9c9c9")
   }

   it should "4 colors" in {
      val two_colors_average = MyRGB.average_rgb_list(List("#020202", "#030303", "#040404", "#050505"))
      two_colors_average should be ("#050505")
   }
}
