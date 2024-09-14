example:
```kotlin
@Composable  
fun Navigation(controller: NavHostController) {  
    NavHost(navController = controller, startDestination = Feature1Route.route) {  
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
    }}  
  
// # Feature 2 -------------------------------------------------------------------------------------  
val Feature1Route =  
    Route<UnitParam, UnitResult>(route = "feature1", title = "Feature 1", canGoBack = false)  
  
// # Feature 2 -------------------------------------------------------------------------------------  
// Note: never parse complex object to the parameter  
// Parse only essentials parameter like identifier and intent  
@Serializable  
data class Feature2RouteParam(  
    val magicNumber: Int,  
) : UrlParam  
  
val Feature2Route = Route<Feature2RouteParam, UnitResult>(route = "feature2", title = "Feature 2")
```

A route is intended for hoisting panels and abstracting panels for navigation.
A Route have optional `UrlParameter` and optional `NavigationResult`.

## Notes:
- **Important**: A route is not meant to handle panel logic or to interrupt the state of a panel, away from navigational context
- A route should only display pane, and intervene navigation intents.