class StringCompressor extends compressor {

  override def compressStr(input: String, minOccurence: Option[Int]): String = {

    minOccurence match {
      case Some(v) if v < 0 => throw new Exception(s"Invalid minOccurrence supplied ${minOccurence}")
      case _ => minOccurence
    }

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
