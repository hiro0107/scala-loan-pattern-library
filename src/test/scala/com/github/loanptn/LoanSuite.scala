package com.github.loanptn

import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
 
class LoanSuite extends FunSuite with ShouldMatchers {
  test("usingが正常に使用できる") {
    import java.io._
    val res = mock(classOf[InputStream])
    using(res) { res => }
    verify(res, times(1)).close()
  }
}
