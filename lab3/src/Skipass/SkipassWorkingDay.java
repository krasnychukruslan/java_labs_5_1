package Skipass;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Best on 02.12.2015.
 */
public class SkipassWorkingDay extends Skipass {

    public SkipassWorkingDay(int slopesOrDays, Date startDate, Date endDate, SkipassType skipassType) {
        super(slopesOrDays, startDate, endDate, skipassType);
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

            boolean isValidDay = true;
            if (curDate.after(this.slopesPassed.get(this.slopesPassed.size() - 1).getDate())
                    && this.getSlopesOrDaysLeft() == uniqDays.size()) {
                isValidDay = false;
            }
            return this.getSlopesOrDaysLeft() >= uniqDays.size() && isValidDay;
        }else{
            return this.getSlopesOrDaysLeft() > this.slopesPassed.size();
        }
    }

    private boolean checkSkipass(){
        Date currentDate = SkipassConstants.getDate();
        if(isWorkingDay(currentDate)
                && checkTime(this, currentDate)
                && !this.isLocked()
                && this.haveSlopesOrDays()){
            return true;
        }else{
            return false;
        }
    }

    private boolean isWorkingDay(Date currentDate) {
        if(currentDate.getDay() == Calendar.SATURDAY || currentDate.getDay() == Calendar.SUNDAY){
            return false;
        }else{
            return true;
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
        return c.get(Calendar.HOUR_OF_DAY) * 60 * 60 + c.get(Calendar.MINUTE) * 60 + c.get(Calendar.SECOND);
    }
}
