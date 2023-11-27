plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"
}

android {
    namespace = "com.dunglv.foodapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dunglv.foodapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        enable = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
buildscript {
    dependencies {
        classpath ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    //dots-indicator
    implementation("com.tbuonomo:dotsindicator:4.3")
    //add circleimageview
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    //add nav
    implementation("androidx.navigation:navigation-fragment-ktx:$2.4.0")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.1.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.1.0")
    //timber
    implementation ("com.jakewharton.timber:timber:5.0.1")
    //botton nav
//    implementation ("com.gauravk.bubblenavigation:bubblenavigation:1.0.7")

    implementation ("com.google.android.gms:play-services-maps:18.2.0")
    implementation("androidx.navigation:navigation-ui-ktx:$2.4.0")
    implementation("com.google.android.material:material:1.10.0")
    implementation ("com.github.bumptech.glide:glide:4.13.0")
//location
    implementation ("com.google.android.gms:play-services-location:18.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}