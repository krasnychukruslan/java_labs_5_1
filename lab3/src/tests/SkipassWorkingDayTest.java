package tests;

import Skipass.*;
import junit.framework.Assert;
import org.junit.Test;

public class SkipassWorkingDayTest {

    @Test
    public void testIsValid() throws Exception {

    }

    @Test
    public void testProcessSlope() throws Exception {
        Skipass workingDay100Slopes = SkipassRegister.newSkipassWorkingDay(SkipassConstants.HUNDRED_SLOPES, SkipassConstants.MORNING, SkipassConstants.NIGHT, SkipassType.SLOPES_SKIPASS);
        for(int i=0; i < SkipassConstants.HUNDRED_SLOPES - 1; i++){
            workingDay100Slopes.processSlope(7);
        }
        Assert.assertTrue(workingDay100Slopes.processSlope(7));
        Assert.assertFalse(workingDay100Slopes.processSlope(7));
    }

    @Test
    public void testHaveSlopesOrDays() throws Exception {

    }
}