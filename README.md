#ScalaでのLoan Pattern実装

##使い方
```
import com.github.loanptn._

import java.io._

val res: InputStream = ...;
using(res) { in =>
  // do something
}
```

or

```
import com.github.loanptn._

import java.io._

val res: InputStream = ...;
for(in <- manage(res)) {
  // do something
}
```

or

```
import com.github.loanptn._

import java.io._

val res: InputStream = ...;
val res2: InputStream = ...;
val x = for(in <- manage(res);
    in2 <- manage(res2)) yield {
  // do something and return a result
  result
}
// このapplyを呼んだ時点で実行がされる
val result = x()
```

以下のように合成もできる

```
import java.io._

val res: InputStream = ...;
val res2: InputStream = ...;
val x1 = for(in <- manage(res)) yield {
  // do something and return a result
  result1
}
val x2 = for(result1 <- x1;
            in <- manage(res)) yield {
  // do something and return a result
  (result1, result2)
}
val (result1, result2) = x2()
```

sbtを使用の方は以下のライブラリを加えて下さい。

```
resolvers += "hiro0107 repository" at "https://github.com/hiro0107/maven-repo/raw/master/release"

libraryDependencies ++= Seq(
  "com.github.loanptn" % "scala-loan-pattern-library" % "1.1"
)
```

