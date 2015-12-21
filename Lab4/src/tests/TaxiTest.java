package tests;

import car.Taxi;
import human.Fireman;
import human.Human;
import human.Policeman;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaxiTest {

    @Test
    public void testSitInto() throws Exception {

    }

    @Test(expected = Exception.class)
    public void testGetOut() throws Exception {
        Taxi taxi = new Taxi(4);
        List list = new ArrayList<Human>();
        Policeman policeman = new Policeman("Gorge");
        Fireman fireman = new Fireman("Inokentiy");
        Human human = new Human("Vasa");
        list.add(policeman);
        list.add(fireman);
        list.add(human);

        taxi.sitInto(list);
        taxi.getOut(human);
        taxi.getOut(human);

    }
}