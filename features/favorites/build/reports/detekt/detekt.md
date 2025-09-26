# detekt

## Metrics

* 8 number of properties

* 13 number of functions

* 7 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 494 lines of code (loc)

* 442 source lines of code (sloc)

* 315 logical lines of code (lloc)

* 5 comment lines of code (cloc)

* 31 cyclomatic complexity (mcc)

* 31 cognitive complexity

* 22 number of total code smells

* 1% comment source ratio

* 98 mcc per 1,000 lloc

* 69 code smells per 1,000 lloc

## Findings (22)

### complexity, LongMethod (1)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:53:13
```
The function FavoritesScreenContent is too long (79). The maximum length is 60.
```
```kotlin
50 
51 @OptIn(ExperimentalMaterial3Api::class)
52 @Composable
53 private fun FavoritesScreenContent(
!!             ^ error
54     viewState: FavoritesViewState,
55     onSearchFavorites: (String) -> Unit,
56     onShowPlaceDetails: (PlaceUiModel) -> Unit,

```

### formatting, Indentation (7)

Reports mis-indented code

[Documentation](https://detekt.dev/docs/rules/formatting#indentation)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:50:1
```
Unexpected indentation (32) (should be 28)
```
```kotlin
47                 } else {
48                     currentState.favorites.filter { favorite ->
49                         favorite.name.contains(query, ignoreCase = true) ||
50                             favorite.category.contains(query, ignoreCase = true)
!! ^ error
51                     }
52                 }
53 

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:83:1
```
Unexpected indentation (20) (should be 24)
```
```kotlin
80                 label = { Text(stringResource(R.string.search_favorites_hint)) },
81                 leadingIcon = {
82                     Icon(
83                         painterResource(R.drawable.ic_search),
!! ^ error
84                         contentDescription = stringResource(R.string.search)
85                     )
86                 },

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:84:5
```
Unexpected indentation (20) (should be 24)
```
```kotlin
81                 leadingIcon = {
82                     Icon(
83                         painterResource(R.drawable.ic_search),
84                         contentDescription = stringResource(R.string.search)
!!     ^ error
85                     )
86                 },
87                 trailingIcon = {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:85:9
```
Unexpected indentation (16) (should be 20)
```
```kotlin
82                     Icon(
83                         painterResource(R.drawable.ic_search),
84                         contentDescription = stringResource(R.string.search)
85                     )
!!         ^ error
86                 },
87                 trailingIcon = {
88                     if (viewState.searchQuery.isNotEmpty()) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:114:13
```
Unexpected indentation (24) (should be 28)
```
```kotlin
111                     iconRes = R.drawable.ic_heart_outline,
112                     title = if (viewState.searchQuery.isNotEmpty()) {
113                         stringResource(
114                             R.string.no_items_found,
!!!             ^ error
115                             stringResource(R.string.favorites).lowercase()
116                         )
117                     } else {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:115:17
```
Unexpected indentation (24) (should be 28)
```
```kotlin
112                     title = if (viewState.searchQuery.isNotEmpty()) {
113                         stringResource(
114                             R.string.no_items_found,
115                             stringResource(R.string.favorites).lowercase()
!!!                 ^ error
116                         )
117                     } else {
118                         stringResource(R.string.no_favorites_yet)

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:116:21
```
Unexpected indentation (20) (should be 24)
```
```kotlin
113                         stringResource(
114                             R.string.no_items_found,
115                             stringResource(R.string.favorites).lowercase()
116                         )
!!!                     ^ error
117                     } else {
118                         stringResource(R.string.no_favorites_yet)
119                     },

```

### formatting, MultiLineIfElse (2)

Detects multiline if-else statements without braces

[Documentation](https://detekt.dev/docs/rules/formatting#multilineifelse)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:110:69
```
Missing { ... }
```
```kotlin
107 
108         when {
109             viewState.displayFavorites.isEmpty() -> {
110                 EmptyState(
!!!                                                                     ^ error
111                     iconRes = R.drawable.ic_heart_outline,
112                     title = if (viewState.searchQuery.isNotEmpty()) {
113                         stringResource(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:114:6
```
Missing { ... }
```
```kotlin
111                     iconRes = R.drawable.ic_heart_outline,
112                     title = if (viewState.searchQuery.isNotEmpty()) {
113                         stringResource(
114                             R.string.no_items_found,
!!!      ^ error
115                             stringResource(R.string.favorites).lowercase()
116                         )
117                     } else {

```

### formatting, NoConsecutiveBlankLines (1)

Reports consecutive blank lines

[Documentation](https://detekt.dev/docs/rules/formatting#noconsecutiveblanklines)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:339:1
```
Needless blank line(s)
```
```kotlin
336     }
337 }
338 

```

### formatting, NoTrailingSpaces (1)

Detects trailing spaces

[Documentation](https://detekt.dev/docs/rules/formatting#notrailingspaces)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesViewModel.kt:31:1
```
Trailing space(s)
```
```kotlin
28 
29     override fun onActionReceived(viewAction: FavoritesAction) {
30         super.onActionReceived(viewAction)
31 
!! ^ error
32         when (viewAction) {
33             is FavoritesAction.RemoveFromFavorites -> {
34                 handleRemoveFromFavorites(viewAction.poi)

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

### formatting, Wrapping (2)

Reports missing newlines (e.g. between parentheses of a multi-line function call

[Documentation](https://detekt.dev/docs/rules/formatting#wrapping)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:81:32
```
Missing newline after "{"
```
```kotlin
78                 value = viewState.searchQuery,
79                 onValueChange = onSearchFavorites,
80                 label = { Text(stringResource(R.string.search_favorites_hint)) },
81                 leadingIcon = {
!!                                ^ error
82                     Icon(
83                         painterResource(R.drawable.ic_search),
84                         contentDescription = stringResource(R.string.search)

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:85:17
```
Missing newline before "}"
```
```kotlin
82                     Icon(
83                         painterResource(R.drawable.ic_search),
84                         contentDescription = stringResource(R.string.search)
85                     )
!!                 ^ error
86                 },
87                 trailingIcon = {
88                     if (viewState.searchQuery.isNotEmpty()) {

```

### style, MagicNumber (1)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:156:13
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
153     favorites: List<PlaceUiModel>,
154     isLandscape: Boolean,
155     onPlaceClick: (PlaceUiModel) -> Unit,
156     onRemoveFavoriteClick: (PlaceUiModel) -> Unit
!!!             ^ error
157 ) {
158     if (isLandscape && favorites.size > 4) {
159         // Grid layout for landscape with many items

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:35:5
```
Function parameter `navigator` is unused.
```
```kotlin
32 
33 @Composable
34 fun FavoritesScreen(
35     navigator: AppNavigator,
!!     ^ error
36     viewModel: FavoritesViewModel = hiltViewModel()
37 ) {
38     val viewState by viewModel.viewState.collectAsState()

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

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 13:40:12 UTC
