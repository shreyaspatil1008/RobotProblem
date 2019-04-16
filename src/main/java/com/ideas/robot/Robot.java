package com.ideas.robot;


public class Robot {
    private final WeightValidator weightValidator;
    private final DistanceValidator distanceValidator;
    private final Battery battery;


    public Robot(WeightValidator weightValidator, DistanceValidator distanceValidator, Battery battery) {
        this.weightValidator = weightValidator;
        this.distanceValidator = distanceValidator;
        this.battery = battery;
    }

    public String walksFor(float distanceWalked) {
        String message =null;
        try {
            if(distanceValidator.isValid(distanceWalked)){
                battery.consumeBattery(distanceWalked * 20);
                return battery.displayBatteryStatus();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }


    public String walksWithWeight(float weight, float distance) {
        String message;
        try {
            if(weightValidator.isValid(weight)) {
                battery.consumeBattery(weight * 2);
            }
            return walksFor(distance);
        } catch (Exception e) {
           message = e.getMessage();
        }

        return message;
    }
}
