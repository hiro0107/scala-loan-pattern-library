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
