package Skipass;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Best on 06.12.2015.
 */
public final class SkipassConstants {
    private static final Calendar morning;
    private static final Calendar afternoon;
    private static final Calendar evening;
    private static final Calendar night;

    static{
        morning = Calendar.getInstance();
        morning.set(2015, Calendar.JANUARY, 1, 8, 0, 0);
        afternoon = Calendar.getInstance();
        afternoon.set(2015, Calendar.JANUARY, 1, 13, 0, 0);
        evening = Calendar.getInstance();
        evening.set(2015, Calendar.JANUARY, 1, 17, 0, 0);
        night = Calendar.getInstance();
        night.set(2015, Calendar.JANUARY, 1, 22, 0, 0);
    }
    public final static Date MORNING = morning.getTime();
    public static final Date AFTERNOON = afternoon.getTime();
    public static final Date EVENING = evening.getTime();
    public static final Date NIGHT = night.getTime();

    public static final int TEN_SLOPES = 10;
    public static final int TWENTY_SLOPES = 20;
    public static final int FIFTY_SLOPES = 50;
    public static final int HUNDRED_SLOPES = 100;

    public static Date date;

    public static Date getDate(){
        if(date != null){
            return date;
        }else{
            return new Date();
        }
    }

    public static void setDate(Date date) {
        SkipassConstants.date = date;
    }
}

