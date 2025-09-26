plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

android {
    namespace = "com.vehiclecompanion.data"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "version"
    productFlavors {
        create("qa") {
            dimension = "version"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api2.roadtrippers.com/\""
            )
        }
        create("uat") {
            dimension = "version"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api2.roadtrippers.com/\""
            )
        }
        create("live") {
            dimension = "version"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api2.roadtrippers.com/\""
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.majorVersion
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))

    implementation(libs.bundles.data)

    ksp(libs.hilt.compiler)
    ksp(libs.androidx.room.compiler)
    
    //Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
    testImplementation(libs.robolectric)
    testImplementation(kotlin("test"))
    
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.runner)
}

room {
    schemaDirectory("$projectDir/schemas")
}