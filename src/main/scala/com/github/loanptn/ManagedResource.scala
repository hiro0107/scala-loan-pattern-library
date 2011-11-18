package com.github.loanptn

class ManagedResource[R](res: R, resourceCleaner: ResourceCleaner[R]) {
  def flatMap[A](f: (R) => ManagedResource[A]): ManagedResource[A] = try { f(res) } finally { resourceCleaner.clean(res) }
  def foreach(f: (R) => Unit): Unit = try { f(res) } finally { resourceCleaner.clean(res) }
}
