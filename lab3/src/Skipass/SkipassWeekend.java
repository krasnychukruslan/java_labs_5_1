package Skipass;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Best on 02.12.2015.
 */
public class SkipassWeekend extends Skipass {

    public SkipassWeekend(int slopesOrDaysLeft, Date startTime, Date endTime, SkipassType skipassType) {
        super(slopesOrDaysLeft, startTime, endTime, skipassType);
    }

    @Override
    public boolean isValid() {
        if(this.checkSkipass()){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean processSlope(int liftID) {
        Date currentDay = SkipassConstants.getDate();
        Slope slope = new Slope(liftID, currentDay);

        if (checkSkipass() ){
            this.slopesPassed.add(slope);
            slope.setLetBy(true);
        }else{
            slope.setLetBy(false);
        }
        return slope.isLetBy();
    }

    @Override
    public boolean haveSlopesOrDays(){
        if(this.skipassType == SkipassType.TIME_SKIPASS) {
            Set<Date> uniqDays = new HashSet();

            for (Slope slope : this.slopesPassed) {
                uniqDays.add(this.trimTime(slope.getDate()));
            }

            Date curDate = this.trimTime(SkipassConstants.getDate());

            return this.getSlopesOrDaysLeft() >= uniqDays.size();
        } else{
            return this.getSlopesOrDaysLeft() > this.slopesPassed.size();
        }
    }


    private boolean checkSkipass(){
        Date currentDate = SkipassConstants.getDate();
        if(isWeekend(currentDate)
                && checkTime(this, currentDate)
                && !this.isLocked()
                && this.haveSlopesOrDays()){
            return true;
        }else{
            return false;
        }
    }

    private boolean isWeekend(Date currentDate) {
        if(currentDate.getDay() + 1 == Calendar.SATURDAY || currentDate.getDay() + 1 == Calendar.SUNDAY){
            return true;
        }else{
            return false;
        }
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
        c.setTime(date); /* whatever*/
        long hours = c.get(Calendar.HOUR_OF_DAY) * 60 * 60;
        return  hours + c.get(Calendar.MINUTE) * 60 + c.get(Calendar.SECOND);
    }


}
