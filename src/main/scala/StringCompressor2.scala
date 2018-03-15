/*
 * Second class to compress string using foldLeft function
 */

class StringCompressor2 extends compressor {

  override def compressStr(input: String, minOccurrence: Option[Int]): String = {
    /*
     * Check whether minimum occurence is non-negative
    */
    minOccurrence match {
      case Some(v) if v < 0 => throw new Exception(s"Invalid minOccurrence supplied $minOccurrence")
      case _ => minOccurrence
    }
    execute(input.toList, minOccurrence.getOrElse(0))
  }

  def execute(str: List[Char], minOccurrence: Int): String = {
    str.foldLeft(List.empty[(Char, Int)]) { (a, c) =>
      a match {
        case (`c`, n) :: tail => (c, n + 1) :: tail
        case _ => (c, 1) :: a
      }
    }.reverse.view.map {
      case (c, 1) => c.toString
      case (c, n) => {
        if (n < minOccurrence) List.fill(n)(c).mkString else s"$n$c"
      }
    }.mkString
  }

}
