package com.github.loanptn

import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
 
class LoanSuite extends FunSuite with ShouldMatchers {
  import java.io._
  test("usingが正常に使用できる") {
    val res = mock(classOf[InputStream])
    using(res) { res =>
      verify(res, never()).close()
    }
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
    val inOrd = inOrder(res, res2)
    inOrd.verify(res2, times(1)).close()
    inOrd.verify(res, times(1)).close()
  }

  test("OutputStreamでmanageが正常に使用できる") {
    import java.io._
    var res = mock(classOf[OutputStream])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }

  test("Sourceでmanageが正常に使用できる") {
    import scala.io._
    var res = mock(classOf[Source])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }

  test("Connectionでmanageが正常に使用できる") {
    import java.sql._
    var res = mock(classOf[Connection])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }

  test("Statementでmanageが正常に使用できる") {
    import java.sql._
    var res = mock(classOf[Statement])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }

  test("PreparedStatementでmanageが正常に使用できる") {
    import java.sql._
    var res = mock(classOf[PreparedStatement])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }

  test("ResultSetでmanageが正常に使用できる") {
    import java.sql._
    var res = mock(classOf[ResultSet])
    for(in <- manage(res)) {
      verify(res, never()).close()
    }
    verify(res, times(1)).close()
  }

}
