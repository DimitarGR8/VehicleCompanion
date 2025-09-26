# Vehicle Companion

A modern Android application for managing vehicle profiles and discovering nearby places of interest. Built with Jetpack Compose, following clean architecture principles and modern Android development best practices.

## Features

- **Vehicle Management**: Add, edit, and manage vehicle profiles with details like make, model, year, VIN, fuel type, and photos
- **Places Discovery**: Find nearby points of interest (restaurants, gas stations, attractions) with ratings and reviews
- **Favorites**: Save and manage favorite places for easy access
- **Modern UI**: Beautiful, responsive interface built with Jetpack Compose and Material Design 3
- **Offline Support**: Local storage with Room database for vehicle data and favorite places

## Running the Application

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK API 26+ (Android 8.0) or higher
- Kotlin 2.0.20+
- Java 17

### Setup & Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/VehicleCompanion.git
   cd VehicleCompanion
   ```

2. **Open in Android Studio:**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory and select it

3. **Sync project:**
   - Android Studio will automatically prompt to sync Gradle files
   - Wait for the sync to complete

4. **Build and run:**
   - Connect an Android device or start an emulator
   - Click the "Run" button or use `Ctrl+R` (Windows/Linux) / `Cmd+R` (Mac)
   - Select your target device

### Build Variants

The app supports multiple build variants:
- **QA**: Development build with debug features
- **UAT**: User acceptance testing build
- **Live**: Production release build

### API Configuration

The app uses the Roadtrippers API for places discovery. The base URL is configured in the build variants:
- Base URL: `https://api2.roadtrippers.com/`

## Architecture & Design Choices

### Clean Architecture

The project follows **Clean Architecture** principles with clear separation of concerns:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Presentation  │────│    Domain       │────│      Data       │
│   (UI Layer)    │    │ (Business Logic)│    │  (Data Layer)   │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

### Module Structure

- **`:app`** - Main application module with navigation and dependency injection setup
- **`:core`** - Shared utilities, base classes, and common functionality
- **`:domain`** - Business logic, use cases, and domain models
- **`:data`** - Data sources, repositories, API clients, and database
- **`:presentation`** - Reusable UI components, themes, and composables
- **`:features`** - Feature-specific modules:
  - `:features:home` - Dashboard and main navigation
  - `:features:garage` - Vehicle management
  - `:features:places` - Places discovery
  - `:features:favorites` - Favorite places management

### Key Design Patterns

#### MVVM + MVI Hybrid
- **ViewModels** handle business logic and state management
- **Actions** represent user intents (MVI pattern)
- **ViewStates** represent UI state in a single data class
- **BaseViewModel** provides common functionality across features

```kotlin
// Example Action
sealed interface GarageAction : BaseAction<GarageViewState> {
    data object ShowAddVehicleDialog : GarageAction
    data class SaveVehicle(val vehicle: VehicleModel) : GarageAction
}

// Example ViewState
data class GarageViewState(
    val vehicles: List<VehicleModel> = emptyList(),
    val showAddVehicleDialog: Boolean = false,
    val vehicleForm: VehicleFormState = VehicleFormState()
)
```

#### Repository Pattern
- **Repositories** abstract data sources and provide clean APIs to the domain layer
- **Use Cases** encapsulate business logic and coordinate repository calls
- **Mappers** convert between data models and domain models

#### Dependency Injection
- **Hilt** for dependency injection across all modules
- **@HiltViewModel** for ViewModel injection
- **Module** classes for providing dependencies

### Technology Stack

#### Core Technologies
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern UI toolkit
- **Coroutines & Flow** - Asynchronous programming
- **Hilt** - Dependency injection

#### Architecture Components
- **ViewModel** - UI-related data holder
- **Room** - Local database
- **Navigation Compose** - Navigation between screens
- **StateFlow** - Reactive state management

#### Networking & Data
- **Retrofit** - REST API client
- **OkHttp** - HTTP client with logging
- **Gson** - JSON serialization
- **Coil** - Image loading

#### UI & Design
- **Material Design 3** - Design system
- **Custom Theme** - Consistent color palette and typography
- **Adaptive Layout** - Support for different screen sizes
- **Bottom Sheets** - Modern modal presentation

### State Management

The app uses a unidirectional data flow pattern:

