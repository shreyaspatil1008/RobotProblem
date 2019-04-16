package com.ideas.robot;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BatteryTest {

    @Test
    public void shouldShowBatteryCharged(){
        Battery battery =new Battery(100);
        String message = battery.displayBatteryStatus();

        assertEquals("100.0% remaining ",message);
    }

    @Test
    public void shouldShowRemainingPercentage(){
        Battery battery =new Battery(100);
        battery.consumeBattery(90);

        String message = battery.displayBatteryStatus();

        assertEquals("10.0% remaining and lit up red light",message);
    }

    @Test
    public void shouldShowBatteryDrained(){
        Battery battery =new Battery(100);
        battery.consumeBattery(100);

        String message = battery.displayBatteryStatus();

        assertEquals("Battery Drained completely",message);
    }

    @Test
    public void shouldShowErrorMessage(){
        Battery battery =new Battery(100);
        battery.consumeBattery(110);

        String message = battery.displayBatteryStatus();

        assertEquals("Battery Drained completely without accomplishing task",message);
    }


}
