package com.github

package object loanptn {
  def using[A, R <: { def close() }](res: R)(f: (R) => A): A =
    try { f(res) } finally { res.close }
}
