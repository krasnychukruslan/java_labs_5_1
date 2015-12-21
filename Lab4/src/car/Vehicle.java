package car;

import human.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Best on 21.12.2015.
 */
public abstract class Vehicle<T extends Human> {
    public List<T> sits;
    public int maxSits;
    public T human;

    public Vehicle(int maxSits){
        this.maxSits = maxSits;
        this.sits = new ArrayList<T>();
    }

    public abstract int getMaxSits();

    public abstract int getTakenSits();

    public abstract void sitInto(T human) throws Exception;

    public abstract void getOut(T human) throws Exception;

}
