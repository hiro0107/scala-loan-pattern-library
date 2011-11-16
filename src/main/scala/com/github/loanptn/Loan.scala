package com.github.loanptn

object Loan {
  def using[A, R <: { def close() }](res: R)(f: (R) => A): A =
    try { f(res) } finally { res.close }
}
