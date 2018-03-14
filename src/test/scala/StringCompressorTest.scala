import org.scalatest.FlatSpec

class StringCompressorTest extends FlatSpec {

  val strCompress = new StringCompressor

  "compressStr" should "compress string" in {
    val input = "QQQFAAABEEEDFFC"
    assert(strCompress.compressStr(input, 2) === "3QF3AB3ED2FC")
  }

}
