package my_utility

import java.io.{FileOutputStream, OutputStreamWriter, PrintWriter}
import java.nio.charset.CodingErrorAction
import scala.io.{Codec, Source}

object MyUtility {

   def write_file(data: String, path: String, mode: Boolean): Unit = {
      val os = new FileOutputStream(path, mode)
      val pw = new PrintWriter(new OutputStreamWriter(os, "UTF-8"))
      pw.println(data)
      pw.close()
   }

   def read_file(path: String): List[String] = {
      val decoder = Codec.UTF8.decoder.onMalformedInput(CodingErrorAction.IGNORE)
      val source = Source.fromFile(path)(decoder)
      var list = List[String]()
      for (line <- source.getLines())
         list = line :: list
      list
   }
}
