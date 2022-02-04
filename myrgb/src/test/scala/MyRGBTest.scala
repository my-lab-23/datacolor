import my_rgb.MyRGB

import org.scalatest._
import flatspec._
import matchers._

class MyRGBTest extends AnyFlatSpec with should.Matchers {

   it should "calculate correct average of 2 colors - 1 of 4" in {
      val colors_average = MyRGB.average_rgb_list(List("#0eebe7", "#e1b1a8"))
      colors_average should be ("#9fd0c9")
   }

   it should "calculate correct average of 2 colors - 2 of 4" in {
      val colors_average = MyRGB.average_rgb_list(List("#0e0e0e", "#e1e1e1"))
      colors_average should be ("#9f9f9f")
   }

   it should "calculate correct average of 2 colors - 3 of 4" in {
      val colors_average = MyRGB.average_rgb_list(List("#ebebeb", "#b1b1b1"))
      colors_average should be ("#d0d0d0")
   }

   it should "calculate correct average of 2 colors - 4 of 4" in {
      val colors_average = MyRGB.average_rgb_list(List("#e7e7e7", "#a8a8a8"))
      colors_average should be ("#c9c9c9")
   }

   it should "calculate correct average of 4 colors" in {
      val colors_average = MyRGB.average_rgb_list(List("#020202", "#030303", "#040404", "#050505"))
      colors_average should be ("#030303")
   }

   it should "calculate correct final combo" in {
      val avg_combo = MyRGB.average_combo()
      val fin_combo = MyRGB.final_combo(avg_combo)
      fin_combo should be (List("#84007c", "#00979f"))
   }
}
