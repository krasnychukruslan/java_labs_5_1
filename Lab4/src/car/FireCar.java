package car;

import human.Fireman;

/**
 * Created by Best on 21.12.2015.
 */
public class FireCar<F extends Fireman> extends Auto<F> {
    public FireCar(int maxSits) {
        super(maxSits);
    }

    @Override
    public void sitInto(F human) throws Exception {
        super.sitInto(human);
    }

    @Override
    public void getOut(F human) throws Exception {
        super.getOut(human);
    }
}
