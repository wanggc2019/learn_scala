import example.CubeCalculator
import org.scalatest.FunSuite

/**
  * @author wanggc
  * @date 2019/10/08 ζζδΊ 9:51
  */
object CubeCalculatorTest extends FunSuite {

  test("CubeCalculator.cude") {
    assert(CubeCalculator.cube(3) == 27)
  }

}
