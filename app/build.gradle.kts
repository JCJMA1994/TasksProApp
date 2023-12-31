plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // dagger hilt
    id("dagger.hilt.android.plugin")

    // ksp
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.systemfailed.taskspro"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.systemfailed.taskspro"
        minSdk = 30
        targetSdk = 34
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //-- firebase
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("com.google.firebase:firebase-firestore:24.10.0")

    //-- icon extended
    implementation("androidx.compose.material:material-icons-extended:1.5.4")

    //-- navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")

    //-- livecycle and livedata
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")

    //-- retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //-- room
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    //-- dagger hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    ksp("com.google.dagger:hilt-android-compiler:2.48.1")

    //-- windows size
    implementation("androidx.compose.material3:material3-window-size-class")

    //-- onBoarding
    implementation("com.google.accompanist:accompanist-pager:0.15.0")

    //-- lottie
    implementation("com.airbnb.android:lottie-compose:5.2.0")

    //-- dataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //-- swipe
    implementation("me.saket.swipe:swipe:1.1.1")
}