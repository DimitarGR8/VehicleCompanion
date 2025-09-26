plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.compose.compiler)
}

android {
    defaultConfig {
        compileSdk = libs.versions.compile.sdk.get().toInt()
        applicationId = "com.android.vehiclecompanion"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
        namespace = "com.android.vehiclecompanion"
        multiDexEnabled = true
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
                "\"https://example.com/api/\""
            )
            buildConfigField(
                "String",
                "SERVER_PATH",
                "\"/nanit\""
            )
        }
        create("uat") {
            dimension = "version"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://example.com/api/\""
            )
            buildConfigField(
                "String",
                "SERVER_PATH",
                "\"/nanit\""
            )
        }
        create("live") {
            dimension = "version"
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://example.com/api/\""
            )
            buildConfigField(
                "String",
                "SERVER_PATH",
                "\"/nanit\""
            )
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
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
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(libs.bundles.app)
    ksp(libs.hilt.compiler)
}