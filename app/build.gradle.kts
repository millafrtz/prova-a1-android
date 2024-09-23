plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.prova1"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.prova1"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0") // Funcionalidades principais do Android
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") // Ciclo de vida
    implementation("androidx.activity:activity-compose:1.7.0") // Suporte para atividades com Compose
    implementation("androidx.compose.ui:ui:1.4.0") // Biblioteca principal do Compose
    implementation("androidx.compose.material3:material3:1.1.0") // Material Design 3
    implementation("androidx.navigation:navigation-compose:2.6.0") // Navegação no Compose
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0") // Ferramentas de visualização
}