1. **User Action** → UI triggers an action
2. **Action Processing** → ViewModel processes the action
3. **State Update** → ViewModel updates the ViewState
4. **UI Recomposition** → Compose UI reacts to state changes

```kotlin
// User clicks button
onClick = { viewModel.postAction(GarageAction.ShowAddVehicleDialog) }

// ViewModel processes action
override fun onActionReceived(viewAction: GarageAction) {
    when (viewAction) {
        is GarageAction.ShowAddVehicleDialog -> {
            // Update state through action's updateData method
        }
    }
}

// UI reacts to state change
val viewState by viewModel.viewState.collectAsState()
if (viewState.showAddVehicleDialog) {
    AddEditVehicleBottomSheet(...)
}
```

### Database Design

#### Vehicle Entity
```kotlin
@Entity(tableName = "vehicles")
data class VehicleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val make: String,
    val model: String,
    val year: Int,
    val vin: String?,
    val fuelType: String,
    val imageUri: String?
)
```

#### Favorite Places Entity
```kotlin
@Entity(tableName = "favorite_pois")
data class FavoritePoiEntity(
    @PrimaryKey val id: String,
    val name: String,
    val category: String,
    val latitude: Double,
    val longitude: Double,
    val imageUrl: String?,
    val rating: Double,
    val url: String
)
```

## How to Run Tests

### Unit Tests

Run unit tests for specific modules:

```bash
# All unit tests
./gradlew test

# Domain layer tests
./gradlew :domain:test

# Data layer tests  
./gradlew :data:test

# Specific test class
./gradlew :domain:testDebugUnitTest --tests="VehicleDataClassTest"
```

### Instrumented Tests

Run Android instrumented tests:

```bash
# All instrumented tests
./gradlew connectedAndroidTest

# Specific module
./gradlew :presentation:connectedAndroidTest

# Compose UI tests
./gradlew :presentation:connectedAndroidTest --tests="*ComposeTest"
```

### Test Structure

#### Unit Tests
- **VehicleDataClassTest** - Tests vehicle model creation and validation
- **PlaceServiceTest** - Tests API service with mock responses
- **UseCaseTests** - Tests business logic and data flow

#### UI Tests
- **VehicleCardComposeTest** - Tests vehicle card display and interactions
- **PlaceCardComposeTest** - Tests place card display and favorite states
- **ScreenNavigationTests** - Tests navigation between screens

#### Test Tools
- **JUnit 4** - Test framework
- **MockK** - Mocking library for Kotlin
- **Turbine** - Testing library for Flow
- **Compose Test APIs** - UI testing for Compose components
- **Robolectric** - Android unit testing framework

### Running Specific Tests

```bash
# Run tests with coverage
./gradlew testDebugUnitTestCoverage

# Run tests with reports
./gradlew test jacocoTestReport

# Run only failing tests
./gradlew test --rerun-tasks
```

## Error & Empty State Handling

### Comprehensive Error Handling

#### Network Errors
- **No Internet Connection**: Shows retry mechanism with clear messaging
- **API Failures**: Graceful degradation with local data fallback
- **Timeout Errors**: Automatic retry with exponential backoff

#### Data Validation
- **Form Validation**: Real-time validation for vehicle input fields
- **Required Fields**: Clear indication of mandatory fields
- **Input Constraints**: Year ranges, VIN format validation

#### Empty States

#### Garage Empty State
```kotlin
EmptyState(
    iconRes = R.drawable.ic_garage,
    title = stringResource(R.string.no_vehicles_yet),
    subtitle = stringResource(R.string.add_first_vehicle_description),
    actionText = stringResource(R.string.add_vehicle),
    onActionClick = { showAddVehicleDialog() }
)
```

#### Places Empty State
- **No Search Results**: Helpful suggestions for refining search
- **No Network**: Clear indication with retry options
- **Location Disabled**: Prompt to enable location services

#### Favorites Empty State
- **No Favorites**: Encourages exploration of places
- **Search No Results**: Suggests alternative search terms

### Error Recovery Mechanisms

#### Automatic Retry
- Failed API calls are automatically retried with exponential backoff
- Network connectivity changes trigger data refresh
- Background sync ensures data consistency

#### User-Initiated Recovery
- Pull-to-refresh on lists
- Manual retry buttons on error states
- Clear error messages with actionable steps

#### Offline Support
- Cached data displayed when offline
- Local database ensures core functionality
- Sync when connection restored

### Loading States

