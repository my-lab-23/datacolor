import my_rgb.MyRGB

object Main {
   def main(args: Array[String]): Unit = {

      val rgb_list = MyRGB.get_rbg_list(4)

      for(l <- rgb_list) {
         println(l)
      }

      MyRGB.save_rgb_list(rgb_list)
   }
}
