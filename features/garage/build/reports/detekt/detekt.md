# detekt

## Metrics

* 6 number of properties

* 5 number of functions

* 14 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 439 lines of code (loc)

* 406 source lines of code (sloc)

* 293 logical lines of code (lloc)

* 5 comment lines of code (cloc)

* 19 cyclomatic complexity (mcc)

* 13 cognitive complexity

* 18 number of total code smells

* 1% comment source ratio

* 64 mcc per 1,000 lloc

* 61 code smells per 1,000 lloc

## Findings (18)

### complexity, LongMethod (2)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:98:13
```
The function GarageScreenContent is too long (88). The maximum length is 60.
```
```kotlin
95  
96  @OptIn(ExperimentalMaterial3Api::class)
97  @Composable
98  private fun GarageScreenContent(
!!              ^ error
99      viewState: GarageViewState,
100     onAddVehicleClick: () -> Unit,
101     onEditVehicleClick: (VehicleModel) -> Unit,

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:250:13
```
The function VehicleCard is too long (95). The maximum length is 60.
```
```kotlin
247 
248 @OptIn(ExperimentalMaterial3Api::class)
249 @Composable
250 private fun VehicleCard(
!!!             ^ error
251     vehicle: VehicleModel,
252     onEditClick: () -> Unit,
253     onDeleteClick: () -> Unit

```

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:98:32
```
The function GarageScreenContent(viewState: GarageViewState, onAddVehicleClick: () -> Unit, onEditVehicleClick: (VehicleModel) -> Unit, onDeleteVehicleClick: (VehicleModel) -> Unit, onHideAddDialog: () -> Unit, onHideEditDialog: () -> Unit, onSaveVehicle: () -> Unit, onNameChange: (String) -> Unit, onMakeChange: (String) -> Unit, onModelChange: (String) -> Unit, onYearChange: (String) -> Unit, onVinChange: (String) -> Unit, onFuelTypeChange: (String) -> Unit, onImageChange: (String) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
95  
96  @OptIn(ExperimentalMaterial3Api::class)
97  @Composable
98  private fun GarageScreenContent(
!!                                 ^ error
99      viewState: GarageViewState,
100     onAddVehicleClick: () -> Unit,
101     onEditVehicleClick: (VehicleModel) -> Unit,

```

### formatting, ArgumentListWrapping (3)

Reports incorrect argument list wrapping

[Documentation](https://detekt.dev/docs/rules/formatting#argumentlistwrapping)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:345:26
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
342             // Actions
343             Column {
344                 IconButton(onClick = onEditClick) {
345                     Icon(
!!!                          ^ error
346                         painterResource(R.drawable.ic_edit),
347                         contentDescription = stringResource(R.string.edit_vehicle)
348                     )

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:345:88
```
Argument should be on a separate line (unless all arguments can fit a single line)
```
```kotlin
342             // Actions
343             Column {
344                 IconButton(onClick = onEditClick) {
345                     Icon(
!!!                                                                                        ^ error
346                         painterResource(R.drawable.ic_edit),
347                         contentDescription = stringResource(R.string.edit_vehicle)
348                     )

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:347:30
```
Missing newline before ")"
```
```kotlin
344                 IconButton(onClick = onEditClick) {
345                     Icon(
346                         painterResource(R.drawable.ic_edit),
347                         contentDescription = stringResource(R.string.edit_vehicle)
!!!                              ^ error
348                     )
349                 }
350                 IconButton(onClick = onDeleteClick) {

```

### formatting, FinalNewline (4)

Detects missing final newlines

[Documentation](https://detekt.dev/docs/rules/formatting#finalnewline)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:1:1
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

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:1:1
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

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewModel.kt:1:1
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

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewState.kt:1:1
```
File must end with a newline (\n)
```
```kotlin
1 package com.vehiclecompanion.feature
! ^ error
2 
3 import com.vehiclecompanion.model.VehicleModel
4 

```

### formatting, ImportOrdering (1)

Detects imports in non default order

[Documentation](https://detekt.dev/docs/rules/formatting#importordering)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:3:1
```
Imports must be ordered in lexicographic order without any empty lines in-between with "java", "javax", "kotlin" and aliases in the end
```
```kotlin
1 package com.vehiclecompanion.feature
2 
3 import androidx.compose.foundation.layout.Arrangement
! ^ error
4 import androidx.compose.foundation.layout.Box
5 import androidx.compose.foundation.layout.Column
6 import androidx.compose.foundation.layout.PaddingValues

```

### formatting, Indentation (4)

Reports mis-indented code

[Documentation](https://detekt.dev/docs/rules/formatting#indentation)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewState.kt:24:1
```
Unexpected indentation (16) (should be 12)
```
```kotlin
21 ) {
22     val isValid: Boolean
23         get() = name.isNotBlank() &&
24             make.isNotBlank() &&
!! ^ error
25             model.isNotBlank() &&
26             year.isNotBlank() &&
27             fuelType.isNotBlank()

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewState.kt:24:34
```
Unexpected indentation (16) (should be 12)
```
```kotlin
21 ) {
22     val isValid: Boolean
23         get() = name.isNotBlank() &&
24             make.isNotBlank() &&
!!                                  ^ error
25             model.isNotBlank() &&
26             year.isNotBlank() &&
27             fuelType.isNotBlank()

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewState.kt:25:31
```
Unexpected indentation (16) (should be 12)
```
```kotlin
22     val isValid: Boolean
23         get() = name.isNotBlank() &&
24             make.isNotBlank() &&
25             model.isNotBlank() &&
!!                               ^ error
26             year.isNotBlank() &&
27             fuelType.isNotBlank()
28 

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewState.kt:26:26
```
Unexpected indentation (16) (should be 12)
```
```kotlin
23         get() = name.isNotBlank() &&
24             make.isNotBlank() &&
25             model.isNotBlank() &&
26             year.isNotBlank() &&
!!                          ^ error
27             fuelType.isNotBlank()
28 
29     fun toVehicleModel(id: Long = 0): VehicleModel {

```

### formatting, NoTrailingSpaces (1)

Detects trailing spaces

[Documentation](https://detekt.dev/docs/rules/formatting#notrailingspaces)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageViewModel.kt:13:1
```
Trailing space(s)
```
```kotlin
10 class GarageViewModel @Inject constructor(
11     override var eventBus: IEventBus
12 ) : BaseViewModel<GarageAction, GarageViewState>() {
13 
!! ^ error
14     override var _viewState = MutableStateFlow(GarageViewState())
15 }
16 

```

### style, UnusedParameter (2)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:53:5
```
Function parameter `navigator` is unused.
```
```kotlin
50 
51 @Composable
52 fun GarageScreen(
53     navigator: AppNavigator,
!!     ^ error
54     viewModel: GarageViewModel = hiltViewModel()
55 ) {
56     val viewState by viewModel.viewState.collectAsState()

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:104:5
```
Function parameter `onHideEditDialog` is unused.
```
```kotlin
101     onEditVehicleClick: (VehicleModel) -> Unit,
102     onDeleteVehicleClick: (VehicleModel) -> Unit,
103     onHideAddDialog: () -> Unit,
104     onHideEditDialog: () -> Unit,
!!!     ^ error
105     onSaveVehicle: () -> Unit,
106     onNameChange: (String) -> Unit,
107     onMakeChange: (String) -> Unit,

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 11:27:44 UTC
