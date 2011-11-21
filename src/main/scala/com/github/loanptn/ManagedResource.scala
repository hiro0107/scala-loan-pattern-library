package com.github.loanptn

class ManagedResource[R](res: R, resourceCleaner: ResourceCleaner[R]){
  class VoidResourceCleaner[S] extends ResourceCleaner[S]{
    def clean(res: S): Unit = {}
  }
  def flatMap[B](f: (R) => ManagedResource[B]): ManagedResource[B] = try { f(res) } finally { resourceCleaner.clean(res) }
  def map[B](f: (R) => B)(implicit cleaner: ResourceCleaner[B] = new VoidResourceCleaner[B]):ManagedResource[B] =
    try {
      new ManagedResource(f(res), cleaner)
    } finally {
      resourceCleaner.clean(res)
    }
  def foreach(f: (R) => Unit): Unit = try { f(res) } finally { resourceCleaner.clean(res) }
  def resource() = res
}