#### Skeleton Loading
- Shimmer effects for list items
- Placeholder content during data loading
- Progressive loading for large datasets

#### Progress Indicators
- Determinate progress for file uploads
- Indeterminate spinners for network calls
- Custom loading animations for brand consistency

## What I'd Build Next

### Immediate Enhancements (Next Sprint)

#### Enhanced Vehicle Management
- **Maintenance Records**: Track service history, oil changes, inspections
- **Fuel Tracking**: Log fuel purchases and calculate efficiency
- **Document Storage**: Store registration, insurance, and maintenance documents
- **Vehicle Sharing**: Share vehicle access with family members

#### Advanced Places Features
- **Route Planning**: Multi-stop trip planning with vehicle considerations
- **Fuel Station Finder**: Filter by fuel type, price, and amenities
- **EV Charging Stations**: For electric vehicles with real-time availability
- **Weather Integration**: Weather-aware recommendations

### Medium-term Features (Next Quarter)

#### Trip Management
- **Trip Planning**: Create and save multi-day trips
- **Expense Tracking**: Track trip costs (fuel, tolls, parking)
- **Photo Journal**: Attach photos and notes to trips
- **Trip Sharing**: Share itineraries with friends and family

#### Vehicle Analytics
- **Driving Analytics**: Fuel efficiency trends and insights
- **Cost Analysis**: Total cost of ownership calculations
- **Maintenance Predictions**: Predictive maintenance reminders
- **Carbon Footprint**: Environmental impact tracking

#### Social Features
- **User Reviews**: Rate and review places visited
- **Friend Network**: Connect with other users for recommendations
- **Group Trips**: Plan trips collaboratively
- **Achievement System**: Gamification for exploration

### Long-term Vision (6+ Months)

#### AI & Machine Learning
- **Smart Recommendations**: Personalized place suggestions based on history
- **Route Optimization**: AI-powered route planning considering traffic, weather, and preferences
- **Predictive Analytics**: Predict vehicle maintenance needs and optimal routes
- **Voice Assistant**: Hands-free interaction while driving

#### IoT Integration
- **Vehicle API Integration**: Direct connection to modern vehicles for real-time data
- **Smart Home Integration**: Sync with home automation systems
- **Wearable Support**: Smartwatch integration for quick access
- **Dash Cam Integration**: Integrate with dash cam footage and locations

#### Advanced Platform Features
- **Web Platform**: Full-featured web application
- **Offline Maps**: Comprehensive offline map support
- **Multi-language Support**: Internationalization for global users
- **Enterprise Features**: Fleet management for businesses

#### Technical Improvements
- **Real-time Sync**: Multi-device real-time synchronization
- **Advanced Caching**: Intelligent caching strategies for better performance
- **Modular Architecture**: Plugin-based architecture for extensibility
- **GraphQL Migration**: More efficient data fetching

### Infrastructure & Quality

#### Performance Optimization
- **App Startup Time**: Reduce cold start time by 50%
- **Memory Optimization**: Reduce memory footprint and eliminate leaks
- **Battery Optimization**: Minimize background battery usage
- **Network Efficiency**: Implement advanced caching and compression

#### Developer Experience
- **CI/CD Pipeline**: Automated testing, building, and deployment
- **Code Quality**: Enhanced static analysis and code coverage
- **Documentation**: Comprehensive developer documentation
- **Design System**: Complete design system with component library

#### User Experience
- **Accessibility**: Full WCAG compliance for all users
- **Dark Mode**: System-wide dark theme support
- **Customization**: User-configurable themes and layouts
- **Onboarding**: Interactive tutorial for new users

### Business Features

#### Monetization
- **Premium Features**: Advanced analytics and unlimited vehicles
- **Partner Integration**: Discounts at partner locations
- **Advertising**: Relevant, non-intrusive advertising
- **Data Insights**: Anonymized analytics for automotive industry

#### Community
- **User-Generated Content**: Reviews, photos, and recommendations
- **Local Guides**: Community-driven local expertise
- **Events**: Car shows, meetups, and automotive events
- **Forums**: Discussion boards for automotive enthusiasts

---

**Technologies & Libraries Used:**
- Kotlin, Jetpack Compose, Hilt, Room, Retrofit, Coroutines, Flow
- Material Design 3, Coil, Navigation Compose, DataStore
- JUnit, MockK, Turbine, Compose Testing APIs
