package Skipass;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Best on 02.12.2015.
 */
public class SkipassSeason extends Skipass {
    protected Date expirationDate;


    public SkipassSeason(int slopesOrDaysLeft, Date startTime, Date endTime, SkipassType skipassType) {
        super(slopesOrDaysLeft, startTime, endTime, skipassType);
    }

    @Override
    public boolean isValid() {
        Date currentDate = SkipassConstants.getDate();
        if(isSeasonPeriod(currentDate)
                && checkTime(this, currentDate)
                && !this.isLocked()
                && this.expirationDate.after(currentDate)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean processSlope(int liftID) {
        Date currentDay = SkipassConstants.getDate();
        Slope slope = new Slope(liftID, currentDay);
        if(this.slopesPassed.size() == 0){
            Calendar expDate = Calendar.getInstance();
            Date curDate = SkipassConstants.getDate();
            if(curDate.getMonth() < Calendar.MARCH){
                expDate.set(curDate.getYear(), Calendar.MARCH, 30);
                this.expirationDate = expDate.getTime();
            }else{
                expDate.set(curDate.getYear() + 1, Calendar.MARCH, 30);
                this.expirationDate = expDate.getTime();
            }
        }
        if (isSeasonPeriod(currentDay) ){
            this.slopesPassed.add(slope);
            slope.setLetBy(true);
        }else{
            slope.setLetBy(false);
        }
        return slope.isLetBy();
    }

    @Override
    public boolean haveSlopesOrDays() {

        return false ;
    }

    private boolean isSeasonPeriod(Date currentDate) {
        return currentDate.getMonth() == Calendar.NOVEMBER || currentDate.getMonth() == Calendar.FEBRUARY
                || currentDate.getMonth()==Calendar.DECEMBER || currentDate.getMonth()==Calendar.JANUARY;
    }

    private boolean checkTime(Skipass skipass, Date currentDate) {

        if(getTimeInSeconds(skipass.startTime) <= getTimeInSeconds(currentDate)
                && getTimeInSeconds(skipass.endTime) >= getTimeInSeconds(currentDate)){
            return true;
        }else{
            return false;
        }
    }
    private long getTimeInSeconds(Date date){
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR) * 60 * 60 + c.get(Calendar.MINUTE) * 60 + c.get(Calendar.SECOND);
    }
}

