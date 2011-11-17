package com.github.loanptn

trait ResourceCleaner[R] {
  def clean(res: R): Unit
}

class CloseableResourceCleaner[R <: { def close() }] extends ResourceCleaner[R]{
  override def clean(res: R): Unit = res.close()
}

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

