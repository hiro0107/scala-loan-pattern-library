package com.github

package object loanptn {

  def using[A, R](res: R)(f: (R) => A)(implicit resourceCleaner: ResourceCleaner[R]): A =
    try { f(res) } finally { resourceCleaner.clean(res) }
}
