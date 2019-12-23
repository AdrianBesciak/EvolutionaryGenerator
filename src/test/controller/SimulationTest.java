package simulation;


import org.junit.Test;


public class SimulationTest {

    @Test
    public void nextDay() {
        simulation.Simulation simulation = new simulation.Simulation();

        for (int i = 0; i < 8000; i++)
        {
            simulation.nextDay();
        }
    }

}
