example:
```kotlin
NavHost(navController = controller, startDestination = "pane1") {  
    route<UnitParam, UnitResult>(  
        route = "pane1",  
        title = "Feature1Pane",  
        controller = controller,  
        canGoBack = false,  
    ) {  
        Feature1Pane(  
            onNext = {  
                val param = Feature2Route2Param(1)  
                navigate("pane2", param = param)  
            },  
        )  
    }  
  
    route<Feature2Route2Param, UnitResult>(  
        route = "pane2",  
        title = "Feature2Pane",  
        controller = controller,  
    ) {  
        Feature2Pane(magicNumber = it.magicNumber)  
    }  
}
```

A route is intended for hoisting panels and abstracting panels for navigation.
A Route have optional `UrlParameter` and optional `NavigationResult`.

## Notes:
- **Important**: A route is not meant to handle panel logic or to interrupt the state of a panel, away from navigational context
- A route should only display pane, and intervene navigation intents.