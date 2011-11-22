package com.github.loanptn

class ManagedResource[R](res: R, resourceCleaner: ResourceCleaner[R]){
  def flatMap[B](f: (R) => ManagedResource[B]): ManagedResource[B] = try { f(res) } finally { resourceCleaner.clean(res) }
  def map[B](f: (R) => B)(implicit cleaner: ResourceCleaner[B] = new ResourceCleaner[B] { def clean(res: B): Unit = {} } ):ManagedResource[B] =
    try {
      new ManagedResource(f(res), cleaner)
    } finally {
      resourceCleaner.clean(res)
    }
  def foreach(f: (R) => Unit): Unit = try { f(res) } finally { resourceCleaner.clean(res) }
  def apply() = res
}
