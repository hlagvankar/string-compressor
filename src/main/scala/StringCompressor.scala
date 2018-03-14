class StringCompressor extends compressor {

  override def compressStr(input: String, minOccurence: Option[Int]): String = {
    //    input.foldLeft(List.empty[(Char, Int)]) { (a, e) =>
    //      a match {
    //        case Nil => (e, 1) :: a
    //        case ((lastChar, lastCharCount) :: list) if lastChar == e => (lastChar, lastCharCount + 1) :: list
    //        case list => (e, 1) :: list
    //      }
    //    }.reverse.map{case (ele, num) => if(num <= 1) s"$ele" else s"$num$ele" }.foldLeft("")(_ ++ _)
    def execute(value: List[Char], lastChar: Char, occurrence: Int, acc: List[String]): List[String] = {
      println(s"$value, $lastChar, $occurrence, $acc")
      value match {
        case h :: t if lastChar == h =>
          execute(t, h, occurrence + 1, acc)
        case h :: t if occurrence == minOccurence.getOrElse(0) && minOccurence.getOrElse(0) != 0 =>
          execute(t, h, 1, appendReptition(lastChar, occurrence) :: acc)
        case h :: t if occurrence > minOccurence.getOrElse(0) =>
          execute(t, h, 1, appendReptition(lastChar, occurrence) :: acc)
        case h :: t =>
          execute(t, h, 1, List.fill(0)(lastChar).mkString :: acc)
        case _ if occurrence == minOccurence.getOrElse(0) && minOccurence.getOrElse(0) != 0 =>
          appendReptition(lastChar, occurrence) :: acc
        case _ if occurrence > minOccurence.getOrElse(0) =>
          appendReptition(lastChar, occurrence) :: acc
        case _ =>
          List.fill(0)(lastChar).mkString :: acc
      }
    }

    execute(input.toList, Char.MinValue, 0, Nil).reverse.mkString
  }

  private def appendReptition(char: Char, repetition: Int) = {
    println(s"$repetition$char")
    s"$repetition$char"
  }

}
