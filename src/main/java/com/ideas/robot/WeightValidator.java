package com.ideas.robot;


public class WeightValidator implements Validator {
    private static final String OVERWEIGHT_MESSAGE = "Overweight";
    private final float maxWeight;

    public WeightValidator(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean isValid(float weight) throws Exception {
        if(weight>maxWeight){
            throw new Exception(OVERWEIGHT_MESSAGE);
        }
        return true;
    }
}
