# detekt

## Metrics

* 8 number of properties

* 13 number of functions

* 7 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 506 lines of code (loc)

* 455 source lines of code (sloc)

* 325 logical lines of code (lloc)

* 5 comment lines of code (cloc)

* 31 cyclomatic complexity (mcc)

* 31 cognitive complexity

* 9 number of total code smells

* 1% comment source ratio

* 95 mcc per 1,000 lloc

* 27 code smells per 1,000 lloc

## Findings (9)

### complexity, LongMethod (1)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:54:13
```
The function FavoritesScreenContent is too long (89). The maximum length is 60.
```
```kotlin
51 
52 @OptIn(ExperimentalMaterial3Api::class)
53 @Composable
54 private fun FavoritesScreenContent(
!!             ^ error
55     viewState: FavoritesViewState,
56     onSearchFavorites: (String) -> Unit,
57     onShowPlaceDetails: (PlaceUiModel) -> Unit,

```

### formatting, NoWildcardImports (3)

Detects wildcard imports

[Documentation](https://detekt.dev/docs/rules/formatting#nowildcardimports)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:3:1
```
Wildcard import
```
```kotlin
1 package com.vehiclecompanion.feature
2 
3 import androidx.compose.foundation.layout.*
! ^ error
4 import androidx.compose.foundation.lazy.LazyColumn
5 import androidx.compose.foundation.lazy.grid.GridCells
6 import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:10:1
```
Wildcard import
```
```kotlin
7  import androidx.compose.foundation.lazy.grid.items
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material3.*
!! ^ error
11 import androidx.compose.runtime.*
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:11:1
```
Wildcard import
```
```kotlin
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material3.*
11 import androidx.compose.runtime.*
!! ^ error
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier
14 import androidx.compose.ui.draw.clip

```

### style, MagicNumber (1)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:165:41
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
162     onPlaceClick: (PlaceUiModel) -> Unit,
163     onRemoveFavoriteClick: (PlaceUiModel) -> Unit
164 ) {
165     if (isLandscape && favorites.size > 4) {
!!!                                         ^ error
166         // Grid layout for landscape with many items
167         LazyVerticalGrid(
168             columns = GridCells.Adaptive(minSize = 280.dp),

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:36:5
```
Function parameter `navigator` is unused.
```
```kotlin
33 
34 @Composable
35 fun FavoritesScreen(
36     navigator: AppNavigator,
!!     ^ error
37     viewModel: FavoritesViewModel = hiltViewModel()
38 ) {
39     val viewState by viewModel.viewState.collectAsState()

```

### style, WildcardImport (3)

Wildcard imports should be replaced with imports using fully qualified class names. Wildcard imports can lead to naming conflicts. A library update can introduce naming clashes with your classes which results in compilation errors.

[Documentation](https://detekt.dev/docs/rules/style#wildcardimport)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:3:1
```
androidx.compose.foundation.layout.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
1 package com.vehiclecompanion.feature
2 
3 import androidx.compose.foundation.layout.*
! ^ error
4 import androidx.compose.foundation.lazy.LazyColumn
5 import androidx.compose.foundation.lazy.grid.GridCells
6 import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:10:1
```
androidx.compose.material3.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
7  import androidx.compose.foundation.lazy.grid.items
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material3.*
!! ^ error
11 import androidx.compose.runtime.*
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:11:1
```
androidx.compose.runtime.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material3.*
11 import androidx.compose.runtime.*
!! ^ error
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier
14 import androidx.compose.ui.draw.clip

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 15:23:27 UTC
