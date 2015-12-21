package car;

import human.Human;

import java.util.List;

/**
 * Created by Best on 21.12.2015.
 */
public class Taxi<T extends Human> extends Auto<T> {
    public Taxi(int maxSits) {
        super(maxSits);
    }

    @Override
    public void sitInto(T human) throws Exception {
        super.sitInto(human);
    }

    public void sitInto(List<T> human) throws Exception {
        for(T per: human){
            super.sitInto(per);
        }
    }

    @Override
    public void getOut(T human) throws Exception {
        super.getOut(human);
    }
}
