# detekt

## Metrics

* 14 number of properties

* 17 number of functions

* 7 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 658 lines of code (loc)

* 595 source lines of code (sloc)

* 414 logical lines of code (lloc)

* 7 comment lines of code (cloc)

* 48 cyclomatic complexity (mcc)

* 68 cognitive complexity

* 9 number of total code smells

* 1% comment source ratio

* 115 mcc per 1,000 lloc

* 21 code smells per 1,000 lloc

## Findings (9)

### complexity, LongMethod (2)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:74:13
```
The function PlacesScreenContent is too long (111). The maximum length is 60.
```
```kotlin
71 
72 @OptIn(ExperimentalMaterial3Api::class)
73 @Composable
74 private fun PlacesScreenContent(
!!             ^ error
75     viewState: PlacesViewState,
76     onToggleViewMode: () -> Unit,
77     onSearchPlaces: (String) -> Unit,

```

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:280:13
```
The function GridPlaceCardContent is too long (64). The maximum length is 60.
```
```kotlin
277 }
278 
279 @Composable
280 private fun GridPlaceCardContent(
!!!             ^ error
281     place: PlaceUiModel,
282     isFavorite: Boolean,
283     onFavoriteClick: () -> Unit

```

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:74:32
```
The function PlacesScreenContent(viewState: PlacesViewState, onToggleViewMode: () -> Unit, onSearchPlaces: (String) -> Unit, onShowPlaceDetails: (PlaceUiModel) -> Unit, onHidePlaceDetails: () -> Unit, onToggleFavorite: (PlaceUiModel) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
71 
72 @OptIn(ExperimentalMaterial3Api::class)
73 @Composable
74 private fun PlacesScreenContent(
!!                                ^ error
75     viewState: PlacesViewState,
76     onToggleViewMode: () -> Unit,
77     onSearchPlaces: (String) -> Unit,

```

### formatting, Indentation (1)

Reports mis-indented code

[Documentation](https://detekt.dev/docs/rules/formatting#indentation)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesAction.kt:70:1
```
Unexpected indentation (32) (should be 28)
```
```kotlin
67                 } else {
68                     currentState.places.filter { place ->
69                         place.name.contains(query, ignoreCase = true) ||
70                             place.category.contains(query, ignoreCase = true)
!! ^ error
71                     }
72                 }
73 

```

### formatting, NoConsecutiveBlankLines (1)

Reports consecutive blank lines

[Documentation](https://detekt.dev/docs/rules/formatting#noconsecutiveblanklines)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesViewModel.kt:28:1
```
Needless blank line(s)
```
```kotlin
25 ) : BaseViewModel<PlacesAction, PlacesViewState>() {
26     override var _viewState = MutableStateFlow(PlacesViewState())
27 
28     init {
!! ^ error
29         loadPlaces()
30         observeFavoriteChanges()
31     }

```

### style, MagicNumber (3)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:212:54
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
209     onPlaceClick: (PlaceUiModel) -> Unit,
210     onFavoriteClick: (PlaceUiModel) -> Unit
211 ) {
212     if (!isListView || (isLandscape && places.size > 4)) {
!!!                                                      ^ error
213         // Grid layout for map view or landscape with many items
214         LazyVerticalGrid(
215             columns = GridCells.Adaptive(minSize = 280.dp),

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

* D:/PROJECTS/VehicleCompanion/features/places/src/main/java/com/vehiclecompanion/feature/PlacesScreen.kt:55:5
```
Function parameter `navigator` is unused.
```
```kotlin
52 
53 @Composable
54 fun PlacesScreen(
55     navigator: AppNavigator,
!!     ^ error
56     viewModel: PlacesViewModel = hiltViewModel()
57 ) {
58     val viewState by viewModel.viewState.collectAsState()

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 13:40:12 UTC
