package com.ideas.robot;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RobotTest {
    private final WeightValidator WEIGHT_VALIDATOR = new WeightValidator(10.0f);
    private final DistanceValidator DISTANCE_VALIDATOR = new DistanceValidator(5.0f);
    private Battery battery =new Battery(100);

    @Test
    public void isRobotPresent(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        Assert.assertNotNull(robot);
    }

    @Test
    public void currentPercentageOfBatteryOfRobot(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksFor(0);
        assertEquals("100.0% remaining ", message);
    }

    @Test
    public void currentPercentageOfBatteryOfRobotAfterFiveKilometeres(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksFor(5);
        assertEquals("Battery Drained completely", message);
    }


    @Test
    public void currentPercentageOfBatteryOfRobotAfterThree_And_HalfKilometeres(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksFor(3.5f);
        assertEquals("30.0% remaining ", message);
    }

    @Test
    public void robotConsumesTwoPercentBatteryForEveryKGWeight(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message =robot.walksWithWeight(2, 0);
        assertEquals("96.0% remaining ", message);
    }

    @Test
    public void robotWalksFor2KMWith3KGWeight(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksWithWeight(3, 2);
        assertEquals("54.0% remaining ",message);
    }

    @Test
    public void robotWalksFor9KGWeight(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksWithWeight(9, 0);
        assertEquals("82.0% remaining ", message);
    }

    @Test
    public void robotShouldDisplayOverWeightMessage(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message =robot.walksWithWeight(10.1f, 0);
        assertEquals("Overweight", message);
    }

    @Test
    public void currentPercentageOfBatteryOfRobotAfterFourAndHalfKilometeres(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksFor(4.5f);
        assertEquals("10.0% remaining and lit up red light", message);
    }

    @Test
    public void batteryDrainedWithoutCompletingTask(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksWithWeight(9,4.5f);
        assertEquals("Battery Drained completely without accomplishing task", message);
    }

    @Test
    public void robotAcceptsMultipleCommands(){
        Robot robot = new Robot(WEIGHT_VALIDATOR,DISTANCE_VALIDATOR, battery);
        String message = robot.walksFor(4.5f);
        assertEquals("10.0% remaining and lit up red light", message);
    }



}
