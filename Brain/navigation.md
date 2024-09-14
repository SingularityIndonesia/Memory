# Design
```kotlin
@Composable  
fun Navigation(controller: NavHostController) {  
    NavHost(
	    navController = controller, 
	    startDestination = Feature1Route.route
	) {  
        Feature1Route<UnitParam, UnitResult>(  
            controller = controller,  
        ) {  
            Feature1Pane(  
                onNext = {  
                    val param = Feature2RouteParam(1)  
                    navigate(route = Feature2Route, param = param)  
                },  
            )  
        }  
  
        Feature2Route<Feature2RouteParam, UnitResult>(  
            controller = controller,  
        ) {  
            Feature2Pane(magicNumber = it.magicNumber)  
        }  
    }
}
```


# Rules
## 1. Pane Rule
   - A [[pane]] should not define its own [[route]], or how and where to put the [[pane]]. Navigation control should be separated from the [[pane]], following the [[separation of control principle]]
   - The pane should be hoisted or wrapped inside a [[route component]].


