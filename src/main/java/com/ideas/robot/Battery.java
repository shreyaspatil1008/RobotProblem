package com.ideas.robot;


public class Battery {
    private static final String LIT_UP_RED_LIGHT = "lit up red light";
    private static final String AND = "and ";
    private static final String REMAINING = "% remaining ";
    private static final float LOW_BATTERY_WARNING_VALUE = 15.0f;
    private static final String BATTERY_DRAINED_COMPLETELY = "Battery Drained completely";
    private static final String BATTERY_DRAINED_COMPLETELY_WITHOUT_ACCOMPLISHING_TASK = "Battery Drained completely without accomplishing task";
    private float remainingBattery;

    public Battery(float remainingBattery) {
        this.remainingBattery = remainingBattery;
    }

    public String displayBatteryStatus() {
        if(remainingBattery == 0){
            return BATTERY_DRAINED_COMPLETELY;
        }

        if(remainingBattery < 0){
            return BATTERY_DRAINED_COMPLETELY_WITHOUT_ACCOMPLISHING_TASK;
        }

        if(remainingBattery < LOW_BATTERY_WARNING_VALUE) {
            return remainingBattery + REMAINING + AND + LIT_UP_RED_LIGHT;
        }
        return remainingBattery +REMAINING;
    }


    public void consumeBattery(float drainedPercentage) {
        remainingBattery -= drainedPercentage;
    }
}
