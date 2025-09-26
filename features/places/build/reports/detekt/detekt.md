# detekt

## Metrics

* 5 number of properties

* 12 number of functions

* 6 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 512 lines of code (loc)

* 465 source lines of code (sloc)

* 330 logical lines of code (lloc)

* 6 comment lines of code (cloc)

* 36 cyclomatic complexity (mcc)

* 67 cognitive complexity

* 61 number of total code smells

* 1% comment source ratio

* 109 mcc per 1,000 lloc

* 184 code smells per 1,000 lloc

## Findings (61)

### complexity, LongMethod (1)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:73:13
```
The function PlacesScreenContent is too long (108). The maximum length is 60.
```
```kotlin
70 
71 @OptIn(ExperimentalMaterial3Api::class)
72 @Composable
73 private fun PlacesScreenContent(
!!             ^ error
74     viewState: PlacesViewState,
75     onToggleViewMode: () -> Unit,
76     onSearchPlaces: (String) -> Unit,

```

### complexity, LongParameterList (2)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:73:32
```
The function PlacesScreenContent(viewState: PlacesViewState, onToggleViewMode: () -> Unit, onSearchPlaces: (String) -> Unit, onLoadPlaces: () -> Unit, onShowPlaceDetails: (PlaceUiModel) -> Unit, onHidePlaceDetails: () -> Unit, onToggleFavorite: (PlaceUiModel) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
70 
71 @OptIn(ExperimentalMaterial3Api::class)
72 @Composable
73 private fun PlacesScreenContent(
!!                                ^ error
74     viewState: PlacesViewState,
75     onToggleViewMode: () -> Unit,
76     onSearchPlaces: (String) -> Unit,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:210:29
```
The function PlacesList(places: List<PlaceUiModel>, favorites: Set<Int>, isListView: Boolean, isLandscape: Boolean, onPlaceClick: (PlaceUiModel) -> Unit, onFavoriteClick: (PlaceUiModel) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
207             onFavoriteClick = { onToggleFavorite(viewState.selectedPlace!!) }
208         )
209     }
210 }
!!!                             ^ error
211 
212 @Composable
213 private fun PlacesList(

```

### formatting, ArgumentListWrapping (4)

Reports incorrect argument list wrapping

[Documentation](https://detekt.dev/docs/rules/formatting#argumentlistwrapping)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:110:87
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
107                         painter = if (viewState.isListView) {
108                             painterResource(R.drawable.ic_grid)
109                         } else {
110                             painterResource(
!!!                                                                                       ^ error
111                                 R.drawable.ic_list
112                             )
113                         },

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:111:11
```
Missing newline before ")"
```
```kotlin
108                             painterResource(R.drawable.ic_grid)
109                         } else {
110                             painterResource(
111                                 R.drawable.ic_list
!!!           ^ error
112                             )
113                         },
114                         contentDescription = if (viewState.isListView) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:300:10
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
297         Box(
298             modifier = Modifier
299                 .fillMaxWidth()
300                 .height(120.dp)
!!!          ^ error
301         ) {
302             AsyncImage(
303                 model = place.imageUrl,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:301:19
```
Missing newline before ")"
```
```kotlin
298             modifier = Modifier
299                 .fillMaxWidth()
300                 .height(120.dp)
301         ) {
!!!                   ^ error
302             AsyncImage(
303                 model = place.imageUrl,
304                 contentDescription = place.name,

```

### formatting, FinalNewline (4)

Detects missing final newlines

[Documentation](https://detekt.dev/docs/rules/formatting#finalnewline)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import com.vehiclecompanion.base.BaseAction
4 import com.vehiclecompanion.model.PlaceUiModel

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import androidx.compose.foundation.layout.Arrangement
4 import androidx.compose.foundation.layout.Box

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewModel.kt:1:1
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

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewState.kt:1:1
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

### formatting, Indentation (15)

Reports mis-indented code

[Documentation](https://detekt.dev/docs/rules/formatting#indentation)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:111:1
```
Unexpected indentation (28) (should be 32)
```
```kotlin
108                             painterResource(R.drawable.ic_grid)
109                         } else {
110                             painterResource(
111                                 R.drawable.ic_list
!!! ^ error
112                             )
113                         },
114                         contentDescription = if (viewState.isListView) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:112:5
```
Unexpected indentation (24) (should be 28)
```
```kotlin
109                         } else {
110                             painterResource(
111                                 R.drawable.ic_list
112                             )
!!!     ^ error
113                         },
114                         contentDescription = if (viewState.isListView) {
115                             stringResource(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:120:9
```
Unexpected indentation (28) (should be 32)
```
```kotlin
117                             )
118                         } else {
119                             stringResource(
120                                 R.string.switch_to_list
!!!         ^ error
121                             )
122                         }
123                     )

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:121:13
```
Unexpected indentation (24) (should be 28)
```
```kotlin
118                         } else {
119                             stringResource(
120                                 R.string.switch_to_list
121                             )
!!!             ^ error
122                         }
123                     )
124                 }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:172:17
```
Unexpected indentation (24) (should be 28)
```
```kotlin
169                     iconRes = R.drawable.ic_map_pin,
170                     title = if (viewState.searchQuery.isNotEmpty()) {
171                         stringResource(
172                             R.string.no_items_found,
!!!                 ^ error
173                             stringResource(R.string.places).lowercase()
174                         )
175                     } else {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:173:21
```
Unexpected indentation (24) (should be 28)
```
```kotlin
170                     title = if (viewState.searchQuery.isNotEmpty()) {
171                         stringResource(
172                             R.string.no_items_found,
173                             stringResource(R.string.places).lowercase()
!!!                     ^ error
174                         )
175                     } else {
176                         stringResource(R.string.no_places_available)

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:175:3
```
Unexpected indentation (20) (should be 24)
```
```kotlin
172                             R.string.no_items_found,
173                             stringResource(R.string.places).lowercase()
174                         )
175                     } else {
!!!   ^ error
176                         stringResource(R.string.no_places_available)
177                     },
178                     subtitle = if (viewState.searchQuery.isNotEmpty()) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:318:29
```
Unexpected indentation (24) (should be 28)
```
```kotlin
315                         painterResource(R.drawable.ic_heart)
316                     } else {
317                         painterResource(
318                             R.drawable.ic_heart_outline
!!!                             ^ error
319                         )
320                     },
321                     contentDescription = if (isFavorite) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:320:11
```
Unexpected indentation (20) (should be 24)
```
```kotlin
317                         painterResource(
318                             R.drawable.ic_heart_outline
319                         )
320                     },
!!!           ^ error
321                     contentDescription = if (isFavorite) {
322                         stringResource(
323                             R.string.remove_from_favorites

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:327:37
```
Unexpected indentation (24) (should be 28)
```
```kotlin
324                         )
325                     } else {
326                         stringResource(
327                             R.string.add_to_favorites
!!!                                     ^ error
328                         )
329                     },
330                     tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:329:19
```
Unexpected indentation (20) (should be 24)
```
```kotlin
326                         stringResource(
327                             R.string.add_to_favorites
328                         )
329                     },
!!!                   ^ error
330                     tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
331                 )
332             }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:416:45
```
Unexpected indentation (20) (should be 24)
```
```kotlin
413                     painterResource(R.drawable.ic_heart)
414                 } else {
415                     painterResource(
416                         R.drawable.ic_heart_outline
!!!                                             ^ error
417                     )
418                 },
419                 contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:419:12
```
Unexpected indentation (16) (should be 20)
```
```kotlin
416                         R.drawable.ic_heart_outline
417                     )
418                 },
419                 contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
!!!            ^ error
420                 tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
421             )
422         }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:438:6
```
Unexpected indentation (20) (should be 24)
```
```kotlin
435                 } else {
436                     painterResource(
437                         R.drawable.ic_star_outline
438                     )
!!!      ^ error
439                 },
440                 contentDescription = null,
441                 tint = MaterialTheme.colorScheme.primary,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:440:20
```
Unexpected indentation (16) (should be 20)
```
```kotlin
437                         R.drawable.ic_star_outline
438                     )
439                 },
440                 contentDescription = null,
!!!                    ^ error
441                 tint = MaterialTheme.colorScheme.primary,
442                 modifier = Modifier.size(16.dp)
443             )

```

