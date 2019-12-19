package com.example.androidpagginglibaray.factorydesign

/**
 * Created by Ajeena on 19-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class DomesticPlan(override var rate: Double) : Plan() {

    override fun getRateValue(): Double {
        rate = 140.0
        return rate    }


}