package com.ideas.robot;


public class DistanceValidator implements Validator {
    private final float maxDistance;

    public DistanceValidator(float maxDistance) {
        this.maxDistance = maxDistance;
    }

    public boolean isValid(float distance) throws Exception {
        if(distance > maxDistance){
            throw new Exception("Cannot Travel more than "+maxDistance);
        }
        return true;
    }
}
