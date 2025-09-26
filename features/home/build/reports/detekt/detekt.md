# detekt

## Metrics

* 4 number of properties

* 4 number of functions

* 5 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 138 lines of code (loc)

* 121 source lines of code (sloc)

* 66 logical lines of code (lloc)

* 0 comment lines of code (cloc)

* 8 cyclomatic complexity (mcc)

* 3 cognitive complexity

* 7 number of total code smells

* 0% comment source ratio

* 121 mcc per 1,000 lloc

* 106 code smells per 1,000 lloc

## Findings (7)

### formatting, FinalNewline (4)

Detects missing final newlines

[Documentation](https://detekt.dev/docs/rules/formatting#finalnewline)

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeAction.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import com.vehiclecompanion.base.BaseAction
4 import com.vehiclecompanion.events.Event

```

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeScreen.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import androidx.compose.foundation.layout.Column
4 import androidx.compose.foundation.layout.fillMaxSize

```

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeViewModel.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import com.vehiclecompanion.base.BaseViewModel
4 import com.vehiclecompanion.events.IEventBus

```

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeViewState.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import com.vehiclecompanion.util.SingleUseValue
4 

```

### formatting, ImportOrdering (1)

Detects imports in non default order

[Documentation](https://detekt.dev/docs/rules/formatting#importordering)

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeScreen.kt:3:1
```
Imports must be ordered in lexicographic order without any empty lines in-between with "java", "javax", "kotlin" and aliases in the end
```
```kotlin
1 package com.vehiclecompanion.feature
2 
3 import androidx.compose.foundation.layout.Column
! ^ error
4 import androidx.compose.foundation.layout.fillMaxSize
5 import androidx.compose.foundation.layout.padding
6 import androidx.compose.material3.ExperimentalMaterial3Api

```

### formatting, NoBlankLineBeforeRbrace (1)

Detects blank lines before rbraces

[Documentation](https://detekt.dev/docs/rules/formatting#noblanklinebeforerbrace)

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeViewModel.kt:21:1
```
Unexpected blank line(s) before "}"
```
```kotlin
18 
19     override fun onActionReceived(viewAction: HomeAction) {
20         super.onActionReceived(viewAction)
21     }
!! ^ error
22 }
23 

```

### formatting, NoUnusedImports (1)

Detects unused imports

[Documentation](https://detekt.dev/docs/rules/formatting#nounusedimports)

* D:/PROJECTS/VehicleCompanion/features/home/src/main/java/com/vehiclecompanion/feature/HomeScreen.kt:17:1
```
Unused import
```
```kotlin
14 import androidx.compose.runtime.getValue
15 import androidx.compose.ui.Modifier
16 import androidx.compose.ui.res.painterResource
17 import androidx.compose.ui.res.stringResource
!! ^ error
18 import androidx.hilt.navigation.compose.hiltViewModel
19 import com.vehiclecompanion.navigation.AppNavigator
20 import com.vehiclecompanion.presentation.R

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 11:27:44 UTC
