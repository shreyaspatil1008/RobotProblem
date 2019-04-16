package com.ideas.robot;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class DistanceValidatorTest {
    @Test
    public void canTravelFor2KM() throws Exception {
        Validator validator = new DistanceValidator(5.0f);

        boolean valid = validator.isValid(2);

        assertTrue(valid);
    }
    @Test(expected = Exception.class)
    public void shouldThrowAnExceptionWhenWeightCapacityIsExceeded() throws Exception {
        Validator validator = new DistanceValidator(5.0f);

        validator.isValid(12);
    }


}
