package car;

import human.Human;

/**
 * Created by Best on 21.12.2015.
 */
public class Auto<T extends Human> extends Vehicle<T> {

    public Auto(int maxSits) {
        super(maxSits);
    }

    @Override
    public int getMaxSits() {
        return this.maxSits;
    }

    @Override
    public int getTakenSits() {
        return this.sits.size();
    }

    @Override
    public void sitInto(T human) throws Exception {
        if(this.sits.size() >= this.getMaxSits()){
            throw new Exception("Vehicle is crowded . Max sits: " + this.getMaxSits());
        }else{
            this.sits.add(human);
        }
    }

    @Override
    public void getOut(T human) throws Exception {
        if(!this.sits.remove(human)){
            throw new Exception("Passenger " + human.name + " is not sitting here.");
        }
    }
}
