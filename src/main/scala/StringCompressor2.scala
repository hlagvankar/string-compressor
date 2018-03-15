/*
 * Second class to compress string using foldLeft function
 */

class StringCompressor2(util: Utils) extends compressor {

  override def compressStr(input: String, minOccurrence: Option[Int]): String = {
    util.validateMinOccurrence(minOccurrence)
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
