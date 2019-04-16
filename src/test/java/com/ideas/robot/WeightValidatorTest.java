package com.ideas.robot;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class WeightValidatorTest {

    @Test
    public void canPickUpWeightOf2KG() throws Exception {
        Validator validator = new WeightValidator(10.0f);

        boolean valid = validator.isValid(2);

        assertTrue(valid);
    }

    @Test(expected = Exception.class)
    public void shouldThrowAnExceptionWhenWeightCapacityIsExceeded() throws Exception {
        Validator validator = new WeightValidator(10.0f);

        validator.isValid(12);
    }
}
