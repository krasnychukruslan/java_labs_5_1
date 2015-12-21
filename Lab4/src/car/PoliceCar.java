package car;

import human.Policeman;

/**
 * Created by Best on 21.12.2015.
 */
public class PoliceCar<P extends Policeman> extends Auto<P> {

    public PoliceCar(int maxSits) {
        super(maxSits);
    }

    @Override
    public void sitInto(P human) throws Exception {
        super.sitInto(human);
    }

    @Override
    public void getOut(P human) throws Exception {
        super.getOut(human);
    }
}
