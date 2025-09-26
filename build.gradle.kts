import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.room) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kover) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.detekt) apply true
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.8")
    }
    detekt {
        buildUponDefaultConfig = true // preconfigure defaults
        allRules = false // activate all available (even unstable) rules.
        config.setFrom(
            "$rootDir/config/detekt/detekt.yml"
        ) // point to your custom config defining rules to run, overwriting default behavior
        baseline =
            file("$projectDir/config/baseline.xml") // a way of suppressing issues before introducing detekt
        autoCorrect = true
    }
    tasks.withType<DetektCreateBaselineTask>().configureEach {
        jvmTarget = JavaVersion.VERSION_17.majorVersion
    }
    tasks.withType<Detekt>().configureEach {
        jvmTarget = JavaVersion.VERSION_17.majorVersion
        reports {
            // observe findings in your browser with structure and code snippets
            html.required.set(true)
            // checkstyle like format mainly for integrations like Jenkins
            xml.required.set(true)
            // similar to the console output, contains issue signature to manually edit baseline files
            txt.required.set(true)
            // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with GitHub Code Scanning
            sarif.required.set(true)
            // simple Markdown format
            md.required.set(true)
        }
    }
}