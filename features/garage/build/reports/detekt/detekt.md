# detekt

## Metrics

* 5 number of properties

* 22 number of functions

* 15 number of classes

* 1 number of packages

* 4 number of kt files

## Complexity Report

* 620 lines of code (loc)

* 563 source lines of code (sloc)

* 382 logical lines of code (lloc)

* 5 comment lines of code (cloc)

* 41 cyclomatic complexity (mcc)

* 14 cognitive complexity

* 4 number of total code smells

* 0% comment source ratio

* 107 mcc per 1,000 lloc

* 10 code smells per 1,000 lloc

## Findings (4)

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

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:250:14
```
The function VehicleCard is too long (99). The maximum length is 60.
```
```kotlin
247 
248 @OptIn(ExperimentalMaterial3Api::class)
249 @Composable
250 internal fun VehicleCard(
!!!              ^ error
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

### style, UnusedParameter (1)

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

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 15:23:27 UTC
