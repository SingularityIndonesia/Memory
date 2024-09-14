example:
```kotlin
  
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