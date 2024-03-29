// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.0-beta09")
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io" ) }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-alpha02")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.37")
    }
}

//allprojects {
//    repositories {
//        maven { url = uri("https://www.jitpack.io" ) }
//    }
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}


