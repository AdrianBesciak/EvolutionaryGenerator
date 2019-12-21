package json;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/*  json content for tests
{
    "width": 100,
    "height": 100,
    "startEnergy": 100,
    "moveEnergy": 10,
    "plantEnergy": 20,
    "jungleRatio": 40,
    "animalsOnStart": 20
}
*/


public class StartValuesTest {


    @Test
    public void loadStartValues() {
        StartValues testIt = new StartValues();
        Assert.assertEquals(100, testIt.getMapWidth());
        Assert.assertEquals(100, testIt.getMapHeight());
        Assert.assertEquals(40, testIt.getJungleRelationToMap());
        Assert.assertEquals(100, testIt.getEnergyOnStart());
        Assert.assertEquals(20, testIt.getAnimalsOnStart());

    }
}
