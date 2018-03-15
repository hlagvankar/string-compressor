/*
 * StringCompressor class is built with recursive approach
 * It has 3 components
 * 1. compressStr
 * 2. execute
 * 3. append
 */
class StringCompressor extends compressor {

  /*
   * This method accepts two parameters
   * 1. input - input is String
   * 2. minOccurrence - minimum occurrence will tell us to compress string for those characters which are not less than minOccurrence.
   *                    This is optional parameter. If this parameter is not passed, it will compress string based on number of occurrences of
   *                    each characters.
   */
  override def compressStr(input: String, minOccurence: Option[Int]): String = {

    /*
     * Check whether minimum occurence is non-negative
     */
    minOccurence match {
      case Some(v) if v < 0 => throw new Exception(s"Invalid minOccurrence supplied ${minOccurence}")
      case _ => minOccurence
    }

    /*
     * This method takes input as list of characters.
     * last character: lastChar is matched with current character to find occurence. Initially value is different.
     * occurence: Initially 0 and then incremented as we go on finding same characters
     * acc: accumulator. Initially empty list of string. We will keep adding elements to List as we find them in given input
     */
    def execute(value: List[Char], lastChar: Char, occurrence: Int, acc: List[String]): List[String] = {
      value match {
        case h :: t if lastChar == h =>
          execute(t, h, occurrence + 1, acc)
        case h :: t if occurrence == minOccurence.getOrElse(0) && minOccurence.getOrElse(0) != 0 =>
          execute(t, h, 1, append(lastChar, occurrence) :: acc)
        case h :: t if occurrence > minOccurence.getOrElse(0) =>
          execute(t, h, 1, append(lastChar, occurrence) :: acc)
        case h :: t =>
          execute(t, h, 1, List.fill(occurrence)(lastChar).mkString :: acc)
        case _ if occurrence == minOccurence.getOrElse(0) && minOccurence.getOrElse(0) != 0 =>
          append(lastChar, occurrence) :: acc
        case _ if occurrence > minOccurence.getOrElse(0) =>
          append(lastChar, occurrence) :: acc
        case _ =>
          List.fill(occurrence)(lastChar).mkString :: acc
      }
    }

    execute(input.toList, Char.MinValue, 0, Nil).reverse.mkString
  }

  private def append(char: Char, repetition: Int) = {
    if (repetition == 1)
      s"$char"
    else
      s"$repetition$char"
  }

}
