package test;

import org.testng.annotations.Test;
import pages.Bmw;
import pages.Car;

/**
 * Created by anbus on 4/6/2017.
 */
public class Test_Car {
    Car c1;
    Bmw bmw;

    @Test
    public void verifyCar() {
        c1 = new Car();
        bmw = new Bmw();
        bmw.printCar("blue");
        bmw.carColor();
        bmw.carName();

    }
}
