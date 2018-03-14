class StringCompressor extends compressor {

  override def compressStr(input: String, minOccurency: Int): String = {
    input.foldLeft(List.empty[(Char, Int)]) { (acc, e) =>
      acc match {
        case Nil => (e, 1) :: Nil
        case ((lastChar, lastCharCount) :: xs) if lastChar == e => (lastChar, lastCharCount + 1) :: xs
        case xs => (e, 1) :: xs
      }
    }.reverse.map{case (a, num) => s"$num$a" }.foldLeft("")(_ ++ _)
  }

}
