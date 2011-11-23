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
```
