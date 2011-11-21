#Scala‚Å‚ÌLoan PatternŽÀ‘•

#Žg‚¢•û
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
