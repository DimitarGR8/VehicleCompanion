# detekt

## Metrics

* 14 number of properties

* 17 number of functions

* 7 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 658 lines of code (loc)

* 596 source lines of code (sloc)

* 414 logical lines of code (lloc)

* 7 comment lines of code (cloc)

* 48 cyclomatic complexity (mcc)

* 68 cognitive complexity

* 8 number of total code smells

* 1% comment source ratio

* 115 mcc per 1,000 lloc

* 19 code smells per 1,000 lloc

## Findings (8)

### complexity, LongMethod (2)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:73:17
```
The function PlacesScreenContent is too long (105). The maximum length is 60.
```
```kotlin
70 }
71 
72 @OptIn(ExperimentalMaterial3Api::class)
73 @Composable
!!                 ^ error
74 private fun PlacesScreenContent(
75     viewState: PlacesViewState,
76     onToggleViewMode: () -> Unit,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:275:65
```
The function GridPlaceCardContent is too long (61). The maximum length is 60.
```
```kotlin
272             GridPlaceCardContent(place, isFavorite, onFavoriteClick)
273         } else {
274             ListPlaceCardContent(place, isFavorite, onFavoriteClick)
275         }
!!!                                                                 ^ error
276     }
277 }
278 

```

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:73:36
```
The function PlacesScreenContent(viewState: PlacesViewState, onToggleViewMode: () -> Unit, onSearchPlaces: (String) -> Unit, onShowPlaceDetails: (PlaceUiModel) -> Unit, onHidePlaceDetails: () -> Unit, onToggleFavorite: (PlaceUiModel) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
70 }
71 
72 @OptIn(ExperimentalMaterial3Api::class)
73 @Composable
!!                                    ^ error
74 private fun PlacesScreenContent(
75     viewState: PlacesViewState,
76     onToggleViewMode: () -> Unit,

```

### formatting, NoUnusedImports (1)

Detects unused imports

[Documentation](https://detekt.dev/docs/rules/formatting#nounusedimports)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:26:1
```
Unused import
```
```kotlin
23 import androidx.compose.material3.ExperimentalMaterial3Api
24 import androidx.compose.material3.Icon
25 import androidx.compose.material3.IconButton
26 import androidx.compose.material3.OutlinedTextField
!! ^ error
27 import androidx.compose.material3.Text
28 import androidx.compose.runtime.Composable
29 import androidx.compose.runtime.collectAsState

```

### style, MagicNumber (3)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:213:6
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
210     onFavoriteClick: (PlaceUiModel) -> Unit
211 ) {
212     if (!isListView || (isLandscape && places.size > 4)) {
213         // Grid layout for map view or landscape with many items
!!!      ^ error
214         LazyVerticalGrid(
215             columns = GridCells.Adaptive(minSize = 280.dp),
216             horizontalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding),

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewState.kt:14:32
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
11     val showPlaceDetails: Boolean = false,
12     val searchQuery: String = "",
13     val swCornerLat: Double = 39.079888,
14     val swCornerLng: Double = -84.540499,
!!                                ^ error
15     val neCornerLat: Double = 39.113254,
16     val neCornerLng: Double = -84.494260
17 ) {

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewState.kt:16:32
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
13     val swCornerLat: Double = 39.079888,
14     val swCornerLng: Double = -84.540499,
15     val neCornerLat: Double = 39.113254,
16     val neCornerLng: Double = -84.494260
!!                                ^ error
17 ) {
18     val displayPlaces: List<PlaceUiModel>
19         get() = if (searchQuery.isBlank()) places else filteredPlaces

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:52:28
```
Function parameter `navigator` is unused.
```
```kotlin
49 import com.vehiclecompanion.presentation.R
50 import com.vehiclecompanion.theme.Dimens
51 import com.vehiclecompanion.theme.Theme
52 
!!                            ^ error
53 @Composable
54 fun PlacesScreen(
55     navigator: AppNavigator,

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 14:15:08 UTC
