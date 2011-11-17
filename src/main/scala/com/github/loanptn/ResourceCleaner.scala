package com.github.loanptn

trait ResourceCleaner[R] {
  def clean(res: R): Unit
}

object ResourceCleaner {
  import java.io._
  implicit val inputStreamResourceCleaner: ResourceCleaner[InputStream] = new ResourceCleaner[InputStream] {
    def clean(in: InputStream): Unit = in.close()
  }
  implicit val outputStreamResourceCleaner: ResourceCleaner[OutputStream] = new ResourceCleaner[OutputStream] {
    def clean(in: OutputStream): Unit = in.close()
  }
}

