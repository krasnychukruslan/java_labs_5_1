package tests;

import car.PoliceCar;
import human.Policeman;
import org.junit.Test;

public class PoliceCarTest {

    @Test(expected = Exception.class)
    public void testSitInto() throws Exception {
        PoliceCar policeCar = new PoliceCar(2);
        policeCar.sitInto(new Policeman("Vasa"));
        policeCar.sitInto(new Policeman("Petro"));
        policeCar.sitInto(new Policeman("Ivan"));
    }

    @Test
    public void testGetOut() throws Exception {

    }
}