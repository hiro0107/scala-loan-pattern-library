package com.github.loanptn

/**
 * 管理されたリソース
 */
class ManagedResource[R](resAndCleaner: => (R, ResourceCleaner[R]) ){
  // 何度もapplyが呼ばれても、問題が起きないようにキャッシュする
  private lazy val resourceAndCleaner = resAndCleaner

  def cleaner() = resourceAndCleaner._2
  def resource() = resourceAndCleaner._1
  def apply() = resource
  def flatMap[B](f: (R) => ManagedResource[B]): ManagedResource[B] =
    new ManagedResource[B]({
      val (res, cleaner) = this.resourceAndCleaner
      try {
        val managedB = f(res)
        managedB.resourceAndCleaner
      } finally {
        cleaner.clean(res)
      }
    })

  def map[B]
        (f: (R) => B)
        (implicit cleaner: ResourceCleaner[B]
           = new ResourceCleaner[B]{
               def clean(res: B): Unit = {}
             } ):ManagedResource[B] =
    flatMap { r =>
      new ManagedResource[B]( (f(r), cleaner) )
    }

  def foreach(f: (R) => Unit): Unit = { map(f).apply(); }

  override def equals(o: Any) = o match {
    case ManagedResource(r: R) => r == this.resource
    case _ => false
  }
}

object ManagedResource {
  def unapply[R](res: ManagedResource[R]) = Some(res.resource)
}
