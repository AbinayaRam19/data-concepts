package Test

import java.io.FileNotFoundException
import scala.io.Source

object DATest extends  App{

  def decode(messageFile: String)= {

    var decodedMessage = ""
    try {

      val lines = Source.fromFile(messageFile).getLines().toList
      val words = lines.map(_.split(" ").last)
      val sortedWords = words.zipWithIndex.sortBy(_._2).map(_._1)
      decodedMessage = sortedWords.mkString(" ")
    }catch {
      case e: FileNotFoundException =>
        println(s"Error : File '$messageFile' not found.")
    }
    decodedMessage
    }

  val decodedMessage = decode("C:\\Users\\jeswa\\Downloads\\coding_qual_input.txt")
  print(decodedMessage)

}
