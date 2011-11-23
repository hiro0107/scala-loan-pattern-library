package com.github.loanptn

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
class CloseableResourceCleaner[R <: { def close() }] extends ResourceCleaner[R]{
  /**
   * closeメソッドを使いリソースをクリアする
   * @param res リソース
   */
  override def clean(res: R): Unit = res.close()
}

/**
 * 各種implicit parameterの定義
 */
object ResourceCleaner {
  import java.io._
  implicit val inputStreamResourceCleaner = new CloseableResourceCleaner[InputStream]
  implicit val outputStreamResourceCleaner = new CloseableResourceCleaner[OutputStream]

  import scala.io._
  implicit val sourceResourceCleaner = new CloseableResourceCleaner[Source]

  import java.sql._
  implicit val connectionResourceCleaner = new CloseableResourceCleaner[Connection]
  implicit val statementResourceCleaner = new CloseableResourceCleaner[Statement]
  implicit val preparedStatementResourceCleaner = new CloseableResourceCleaner[PreparedStatement]
  implicit val resultSetResourceCleaner = new CloseableResourceCleaner[ResultSet]
}

