# Design


# Rules
## 1. Pane Rule
   A [[pane]] should not define its own [[route]], or how and where to put the [[pane]]. Navigation control should be separated from the [[pane]], following the [[separation of control principle]].

The pane should be hoisted or wrapped inside a [[route component]].
```kotlin
package com.singularityindonesia.navigation.route

@Composable
fun HomeRoute() {
	HomePane()
}

# -------------------------------------------------------------------------------
# -------------------------------------------------------------------------------

package com.singularityindonesia.home.presentation.pane.home
@Composable
fun HomePane() {
	...
}
```


