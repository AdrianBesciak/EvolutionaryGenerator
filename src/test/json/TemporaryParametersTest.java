package json;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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

public class TemporaryParametersTest {

    @Test
    public void TemporaryParameters() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/parameters.json"));
            Gson gson = new Gson();
            TemporaryParameters parameters = new TemporaryParameters();

            parameters = gson.fromJson(reader, parameters.getClass());

            Assert.assertEquals(100, parameters.getMapWidth());
            Assert.assertEquals(100, parameters.getMapHeight());
            Assert.assertEquals(40, parameters.getJungleRelationToMap());
            Assert.assertEquals(100, parameters.getStartEnergy());
            Assert.assertEquals(20, parameters.getAnimalsOnStart());
        }catch (FileNotFoundException ex)
        {
            System.out.println(ex + "brak podanego pliku w danej lokalizacji");
        }
    }
}
