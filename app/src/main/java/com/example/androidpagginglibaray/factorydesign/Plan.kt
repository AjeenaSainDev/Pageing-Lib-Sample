package com.example.androidpagginglibaray.factorydesign

/**
 * Created by Ajeena on 19-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
abstract class Plan {
    abstract  var  rate : Double
    open var test : Double = 0.0
    abstract fun getRateValue() : Double
    fun calculateBill(units: Int) {
        System.out.println("units"+units * rate )
        System.out.println("test"+ test)
    }

     /* var  rate : Double = 0.0
    abstract fun getRate() : Double

    }*/
}