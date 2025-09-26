# detekt

## Metrics

* 4 number of properties

* 4 number of functions

* 5 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 143 lines of code (loc)

* 123 source lines of code (sloc)

* 66 logical lines of code (lloc)

* 0 comment lines of code (cloc)

* 8 cyclomatic complexity (mcc)

* 3 cognitive complexity

* 3 number of total code smells

* 0% comment source ratio

* 121 mcc per 1,000 lloc

* 45 code smells per 1,000 lloc

## Findings (3)

### formatting, NoUnusedImports (3)

Detects unused imports

[Documentation](https://detekt.dev/docs/rules/formatting#nounusedimports)

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeScreen.kt:19:1
```
Unnecessary import
```
```kotlin
16 import androidx.compose.ui.res.painterResource
17 import androidx.compose.ui.res.stringResource
18 import androidx.hilt.navigation.compose.hiltViewModel
19 import com.vehiclecompanion.navigation.AppNavigator
!! ^ error
20 import com.vehiclecompanion.presentation.R
21 
22 @OptIn(ExperimentalMaterial3Api::class)

```

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeScreen.kt:19:1
```
Unnecessary import
```
```kotlin
16 import androidx.compose.ui.res.painterResource
17 import androidx.compose.ui.res.stringResource
18 import androidx.hilt.navigation.compose.hiltViewModel
19 import com.vehiclecompanion.navigation.AppNavigator
!! ^ error
20 import com.vehiclecompanion.presentation.R
21 
22 @OptIn(ExperimentalMaterial3Api::class)

```

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeScreen.kt:19:1
```
Unnecessary import
```
```kotlin
16 import androidx.compose.ui.res.painterResource
17 import androidx.compose.ui.res.stringResource
18 import androidx.hilt.navigation.compose.hiltViewModel
19 import com.vehiclecompanion.navigation.AppNavigator
!! ^ error
20 import com.vehiclecompanion.presentation.R
21 
22 @OptIn(ExperimentalMaterial3Api::class)

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 13:40:12 UTC
