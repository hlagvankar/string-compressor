import org.scalatest.FlatSpec

class StringCompressorTest extends FlatSpec {

  val strCompress = new StringCompressor

  "compressStr" should "compress string" in {
    val input = "QQQFAAABEEEDFFC"
    println(strCompress.compressStr(input, Some(3)))
    assert(strCompress.compressStr(input, Some(3)) === "3QF3AB3EDFFC")
  }

  "compressStr without minOccurence 1" should "compress string" in {
    val input = "AAABBCDDEEEFF"
    println(strCompress.compressStr(input, None))
    assert(strCompress.compressStr(input, None) === "3A2BC2D3E2F")
  }

  "compressStr withouth minOccurence 2" should "not print digits for single characters" in {
    val input = "ABCDEFGH"
    println(strCompress.compressStr(input, None))
    assert(strCompress.compressStr(input, None) === "ABCDEFGH")
  }

  "compressStr" should "throw exception" in {
    val input = "AAABBCDDEEEFF"
    val minOccurrence = Some(-2)
    assertThrows[Exception] {
      strCompress.compressStr(input, minOccurrence)
    }
  }


}
