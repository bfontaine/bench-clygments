# Bench-Clygments

This repo contains code to test and/or benchmark [`clygments`][cl].

[cl]: https://github.com/bfontaine/clygments

## Setup

    ./setup.sh

Then open a REPL (`lein repl`) and use e.g.:

```clojure
(require '[bench-clygments.core :as bc])

;; Highlight all 463 Git .c files: ~87s
(time (bc/highlight-codebase :git))

;; Other codebase:
:jython3 ; all 1090 Jython3 .java files: ~155s
:rouge ; all 327 Rouge .rb files: 17s
```

Number of files and times above were obtained using the  Clygments 2.0 on the
2019/03/21.

## License

Copyright © 2019 Baptiste Fontaine

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
