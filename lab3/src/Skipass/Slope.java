package Skipass;

import java.util.Date;

/**
 * Created by Best on 15.12.2015.
 */
public class Slope {
    private int lift;
    private Date date;
    private boolean letBy;

    public Slope(int lift, Date date) {
        this.lift = lift;
        this.date = date;
    }

    public boolean isLetBy() {
        return letBy;
    }

    public void setLetBy(boolean letBy) {
        this.letBy = letBy;
    }

    public int getLift() {
        return lift;
    }

    public void setLift(int lift) {
        this.lift = lift;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