### formatting, MaximumLineLength (1)

Reports lines with exceeded length

[Documentation](https://detekt.dev/docs/rules/formatting#maximumlinelength)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:330:1
```
Exceeded max line length (120)
```
```kotlin
327                             R.string.add_to_favorites
328                         )
329                     },
330                     tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
!!! ^ error
331                 )
332             }
333         }

```

### formatting, MultiLineIfElse (18)

Detects multiline if-else statements without braces

[Documentation](https://detekt.dev/docs/rules/formatting#multilineifelse)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:107:61
```
Missing { ... }
```
```kotlin
104                     onClick = onToggleViewMode
105                 ) {
106                     Icon(
107                         painter = if (viewState.isListView) {
!!!                                                             ^ error
108                             painterResource(R.drawable.ic_grid)
109                         } else {
110                             painterResource(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:108:40
```
Missing { ... }
```
```kotlin
105                 ) {
106                     Icon(
107                         painter = if (viewState.isListView) {
108                             painterResource(R.drawable.ic_grid)
!!!                                        ^ error
109                         } else {
110                             painterResource(
111                                 R.drawable.ic_list

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:112:41
```
Missing { ... }
```
```kotlin
109                         } else {
110                             painterResource(
111                                 R.drawable.ic_list
112                             )
!!!                                         ^ error
113                         },
114                         contentDescription = if (viewState.isListView) {
115                             stringResource(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:120:10
```
Missing { ... }
```
```kotlin
117                             )
118                         } else {
119                             stringResource(
120                                 R.string.switch_to_list
!!!          ^ error
121                             )
122                         }
123                     )

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:166:19
```
Missing { ... }
```
```kotlin
163                     onRetry = onLoadPlaces
164                 )
165             }
166 
!!!                   ^ error
167             viewState.displayPlaces.isEmpty() -> {
168                 EmptyState(
169                     iconRes = R.drawable.ic_map_pin,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:169:61
```
Missing { ... }
```
```kotlin
166 
167             viewState.displayPlaces.isEmpty() -> {
168                 EmptyState(
169                     iconRes = R.drawable.ic_map_pin,
!!!                                                             ^ error
170                     title = if (viewState.searchQuery.isNotEmpty()) {
171                         stringResource(
172                             R.string.no_items_found,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:176:2
```
Missing { ... }
```
```kotlin
173                             stringResource(R.string.places).lowercase()
174                         )
175                     } else {
176                         stringResource(R.string.no_places_available)
!!!  ^ error
177                     },
178                     subtitle = if (viewState.searchQuery.isNotEmpty()) {
179                         stringResource(R.string.try_adjusting_search)

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:178:19
```
Missing { ... }
```
```kotlin
175                     } else {
176                         stringResource(R.string.no_places_available)
177                     },
178                     subtitle = if (viewState.searchQuery.isNotEmpty()) {
!!!                   ^ error
179                         stringResource(R.string.try_adjusting_search)
180                     } else {
181                         stringResource(R.string.check_connection_try_again)

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:267:58
```
Missing { ... }
```
```kotlin
264     onClick: () -> Unit,
265     onFavoriteClick: () -> Unit
266 ) {
267     Card(
!!!                                                          ^ error
268         onClick = onClick,
269         modifier = Modifier
270             .fillMaxWidth()

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:273:27
```
Missing { ... }
```
```kotlin
270             .fillMaxWidth()
271             .then(
272                 if (isGridView) {
273                     Modifier.height(200.dp)
!!!                           ^ error
274                 } else {
275                     Modifier.height(120.dp)
276                 }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:306:27
```
Missing { ... }
```
```kotlin
303                 model = place.imageUrl,
304                 contentDescription = place.name,
305                 modifier = Modifier.fillMaxSize(),
306                 contentScale = ContentScale.Crop
!!!                           ^ error
307             )
308 
309             IconButton(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:306:117
```
Missing { ... }
```
```kotlin
303                 model = place.imageUrl,
304                 contentDescription = place.name,
305                 modifier = Modifier.fillMaxSize(),
306                 contentScale = ContentScale.Crop
!!!                                                                                                                     ^ error
307             )
308 
309             IconButton(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:316:5
```
Missing { ... }
```
```kotlin
313                 Icon(
314                     painter = if (isFavorite) {
315                         painterResource(R.drawable.ic_heart)
316                     } else {
!!!     ^ error
317                         painterResource(
318                             R.drawable.ic_heart_outline
319                         )

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:319:44
```
Missing { ... }
```
```kotlin
316                     } else {
317                         painterResource(
318                             R.drawable.ic_heart_outline
319                         )
!!!                                            ^ error
320                     },
321                     contentDescription = if (isFavorite) {
322                         stringResource(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:405:57
```
Missing { ... }
```
```kotlin
402                 overflow = TextOverflow.Ellipsis
403             )
404 
405             Spacer(modifier = Modifier.height(Dimens.smallPadding))
!!!                                                         ^ error
406 
407             RatingRow(rating = place.rating)
408         }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:406:35
```
Missing { ... }
```
```kotlin
403             )
404 
405             Spacer(modifier = Modifier.height(Dimens.smallPadding))
406 
!!!                                   ^ error
407             RatingRow(rating = place.rating)
408         }
409 

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:428:5
```
Missing { ... }
```
```kotlin
425 
426 @Composable
427 private fun RatingRow(rating: Int) {
428     Row(
!!!     ^ error
429         verticalAlignment = Alignment.CenterVertically
430     ) {
431         repeat(5) { index ->

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:429:47
```
Missing { ... }
```
```kotlin
426 @Composable
427 private fun RatingRow(rating: Int) {
428     Row(
429         verticalAlignment = Alignment.CenterVertically
!!!                                               ^ error
430     ) {
431         repeat(5) { index ->
432             Icon(

```

### formatting, NoBlankLineBeforeRbrace (1)

Detects blank lines before rbraces

[Documentation](https://detekt.dev/docs/rules/formatting#noblanklinebeforerbrace)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewModel.kt:17:1
```
Unexpected blank line(s) before "}"
```
```kotlin
14 
15     override fun onActionReceived(viewAction: PlacesAction) {
16         super.onActionReceived(viewAction)
17     }
!! ^ error
18 }
19 

```

### formatting, NoTrailingSpaces (9)

Detects trailing spaces

[Documentation](https://detekt.dev/docs/rules/formatting#notrailingspaces)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:10:1
```
Trailing space(s)
```
```kotlin
7  
8  sealed interface PlacesAction : BaseAction<PlacesViewState> {
9      data object LoadPlaces : PlacesAction
10 
!! ^ error
11     data object ToggleViewMode : PlacesAction {
12         override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
13             previousData.update { it.copy(isListView = !it.isListView) }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:15:3
```
Trailing space(s)
```
```kotlin
12         override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
13             previousData.update { it.copy(isListView = !it.isListView) }
14         }
15     }
!!   ^ error
16 
17     data class ShowPlaceDetails(val poi: PlaceUiModel) : PlacesAction {
18         override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:19:26
```
Trailing space(s)
```
```kotlin
16 
17     data class ShowPlaceDetails(val poi: PlaceUiModel) : PlacesAction {
18         override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
19             previousData.update {
!!                          ^ error
20                 it.copy(
21                     selectedPlace = poi,
22                     showPlaceDetails = true

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:23:9
```
Trailing space(s)
```
```kotlin
20                 it.copy(
21                     selectedPlace = poi,
22                     showPlaceDetails = true
23                 )
!!         ^ error
24             }
25         }
26     }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:25:7
```
Trailing space(s)
```
```kotlin
22                     showPlaceDetails = true
23                 )
24             }
25         }
!!       ^ error
26     }
27 
28     data object HidePlaceDetails : PlacesAction {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:30:20
```
Trailing space(s)
```
```kotlin
27 
28     data object HidePlaceDetails : PlacesAction {
29         override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
30             previousData.update {
!!                    ^ error
31                 it.copy(
32                     selectedPlace = null,
33                     showPlaceDetails = false

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:34:3
```
Trailing space(s)
```
```kotlin
31                 it.copy(
32                     selectedPlace = null,
33                     showPlaceDetails = false
34                 )
!!   ^ error
35             }
36         }
37     }

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:36:1
```
Trailing space(s)
```
```kotlin
33                     showPlaceDetails = false
34                 )
35             }
36         }
!! ^ error
37     }
38 
39     data class ToggleFavorite(val poi: PlaceUiModel) : PlacesAction

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:39:49
```
Trailing space(s)
```
```kotlin
36         }
37     }
38 
39     data class ToggleFavorite(val poi: PlaceUiModel) : PlacesAction
!!                                                 ^ error
40 
41     data class SearchPlaces(val query: String) : PlacesAction
42 }

```

### style, MagicNumber (4)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:214:27
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
211 
212 @Composable
213 private fun PlacesList(
214     places: List<PlaceUiModel>,
!!!                           ^ error
215     favorites: Set<Int>,
216     isListView: Boolean,
217     isLandscape: Boolean,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:425:56
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
422         }
423     }
424 }
425 
!!!                                                        ^ error
426 @Composable
427 private fun RatingRow(rating: Int) {
428     Row(

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewState.kt:15:32
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
12     val searchQuery: String = "",
13     val error: String? = null,
14     val swCornerLat: Double = 39.079888,
15     val swCornerLng: Double = -84.540499,
!!                                ^ error
16     val neCornerLat: Double = 39.113254,
17     val neCornerLng: Double = -84.494260
18 ) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewState.kt:17:32
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
14     val swCornerLat: Double = 39.079888,
15     val swCornerLng: Double = -84.540499,
16     val neCornerLat: Double = 39.113254,
17     val neCornerLng: Double = -84.494260
!!                                ^ error
18 ) {
19     val displayPlaces: List<PlaceUiModel>
20         get() = if (searchQuery.isBlank()) places else filteredPlaces

```

### style, MaxLineLength (1)

Line detected, which is longer than the defined maximum line length in the code style.

[Documentation](https://detekt.dev/docs/rules/style#maxlinelength)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:324:16
```
Line detected, which is longer than the defined maximum line length in the code style.
```
```kotlin
321                     contentDescription = if (isFavorite) {
322                         stringResource(
323                             R.string.remove_from_favorites
324                         )
!!!                ^ error
325                     } else {
326                         stringResource(
327                             R.string.add_to_favorites

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:53:5
```
Function parameter `navigator` is unused.
```
```kotlin
50 
51 @Composable
52 fun PlacesScreen(
53     navigator: AppNavigator,
!!     ^ error
54     viewModel: PlacesViewModel = hiltViewModel()
55 ) {
56     val viewState by viewModel.viewState.collectAsState()

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 11:27:44 UTC
