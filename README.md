Dependency :
//
Koltin Coroutines Dependency

implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1'
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1'

Add kotlinx-coroutines-android module as a dependency when using kotlinx.coroutines on Android:



dependencies {
        val lifecycle_version = "2.4.0-alpha02"
        val arch_version = "2.1.0"
        // ViewModel
        implementation'androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version'
        // LiveData
        implementation 'androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version'
       
       
       // Dagger_Hilt 
       
       plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
}

 ext.hilt_version = '2.35'
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-android-compiler:$hilt_version"
       
       
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"

