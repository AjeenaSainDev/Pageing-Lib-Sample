package com.example.androidpagginglibaray.factorydesign

/**
 * Created by Ajeena on 19-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class FactoryClass  {
    fun getRate(plan_type : String ):Plan{
        if(plan_type .equals("DOMESTICPLAN")){
            return DomesticPlan(40.0)
        }
        else if(plan_type .equals("Commercial")){
            return  CommercialPlan(50.0)
        }
        else if(plan_type.equals("Other")){
            return  OtherPlan(60.0)
        }
return OtherPlan(60.0)

    }
}