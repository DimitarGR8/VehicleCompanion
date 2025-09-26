plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
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

    implementation(libs.bundles.data)

    ksp(libs.hilt.compiler)
}