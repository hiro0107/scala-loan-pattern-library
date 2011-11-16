package com.github.loanptn

import com.github.loanptn.Loan._
import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
 
class LoanSuite extends FunSuite with ShouldMatchers {
  test("usingが正常に使用できる") {
    val res = mock(classOf[Resource1])
    using(res) { res =>
    }
    verify(res, times(1)).close()
  }
}
