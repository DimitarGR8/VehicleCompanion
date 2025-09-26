# detekt

## Metrics

* 6 number of properties

* 17 number of functions

* 10 number of classes

* 2 number of packages

* 4 number of kt files

## Complexity Report

* 491 lines of code (loc)

* 442 source lines of code (sloc)

* 313 logical lines of code (lloc)

* 6 comment lines of code (cloc)

* 37 cyclomatic complexity (mcc)

* 34 cognitive complexity

* 74 number of total code smells

* 1% comment source ratio

* 118 mcc per 1,000 lloc

* 236 code smells per 1,000 lloc

## Findings (74)

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
56     onLoadFavorites: () -> Unit,

```

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:53:35
```
The function FavoritesScreenContent(viewState: FavoritesViewState, onSearchFavorites: (String) -> Unit, onLoadFavorites: () -> Unit, onShowPlaceDetails: (PlaceUiModel) -> Unit, onHidePlaceDetails: () -> Unit, onRemoveFromFavorites: (PlaceUiModel) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
50 
51 @OptIn(ExperimentalMaterial3Api::class)
52 @Composable
53 private fun FavoritesScreenContent(
!!                                   ^ error
54     viewState: FavoritesViewState,
55     onSearchFavorites: (String) -> Unit,
56     onLoadFavorites: () -> Unit,

```

### formatting, ArgumentListWrapping (11)

Reports incorrect argument list wrapping

[Documentation](https://detekt.dev/docs/rules/formatting#argumentlistwrapping)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:82:38
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
79                 value = viewState.searchQuery,
80                 onValueChange = onSearchFavorites,
81                 label = { Text(stringResource(R.string.search_favorites_hint)) },
82                 leadingIcon = { Icon(
!!                                      ^ error
83                     painterResource(R.drawable.ic_search),
84                     contentDescription = stringResource(R.string.search)
85                 ) },

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:82:98
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
79                 value = viewState.searchQuery,
80                 onValueChange = onSearchFavorites,
81                 label = { Text(stringResource(R.string.search_favorites_hint)) },
82                 leadingIcon = { Icon(
!!                                                                                                  ^ error
83                     painterResource(R.drawable.ic_search),
84                     contentDescription = stringResource(R.string.search)
85                 ) },

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:84:4
```
Missing newline before ")"
```
```kotlin
81                 label = { Text(stringResource(R.string.search_favorites_hint)) },
82                 leadingIcon = { Icon(
83                     painterResource(R.drawable.ic_search),
84                     contentDescription = stringResource(R.string.search)
!!    ^ error
85                 ) },
86                 trailingIcon = {
87                     if (viewState.searchQuery.isNotEmpty()) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:88:92
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
85                 ) },
86                 trailingIcon = {
87                     if (viewState.searchQuery.isNotEmpty()) {
88                         IconButton(
!!                                                                                            ^ error
89                             onClick = { onSearchFavorites("") }
90                         ) {
91                             Icon(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:90:13
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
87                     if (viewState.searchQuery.isNotEmpty()) {
88                         IconButton(
89                             onClick = { onSearchFavorites("") }
90                         ) {
!!             ^ error
91                             Icon(
92                                 painterResource(R.drawable.ic_clear),
93                                 contentDescription = stringResource(R.string.clear)

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:93:19
```
Missing newline before ")"
```
```kotlin
90                         ) {
91                             Icon(
92                                 painterResource(R.drawable.ic_clear),
93                                 contentDescription = stringResource(R.string.clear)
!!                   ^ error
94                             )
95                         }
96                     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:112:32
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
109                 ErrorState(
110                     message = viewState.error!!,
111                     onRetry = onLoadFavorites
112                 )
!!!                                ^ error
113             }
114             viewState.displayFavorites.isEmpty() -> {
115                 EmptyState(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:113:13
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
110                     message = viewState.error!!,
111                     onRetry = onLoadFavorites
112                 )
113             }
!!!             ^ error
114             viewState.displayFavorites.isEmpty() -> {
115                 EmptyState(
116                     iconRes = R.drawable.ic_heart_outline,

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:114:17
```
Missing newline before ")"
```
```kotlin
111                     onRetry = onLoadFavorites
112                 )
113             }
114             viewState.displayFavorites.isEmpty() -> {
!!!                 ^ error
115                 EmptyState(
116                     iconRes = R.drawable.ic_heart_outline,
117                     title = if (viewState.searchQuery.isNotEmpty()) stringResource(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:342:2
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
339 @Composable
340 private fun RatingRow(rating: Int) {
341     Row(
342         verticalAlignment = Alignment.CenterVertically
!!!  ^ error
343     ) {
344         repeat(5) { index ->
345             Icon(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:343:35
```
Missing newline before ")"
```
```kotlin
340 private fun RatingRow(rating: Int) {
341     Row(
342         verticalAlignment = Alignment.CenterVertically
343     ) {
!!!                                   ^ error
344         repeat(5) { index ->
345             Icon(
346                 painter = if (index < rating) painterResource(

```

### formatting, FinalNewline (4)

Detects missing final newlines

[Documentation](https://detekt.dev/docs/rules/formatting#finalnewline)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature.favorites
! ^ error
2 
3 import com.vehiclecompanion.base.BaseAction
4 import com.vehiclecompanion.feature.FavoritesViewState

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import androidx.compose.foundation.layout.*
4 import androidx.compose.foundation.lazy.LazyColumn

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesViewModel.kt:1:1
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

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesViewState.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import com.vehiclecompanion.model.PlaceUiModel
4 

```

### formatting, ImportOrdering (1)

Detects imports in non default order

[Documentation](https://detekt.dev/docs/rules/formatting#importordering)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:3:1
```
Imports must be ordered in lexicographic order without any empty lines in-between with "java", "javax", "kotlin" and aliases in the end
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

### formatting, Indentation (7)

Reports mis-indented code

[Documentation](https://detekt.dev/docs/rules/formatting#indentation)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:53:1
```
Unexpected indentation (16) (should be 20)
```
```kotlin
50             if (query.isBlank()) return favorites
51             return favorites.filter { poi ->
52                 poi.name.contains(query, ignoreCase = true) ||
53                     poi.category.contains(query, ignoreCase = true)
!! ^ error
54             }
55         }
56     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:92:5
```
Unexpected indentation (16) (should be 20)
```
```kotlin
89             if (query.isBlank()) return favorites
90             return favorites.filter { poi ->
91                 poi.name.contains(query, ignoreCase = true) ||
92                     poi.category.contains(query, ignoreCase = true)
!!     ^ error
93             }
94         }
95     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:118:1
```
Unexpected indentation (28) (should be 24)
```
```kotlin
115                 EmptyState(
116                     iconRes = R.drawable.ic_heart_outline,
117                     title = if (viewState.searchQuery.isNotEmpty()) stringResource(
118                         R.string.no_items_found,
!!! ^ error
119                         stringResource(R.string.favorites).lowercase()
120                     ) else stringResource(R.string.no_favorites_yet),
121                     subtitle = if (viewState.searchQuery.isNotEmpty()) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:118:50
```
Unexpected indentation (28) (should be 24)
```
```kotlin
115                 EmptyState(
116                     iconRes = R.drawable.ic_heart_outline,
117                     title = if (viewState.searchQuery.isNotEmpty()) stringResource(
118                         R.string.no_items_found,
!!!                                                  ^ error
119                         stringResource(R.string.favorites).lowercase()
120                     ) else stringResource(R.string.no_favorites_yet),
121                     subtitle = if (viewState.searchQuery.isNotEmpty()) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:119:68
```
Unexpected indentation (24) (should be 20)
```
```kotlin
116                     iconRes = R.drawable.ic_heart_outline,
117                     title = if (viewState.searchQuery.isNotEmpty()) stringResource(
118                         R.string.no_items_found,
119                         stringResource(R.string.favorites).lowercase()
!!!                                                                    ^ error
120                     ) else stringResource(R.string.no_favorites_yet),
121                     subtitle = if (viewState.searchQuery.isNotEmpty()) {
122                         stringResource(R.string.try_adjusting_search)

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:346:52
```
Unexpected indentation (24) (should be 20)
```
```kotlin
343     ) {
344         repeat(5) { index ->
345             Icon(
346                 painter = if (index < rating) painterResource(
!!!                                                    ^ error
347                     R.drawable.ic_star
348                 ) else painterResource(R.drawable.ic_star_outline),
349                 contentDescription = null,

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:347:28
```
Unexpected indentation (20) (should be 16)
```
```kotlin
344         repeat(5) { index ->
345             Icon(
346                 painter = if (index < rating) painterResource(
347                     R.drawable.ic_star
!!!                            ^ error
348                 ) else painterResource(R.drawable.ic_star_outline),
349                 contentDescription = null,
350                 tint = MaterialTheme.colorScheme.primary,

```

### formatting, MultiLineIfElse (4)

Detects multiline if-else statements without braces

[Documentation](https://detekt.dev/docs/rules/formatting#multilineifelse)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:113:25
```
Missing { ... }
```
```kotlin
110                     message = viewState.error!!,
111                     onRetry = onLoadFavorites
112                 )
113             }
!!!                         ^ error
114             viewState.displayFavorites.isEmpty() -> {
115                 EmptyState(
116                     iconRes = R.drawable.ic_heart_outline,

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:115:27
```
Missing { ... }
```
```kotlin
112                 )
113             }
114             viewState.displayFavorites.isEmpty() -> {
115                 EmptyState(
!!!                           ^ error
116                     iconRes = R.drawable.ic_heart_outline,
117                     title = if (viewState.searchQuery.isNotEmpty()) stringResource(
118                         R.string.no_items_found,

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:198:2
```
Missing { ... }
```
```kotlin
195 @Composable
196 private fun FavoriteCard(
197     place: PlaceUiModel,
198     isGridView: Boolean,
!!!  ^ error
199     onClick: () -> Unit,
200     onRemoveFavoriteClick: () -> Unit
201 ) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:200:11
```
Missing { ... }
```
```kotlin
197     place: PlaceUiModel,
198     isGridView: Boolean,
199     onClick: () -> Unit,
200     onRemoveFavoriteClick: () -> Unit
!!!           ^ error
201 ) {
202     Card(
203         onClick = onClick,

```

### formatting, NoBlankLineBeforeRbrace (1)

Detects blank lines before rbraces

[Documentation](https://detekt.dev/docs/rules/formatting#noblanklinebeforerbrace)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesViewModel.kt:18:1
```
Unexpected blank line(s) before "}"
```
```kotlin
15 
16     override fun onActionReceived(viewAction: FavoritesAction) {
17         super.onActionReceived(viewAction)
18     }
!! ^ error
19 }
20 

```

### formatting, NoTrailingSpaces (33)

Detects trailing spaces

[Documentation](https://detekt.dev/docs/rules/formatting#notrailingspaces)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:11:1
```
Trailing space(s)
```
```kotlin
8  
9  sealed interface FavoritesAction : BaseAction<FavoritesViewState> {
10     data object LoadFavorites : FavoritesAction
11 
!! ^ error
12     data class RemoveFromFavorites(val poi: PlaceUiModel) : FavoritesAction
13 
14     data class ShowPlaceDetails(val poi: PlaceUiModel) : FavoritesAction {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:12:73
```
Trailing space(s)
```
```kotlin
9  sealed interface FavoritesAction : BaseAction<FavoritesViewState> {
10     data object LoadFavorites : FavoritesAction
11 
12     data class RemoveFromFavorites(val poi: PlaceUiModel) : FavoritesAction
!!                                                                         ^ error
13 
14     data class ShowPlaceDetails(val poi: PlaceUiModel) : FavoritesAction {
15         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:16:26
```
Trailing space(s)
```
```kotlin
13 
14     data class ShowPlaceDetails(val poi: PlaceUiModel) : FavoritesAction {
15         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
16             previousData.update {
!!                          ^ error
17                 it.copy(
18                     selectedPlace = poi,
19                     showPlaceDetails = true

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:20:9
```
Trailing space(s)
```
```kotlin
17                 it.copy(
18                     selectedPlace = poi,
19                     showPlaceDetails = true
20                 )
!!         ^ error
21             }
22         }
23     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:22:7
```
Trailing space(s)
```
```kotlin
19                     showPlaceDetails = true
20                 )
21             }
22         }
!!       ^ error
23     }
24 
25     data object HidePlaceDetails : FavoritesAction {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:27:20
```
Trailing space(s)
```
```kotlin
24 
25     data object HidePlaceDetails : FavoritesAction {
26         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
27             previousData.update {
!!                    ^ error
28                 it.copy(
29                     selectedPlace = null,
30                     showPlaceDetails = false

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:31:3
```
Trailing space(s)
```
```kotlin
28                 it.copy(
29                     selectedPlace = null,
30                     showPlaceDetails = false
31                 )
!!   ^ error
32             }
33         }
34     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:33:1
```
Trailing space(s)
```
```kotlin
30                     showPlaceDetails = false
31                 )
32             }
33         }
!! ^ error
34     }
35 
36     data class SearchFavorites(val query: String) : FavoritesAction

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:36:49
```
Trailing space(s)
```
```kotlin
33         }
34     }
35 
36     data class SearchFavorites(val query: String) : FavoritesAction
!!                                                 ^ error
37 
38     data class FavoritesLoaded(val favorites: List<PlaceUiModel>) : FavoritesAction {
39         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:46:1
```
Trailing space(s)
```
```kotlin
43                     filteredFavorites = filterFavorites(favorites, currentState.searchQuery),
44                     error = null
45                 )
46             }
!! ^ error
47         }
48 
49         private fun filterFavorites(favorites: List<PlaceUiModel>, query: String): List<PlaceUiModel> {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:53:63
```
Trailing space(s)
```
```kotlin
50             if (query.isBlank()) return favorites
51             return favorites.filter { poi ->
52                 poi.name.contains(query, ignoreCase = true) ||
53                     poi.category.contains(query, ignoreCase = true)
!!                                                               ^ error
54             }
55         }
56     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:59:84
```
Trailing space(s)
```
```kotlin
56     }
57 
58     data class FavoritesLoadError(val error: String) : FavoritesAction {
59         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
!!                                                                                    ^ error
60             previousData.update {
61                 it.copy(error = error)
62             }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:61:2
```
Trailing space(s)
```
```kotlin
58     data class FavoritesLoadError(val error: String) : FavoritesAction {
59         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
60             previousData.update {
61                 it.copy(error = error)
!!  ^ error
62             }
63         }
64     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:61:33
```
Trailing space(s)
```
```kotlin
58     data class FavoritesLoadError(val error: String) : FavoritesAction {
59         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
60             previousData.update {
61                 it.copy(error = error)
!!                                 ^ error
62             }
63         }
64     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:67:78
```
Trailing space(s)
```
```kotlin
64     }
65 
66     data class SearchComplete(val query: String, val filteredFavorites: List<PlaceUiModel>) : FavoritesAction {
67         override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
!!                                                                              ^ error
68             previousData.update {
69                 it.copy(
70                     searchQuery = query,

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:71:33
```
Trailing space(s)
```
```kotlin
68             previousData.update {
69                 it.copy(
70                     searchQuery = query,
71                     filteredFavorites = filteredFavorites
!!                                 ^ error
72                 )
73             }
74         }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:72:6
```
Trailing space(s)
```
```kotlin
69                 it.copy(
70                     searchQuery = query,
71                     filteredFavorites = filteredFavorites
72                 )
!!      ^ error
73             }
74         }
75     }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:83:95
```
Trailing space(s)
```
```kotlin
80                 val updatedFavorites = currentState.favorites.filterNot { it.id == poiId }
81                 currentState.copy(
82                     favorites = updatedFavorites,
83                     filteredFavorites = filterFavorites(updatedFavorites, currentState.searchQuery)
!!                                                                                               ^ error
84                 )
85             }
86         }

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:75:1
```
Trailing space(s)
```
```kotlin
72             style = MaterialTheme.typography.headlineMedium,
73             fontWeight = FontWeight.Bold
74         )
75 
!! ^ error
76         // Search Bar
77         if (viewState.favorites.isNotEmpty()) {
78             OutlinedTextField(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:97:3
```
Trailing space(s)
```
```kotlin
94                              )
95                          }
96                      }
97                  },
!!    ^ error
98                  modifier = Modifier
99                      .fillMaxWidth()
100                     .padding(vertical = Dimens.halfDefaultPadding),

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:99:55
```
Trailing space(s)
```
```kotlin
96                      }
97                  },
98                  modifier = Modifier
99                      .fillMaxWidth()
!!                                                        ^ error
100                     .padding(vertical = Dimens.halfDefaultPadding),
101                 singleLine = true
102             )

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:128:7
```
Trailing space(s)
```
```kotlin
125                     },
126                     actionText = stringResource(R.string.browse_places),
127                     onActionClick = { /* TODO: Navigate to Places tab */ }
128                 )
!!!       ^ error
129             }
130             else -> {
131                 FavoritesList(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:231:36
```
Trailing space(s)
```
```kotlin
228     Column(
229         modifier = Modifier.fillMaxSize()
230     ) {
231         Box(
!!!                                    ^ error
232             modifier = Modifier
233                 .fillMaxWidth()
234                 .height(120.dp)

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:242:3
```
Trailing space(s)
```
```kotlin
239                 modifier = Modifier.fillMaxSize(),
240                 contentScale = ContentScale.Crop
241             )
242 
!!!   ^ error
243             IconButton(
244                 onClick = onRemoveFavoriteClick,
245                 modifier = Modifier.align(Alignment.TopEnd)

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:256:16
```
Trailing space(s)
```
```kotlin
253         }
254 
255         Column(
256             modifier = Modifier
!!!                ^ error
257                 .fillMaxSize()
258                 .padding(Dimens.halfDefaultPadding)
259         ) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:264:4
```
Trailing space(s)
```
```kotlin
261                 text = place.name,
262                 style = MaterialTheme.typography.titleMedium,
263                 fontWeight = FontWeight.Bold,
264                 maxLines = 1,
!!!    ^ error
265                 overflow = TextOverflow.Ellipsis
266             )
267 

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:265:7
```
Trailing space(s)
```
```kotlin
262                 style = MaterialTheme.typography.titleMedium,
263                 fontWeight = FontWeight.Bold,
264                 maxLines = 1,
265                 overflow = TextOverflow.Ellipsis
!!!       ^ error
266             )
267 
268             Text(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:290:42
```
Trailing space(s)
```
```kotlin
287 ) {
288     Row(
289         modifier = Modifier
290             .fillMaxSize()
!!!                                          ^ error
291             .padding(Dimens.halfDefaultPadding),
292         verticalAlignment = Alignment.CenterVertically
293     ) {

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:291:42
```
Trailing space(s)
```
```kotlin
288     Row(
289         modifier = Modifier
290             .fillMaxSize()
291             .padding(Dimens.halfDefaultPadding),
!!!                                          ^ error
292         verticalAlignment = Alignment.CenterVertically
293     ) {
294         AsyncImage(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:302:40
```
Trailing space(s)
```
```kotlin
299                 .clip(RoundedCornerShape(Dimens.halfDefaultPadding)),
300             contentScale = ContentScale.Crop
301         )
302 
!!!                                        ^ error
303         Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
304 
305         Column(

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:310:50
```
Trailing space(s)
```
```kotlin
307         ) {
308             Text(
309                 text = place.name,
310                 style = MaterialTheme.typography.titleMedium,
!!!                                                  ^ error
311                 fontWeight = FontWeight.Bold,
312                 maxLines = 1,
313                 overflow = TextOverflow.Ellipsis

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:312:21
```
Trailing space(s)
```
```kotlin
309                 text = place.name,
310                 style = MaterialTheme.typography.titleMedium,
311                 fontWeight = FontWeight.Bold,
312                 maxLines = 1,
!!!                     ^ error
313                 overflow = TextOverflow.Ellipsis
314             )
315 

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:315:1
```
Trailing space(s)
```
```kotlin
312                 maxLines = 1,
313                 overflow = TextOverflow.Ellipsis
314             )
315 
!!! ^ error
316             Text(
317                 text = place.category,
318                 style = MaterialTheme.typography.bodyMedium,

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

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:13:1
```
Wildcard import
```
```kotlin
10 import androidx.compose.material3.*
11 import androidx.compose.runtime.*
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier
!! ^ error
14 import androidx.compose.ui.draw.clip
15 import androidx.compose.ui.layout.ContentScale
16 import androidx.compose.ui.platform.LocalConfiguration

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:14:1
```
Wildcard import
```
```kotlin
11 import androidx.compose.runtime.*
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier
14 import androidx.compose.ui.draw.clip
!! ^ error
15 import androidx.compose.ui.layout.ContentScale
16 import androidx.compose.ui.platform.LocalConfiguration
17 import androidx.compose.ui.res.painterResource

```

### naming, InvalidPackageDeclaration (1)

Kotlin source files should be stored in the directory corresponding to its package statement.

[Documentation](https://detekt.dev/docs/rules/naming#invalidpackagedeclaration)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesAction.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package com.vehiclecompanion.feature.favorites
! ^ error
2 
3 import com.vehiclecompanion.base.BaseAction
4 import com.vehiclecompanion.feature.FavoritesViewState

```

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:123:42
```
Forbidden TODO todo marker
```
```kotlin
120                     ) else stringResource(R.string.no_favorites_yet),
121                     subtitle = if (viewState.searchQuery.isNotEmpty()) {
122                         stringResource(R.string.try_adjusting_search)
123                     } else {
!!!                                          ^ error
124                         stringResource(R.string.add_places_from_places_tab)
125                     },
126                     actionText = stringResource(R.string.browse_places),

```

### style, MagicNumber (2)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:153:76
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
150 }
151 
152 @Composable
153 private fun FavoritesList(
!!!                                                                            ^ error
154     favorites: List<PlaceUiModel>,
155     isLandscape: Boolean,
156     onPlaceClick: (PlaceUiModel) -> Unit,

```

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:334:4
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
331                 painter = painterResource(R.drawable.ic_heart),
332                 contentDescription = "Remove from favorites",
333                 tint = MaterialTheme.colorScheme.error
334             )
!!!    ^ error
335         }
336     }
337 }

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:34:5
```
Function parameter `navigator` is unused.
```
```kotlin
31 
32 @Composable
33 fun FavoritesScreen(
34     navigator: AppNavigator,
!!     ^ error
35     viewModel: FavoritesViewModel = hiltViewModel()
36 ) {
37     val viewState by viewModel.viewState.collectAsState()

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

* D:/PROJECTS/VehicleCompanion/features/favorites/src/main/java/com/vehiclecompanion/feature/FavoritesScreen.kt:10:37
```
androidx.compose.runtime.* is a wildcard import. Replace it with fully qualified imports.
```
```kotlin
7  import androidx.compose.foundation.lazy.grid.items
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material3.*
!!                                     ^ error
11 import androidx.compose.runtime.*
12 import androidx.compose.ui.Alignment
13 import androidx.compose.ui.Modifier

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 11:27:44 UTC
