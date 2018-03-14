import org.scalatest.FlatSpec

class StringCompressorTest extends FlatSpec {

  val strCompress = new StringCompressor

  "compressStr" should "compress string" in {
    val input = "QQQFAAABEEEDFFC"
    println(strCompress.compressStr(input, Some(3)))
    assert(strCompress.compressStr(input, Some(3)) === "3QF3AB3EDFFC")
  }

  "compressStr without minOccurence" should "compress string" in {
    val input = "AAABBCDDEEEFF"
    println(strCompress.compressStr(input, None))
    assert(strCompress.compressStr(input, None) === "3A2BC2D3E2F")
  }

}
