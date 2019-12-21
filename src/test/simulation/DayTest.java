package simulation;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class DayTest {

    @Test
    public void nextDay() {
        Day simulation = new Day();

        for (int i = 0; i < 1000; i++)
        {
            simulation.nextDay();
        }
    }

}
