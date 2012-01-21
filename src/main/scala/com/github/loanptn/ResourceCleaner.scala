package com.github.loanptn

import java.io.{Closeable => JCloseable}

/**
 * リソースをクリアするTrait
 * @tparam R リソースのクラス
 */
trait ResourceCleaner[R] {
  /**
   * リソースをクリアする
   * @param res リソース
   */
  def clean(res: R): Unit
}

/**
 * closeメソッドをもつリソースが対象のResourceCleaner
 * @tparam R closeメソッドを持つリソースのクラス
 */
class CloseableResourceCleaner extends ResourceCleaner[{ def close() }]{
  /**
   * closeメソッドを使いリソースをクリアする
   * @param res リソース
   */
  override def clean(res: { def close() }): Unit = res.close()
}

class JavaIoCloseableResourceCleaner extends ResourceCleaner[JCloseable]{
  /**
   * closeメソッドを使いリソースをクリアする
   * @param res リソース
   */
  override def clean(res: JCloseable): Unit = res.close()
}

/**
 * 各種implicit parameterの定義
 */
object ResourceCleaner {
  implicit val closeableResourceCleaner = new CloseableResourceCleaner
  implicit val javaIoCloseableResourceCleaner = new JavaIoCloseableResourceCleaner
}

