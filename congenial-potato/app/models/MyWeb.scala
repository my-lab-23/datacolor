package models

import my_rgb.MyRGB

object MyWeb {

   object MyIndex {
      var rgb_list = MyRGB.get_rbg_list(4)

      def update_rgb_list(): Unit = {
         rgb_list = MyRGB.get_rbg_list(4)
         Uno.first_color = rgb_list(0)
         Uno.second_color = rgb_list(1)
         Due.first_color = rgb_list(2)
         Due.second_color = rgb_list(3)
      }

      def scelto_uno(): Unit = {
         var rgb_list: List[String] = List(Uno.first_color, Uno.second_color)
         MyRGB.save_rgb_list(rgb_list)
      }

      def scelto_due(): Unit = {
         var rgb_list: List[String] = List(Due.first_color, Due.second_color)
         MyRGB.save_rgb_list(rgb_list)
      }
   }
}
