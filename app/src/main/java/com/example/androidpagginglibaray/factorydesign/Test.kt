package com.example.androidpagginglibaray.factorydesign

/**
 * Created by Ajeena on 19-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
abstract class Test {
    var name : String = "Not Specified"
    // abstract variable
    abstract var medium : String
    // regular function
    fun runsWhere() {
        println("The vehicle, $name, runs on $medium")
    }
    // abstract function
    abstract fun howItRuns()
}