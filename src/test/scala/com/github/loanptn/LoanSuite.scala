package com.github.loanptn

import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
 
class LoanSuite extends FunSuite with ShouldMatchers {
  import java.io._
  test("usingが正常に使用できる") {
    val res = mock(classOf[InputStream])
    using(res) { res => }
    verify(res, times(1)).close()
  }
  test("manageが正常に使用できる") {
    import java.io._
    val res = mock(classOf[InputStream])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }
  test("manageが正常に使用できる(その2)") {
    import java.io._
    val res = mock(classOf[InputStream])
    val res2 = mock(classOf[InputStream])
    for(in <- manage(res);
        in2 <- manage(res2)) {
      verify(res, never()).close()
      verify(res2, never()).close()
    }
    verify(res, times(1)).close()
  }
}
