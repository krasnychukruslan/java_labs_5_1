package tests;

import Skipass.Skipass;
import Skipass.SkipassConstants;
import Skipass.SkipassRegister;
import Skipass.SkipassType;
import junit.framework.Assert;
import org.junit.Test;

public class SkipassRegisterTest {

    @Test
    public void testNewSkipassWeekend() throws Exception {
        Skipass weekend2Days = SkipassRegister.newSkipassWeekend(2, SkipassConstants.MORNING, SkipassConstants.AFTERNOON, SkipassType.TIME_SKIPASS);
        Assert.assertEquals(2, weekend2Days.getSlopesOrDaysLeft());
        Skipass weekend100Slopes = SkipassRegister.newSkipassWeekend(100, SkipassConstants.MORNING, SkipassConstants.NIGHT, SkipassType.SLOPES_SKIPASS);
        Assert.assertEquals(100, weekend100Slopes.getSlopesOrDaysLeft());
    }

    @Test
    public void testNewSkipassWorkingDay() throws Exception {

    }

    @Test
    public void testNewSkipassSeason() throws Exception {

    }
}