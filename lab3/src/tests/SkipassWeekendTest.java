package tests;

import Skipass.Skipass;
import Skipass.SkipassConstants;
import Skipass.SkipassRegister;
import Skipass.SkipassType;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Calendar;

public class SkipassWeekendTest {

    @Test
    public void testIsValid() throws Exception {

    }

    @Test
    public void testProcessSlope() throws Exception {

        setWeekendDate(10, 3);
        Skipass weekend100Slopes = SkipassRegister.newSkipassWeekend(
                SkipassConstants.HUNDRED_SLOPES, SkipassConstants.MORNING, SkipassConstants.NIGHT, SkipassType.SLOPES_SKIPASS);
        for(int i=0; i < SkipassConstants.HUNDRED_SLOPES - 1; i++){
            weekend100Slopes.processSlope(7);
        }
        //for the 100 time
        Assert.assertTrue(weekend100Slopes.processSlope(7));
        // for 101 time
        Assert.assertFalse(weekend100Slopes.processSlope(7));
    }


    @Test
    public void testProcessSlopeWeekend() throws Exception {

        setWeekendDate(9, 3);
        Skipass weekend100Slopes = SkipassRegister.newSkipassWeekend(
                2, SkipassConstants.MORNING, SkipassConstants.NIGHT, SkipassType.TIME_SKIPASS);

        Assert.assertTrue(weekend100Slopes.processSlope(7));
        setWeekendDate(10, 4);
        Assert.assertTrue(weekend100Slopes.processSlope(7));
        setWeekendDate(11, 11);
        Assert.assertTrue(weekend100Slopes.processSlope(7));
    }


    @Test
    public void testProcessSlopeWeekendWrongTime() throws Exception {

        //testing first part of the day skipass using 16-00 time
        setWeekendDate(16, 3);
        Skipass weekend100Slopes = SkipassRegister.newSkipassWeekend(
                2, SkipassConstants.MORNING, SkipassConstants.AFTERNOON, SkipassType.TIME_SKIPASS);

        Assert.assertFalse(weekend100Slopes.processSlope(7));
    }

    private void setWeekendDate(int timeHours, int dayOfMonth) {
        Calendar weekEnd = Calendar.getInstance();
        weekEnd.set(2015, Calendar.JANUARY, dayOfMonth, timeHours, 0, 0);
        SkipassConstants.setDate(weekEnd.getTime());
    }

    private void setWorkingDate() {
        Calendar weekEnd = Calendar.getInstance();
        weekEnd.set(2015, Calendar.JANUARY, 1, 9, 0, 0);
        SkipassConstants.setDate(weekEnd.getTime());
    }

    @Test
    public void testHaveSlopesOrDaysLimitExcided() throws Exception {
        setWeekendDate(16, 3);
        Skipass weekend100Slopes = SkipassRegister.newSkipassWeekend(
                SkipassConstants.HUNDRED_SLOPES, SkipassConstants.MORNING, SkipassConstants.NIGHT, SkipassType.SLOPES_SKIPASS);
        for(int i=0; i < SkipassConstants.HUNDRED_SLOPES; i++){
            weekend100Slopes.processSlope(7);
        }
        // for 101 time
        Assert.assertFalse(weekend100Slopes.processSlope(7));

    }
}