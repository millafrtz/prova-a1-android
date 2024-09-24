plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
<<<<<<< HEAD
    namespace = "com.example.prova"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.prova"
        minSdk = 25
=======
    namespace = "com.example.prova1"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.prova1"
        minSdk = 24
>>>>>>> 42fbebde79d300b44536c8d59d44649e86daee5f
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
<<<<<<< HEAD
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
=======
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
>>>>>>> 42fbebde79d300b44536c8d59d44649e86daee5f
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
<<<<<<< HEAD

    implementation("androidx.navigation:navigation-compose:2.8.0")
    implementation("com.google.code.gson:gson:2.8.7")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
=======
    implementation("androidx.core:core-ktx:1.9.0") // Funcionalidades principais do Android
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") // Ciclo de vida
    implementation("androidx.activity:activity-compose:1.7.0") // Suporte para atividades com Compose
    implementation("androidx.compose.ui:ui:1.4.0") // Biblioteca principal do Compose
    implementation("androidx.compose.material3:material3:1.1.0") // Material Design 3
    implementation("androidx.navigation:navigation-compose:2.6.0") // Navegação no Compose
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0") // Ferramentas de visualização
}
>>>>>>> 42fbebde79d300b44536c8d59d44649e86daee5f
