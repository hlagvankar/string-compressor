class StringCompressor extends compressor {

  override def compressStr(input: String, minOccurency: Int): String = {
    input.foldLeft(List.empty[(Char, Int)]) { (a, e) =>
      a match {
        case Nil => (e, 1) :: a
        case ((lastChar, lastCharCount) :: xs) if lastChar == e => (lastChar, lastCharCount + 1) :: xs
        case xs => (e, 1) :: xs
      }
    }.reverse.map{case (a, num) => if(num <= 1) s"$a" else s"$num$a" }.foldLeft("")(_ ++ _)
  }

}
