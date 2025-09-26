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

* 381 logical lines of code (lloc)

* 5 comment lines of code (cloc)

* 41 cyclomatic complexity (mcc)

* 14 cognitive complexity

* 16 number of total code smells

* 0% comment source ratio

* 107 mcc per 1,000 lloc

* 41 code smells per 1,000 lloc

## Findings (16)

### complexity, LongMethod (2)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:99:13
```
The function GarageScreenContent is too long (88). The maximum length is 60.
```
```kotlin
96  
97  @OptIn(ExperimentalMaterial3Api::class)
98  @Composable
99  private fun GarageScreenContent(
!!              ^ error
100     viewState: GarageViewState,
101     onAddVehicleClick: () -> Unit,
102     onEditVehicleClick: (VehicleModel) -> Unit,

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:251:13
```
The function VehicleCard is too long (98). The maximum length is 60.
```
```kotlin
248 
249 @OptIn(ExperimentalMaterial3Api::class)
250 @Composable
251 private fun VehicleCard(
!!!             ^ error
252     vehicle: VehicleModel,
253     onEditClick: () -> Unit,
254     onDeleteClick: () -> Unit

```

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to control complex algorithms and violate the Single Responsibility Principle. Prefer functions with short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:99:32
```
The function GarageScreenContent(viewState: GarageViewState, onAddVehicleClick: () -> Unit, onEditVehicleClick: (VehicleModel) -> Unit, onDeleteVehicleClick: (VehicleModel) -> Unit, onHideAddDialog: () -> Unit, onHideEditDialog: () -> Unit, onSaveVehicle: () -> Unit, onNameChange: (String) -> Unit, onMakeChange: (String) -> Unit, onModelChange: (String) -> Unit, onYearChange: (String) -> Unit, onVinChange: (String) -> Unit, onFuelTypeChange: (String) -> Unit, onImageChange: (String) -> Unit) has too many parameters. The current threshold is set to 6.
```
```kotlin
96  
97  @OptIn(ExperimentalMaterial3Api::class)
98  @Composable
99  private fun GarageScreenContent(
!!                                 ^ error
100     viewState: GarageViewState,
101     onAddVehicleClick: () -> Unit,
102     onEditVehicleClick: (VehicleModel) -> Unit,

```

### formatting, NoTrailingSpaces (12)

Detects trailing spaces

[Documentation](https://detekt.dev/docs/rules/formatting#notrailingspaces)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:19:1
```
Trailing space(s)
```
```kotlin
16             }
17         }
18     }
19 
!! ^ error
20     data object HideAddVehicleDialog : GarageAction {
21         override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
22             previousData.update {

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:29:3
```
Trailing space(s)
```
```kotlin
26                 )
27             }
28         }
29     }
!!   ^ error
30 
31     data class ShowEditVehicleDialog(val vehicle: VehicleModel) : GarageAction {
32         override fun updateData(previousData: MutableStateFlow<GarageViewState>) {

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:40:9
```
Trailing space(s)
```
```kotlin
37                     vehicleForm = vehicle.toFormState()
38                 )
39             }
40         }
!!         ^ error
41     }
42 
43     data object HideEditVehicleDialog : GarageAction {

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:52:5
```
Trailing space(s)
```
```kotlin
49                     vehicleForm = VehicleFormState()
50                 )
51             }
52         }
!!     ^ error
53     }
54 
55     data class VehiclesLoaded(val vehicles: List<VehicleModel>) : GarageAction {

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:60:1
```
Trailing space(s)
```
```kotlin
57             previousData.update {
58                 it.copy(vehicles = vehicles)
59             }
60         }
!! ^ error
61     }
62 
63     data class DeleteVehicle(val vehicleId: Long) : GarageAction

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:64:50
```
Trailing space(s)
```
```kotlin
61     }
62 
63     data class DeleteVehicle(val vehicleId: Long) : GarageAction
64     data class SaveVehicle(val vehicle: VehicleModel) : GarageAction
!!                                                  ^ error
65 
66     data class UpdateVehicleName(val name: String) : GarageAction {
67         override fun updateData(previousData: MutableStateFlow<GarageViewState>) {

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:72:7
```
Trailing space(s)
```
```kotlin
69                 it.copy(
70                     vehicleForm = it.vehicleForm.copy(name = name)
71                 )
72             }
!!       ^ error
73         }
74     }
75 

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:82:3
```
Trailing space(s)
```
```kotlin
79                 it.copy(
80                     vehicleForm = it.vehicleForm.copy(make = make)
81                 )
82             }
!!   ^ error
83         }
84     }
85 

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:91:17
```
Trailing space(s)
```
```kotlin
88             previousData.update {
89                 it.copy(
90                     vehicleForm = it.vehicleForm.copy(model = model)
91                 )
!!                 ^ error
92             }
93         }
94     }

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:101:13
```
Trailing space(s)
```
```kotlin
98              previousData.update {
99                  it.copy(
100                     vehicleForm = it.vehicleForm.copy(year = year)
101                 )
!!!             ^ error
102             }
103         }
104     }

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:111:9
```
Trailing space(s)
```
```kotlin
108             previousData.update {
109                 it.copy(
110                     vehicleForm = it.vehicleForm.copy(vin = vin)
111                 )
!!!         ^ error
112             }
113         }
114     }

```

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageAction.kt:121:5
```
Trailing space(s)
```
```kotlin
118             previousData.update {
119                 it.copy(
120                     vehicleForm = it.vehicleForm.copy(fuelType = fuelType)
121                 )
!!!     ^ error
122             }
123         }
124     }

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* D:/PROJECTS/VehicleCompanion/features/garage/src/main/java/com/vehiclecompanion/feature/GarageScreen.kt:54:5
```
Function parameter `navigator` is unused.
```
```kotlin
51 
52 @Composable
53 fun GarageScreen(
54     navigator: AppNavigator,
!!     ^ error
55     viewModel: GarageViewModel = hiltViewModel()
56 ) {
57     val viewState by viewModel.viewState.collectAsState()

```

generated with [detekt version 1.23.7](https://detekt.dev/) on 2025-09-26 14:15:08 UTC
