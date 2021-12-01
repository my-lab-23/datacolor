package my_utility

import java.io.{FileOutputStream, OutputStreamWriter, PrintWriter}

object MyUtility {

   def write_file(data: String, path: String, mode: Boolean): Unit = {
      val os = new FileOutputStream(path, mode)
      val pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"))
      pw.println(data)
      pw.close()
   }
}
