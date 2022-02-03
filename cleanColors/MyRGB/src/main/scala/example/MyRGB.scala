package myRGB

import java.io.File
import scala.jdk.CollectionConverters._

object MyRGB {

   private var path = ""

   try { path = sys.env("MY_DATA_PATH") }
   catch { 
      case e: NoSuchElementException =>
         new File("./data").mkdir()
         path = "./data"
   }

   def getRGB: String = {
   
      val rgb = "#%06x".format(scala.util.Random.nextInt(1 << 24))
      rgb
   }

   def saveRGB(temp: java.util.List[String]): Unit = {
   
      val rgb = temp.asScala
      var rgbCsv = ""

      for(e <- rgb) {
         rgbCsv = e + "," + rgbCsv
      }

      val mode = true
      MyUtility.writeFile(rgbCsv, s"$path/rgb.txt", mode)
   }
}
