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
        val compress = new StringCompressor
        val result = compress.compressStr(args(0), if(args.length == 2) Some(args(1).toInt) else None)
        println(s"$result")
      } catch {
        case e: NumberFormatException => println(s"Invalid minimum occurence supplied - $e")
        case e: Exception => println(s"Something went wrong - $e")
      }

    }
  }

}
