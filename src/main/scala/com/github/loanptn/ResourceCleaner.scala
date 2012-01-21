package com.github.loanptn

import java.io.{Closeable => JCloseable}

/**
 * リソースをクリアするTrait
 * @tparam R リソースのクラス
 */
trait ResourceCleaner[-R] {
  /**
   * リソースをクリアする
   * @param res リソース
   */
  def clean(res: R): Unit
}
/**
 * 各種implicit parameterの定義
 */
object ResourceCleaner {
  implicit val closeableResourceCleaner = new ResourceCleaner[{ def close() }]{
    override def clean(res: { def close() }): Unit = res.close()
  }
}

