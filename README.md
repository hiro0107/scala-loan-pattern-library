#ScalaでのLoan Pattern実装

#使い方
```
import com.github.loanptn._

import java.io._

var res: InputStream = ...;
using(res) { in =>
  // do something
}
```

or

```
import com.github.loanptn._

import java.io._

var res: InputStream = ...;
for(in <- manage(res)) {
  // do something
}
```
