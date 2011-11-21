package com.github.loanptn

class ManagedResource[R](res: R, resourceCleaner: ResourceCleaner[R]) {
  def foreach(f: (R) => Unit): Unit = try { f(res) } finally { resourceCleaner.clean(res) }
}
