## Tips
### Make directory look better
Create new workspace scope to make it look better in Intelij/Android studio, you can use this pattern:
```
!file[*]:gradle//*&&!file[*]:iosApp//*&&!file[*]:.fleet//*&&!file[*]:gradle.properties&&!file[*]:gradlew&&!file[*]:.gitignore&&!file[*]:gradlew.bat&&!file[*]:.idea//*&&!file[*]:.kotlin//*&&!file[*]:src//*&&!file[*]:kotlin-js-store//*
```
![Watch](Brain/image/Directory%20Scope.gif)