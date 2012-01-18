package com.github

/**
 * Loan Patternの実装
 *
 * {{{
import com.github.loanptn._

import java.io._

val res: InputStream = ...;
using(res) { in =>
  // do something
}
 * }}} or
 * {{{
import com.github.loanptn._

import java.io._

val res: InputStream = ...;
for(in <- manage(res)) {
  // do something
}
 * }}} or
 * {{{
import com.github.loanptn._

import java.io._

val res: InputStream = ...;
val res2: InputStream = ...;
val x = for(in <- manage(res);
    in2 <- manage(res2)) yield {
  // do something and return a result
  result
}
 * }}}
 */
package object loanptn {

  def using[A, R](res: R)(f: (R) => A)(implicit resourceCleaner: ResourceCleaner[R]): A =
    try { f(res) } finally { resourceCleaner.clean(res) }

  def manage[A, R](res: R)(implicit resourceCleaner: ResourceCleaner[R]): ManagedResource[R]  = new ManagedResource( (res, resourceCleaner) )

}
