/*
 * Run application from here.
 */
object Run {

  def main(args: Array[String]): Unit = {
    if (args.length < 1) {
      println("Please provide input string and optional minimum occurence")
      System.exit(1)
    } else {
      try {
        val compress1 = new StringCompressor
        val compress2 = new StringCompressor2
        val result1 = compress1.compressStr(args(0), if(args.length == 2) Some(args(1).toInt) else None)
        val result2 = compress2.compressStr(args(0), if(args.length == 2) Some(args(1).toInt) else None)
        println(s"Printing result1 \n$result1")
        println(s"Printing result2 \n$result1")
      } catch {
        case e: NumberFormatException => println(s"Invalid minimum occurence supplied - $e")
        case e: Exception => println(s"Something went wrong - $e")
      }

    }
  }

}
