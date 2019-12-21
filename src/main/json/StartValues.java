package json;

import com.google.gson.Gson;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StartValues {
    private static int width;
    private static int height;
    private static int startEnergy;
    private static int moveEnergy;
    private static int plantEnergy;
    private static int jungleRatio;
    private static int animalsOnStart;

    public StartValues()
    {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/parameters.json"));
            Gson gson = new Gson();
            TemporaryParameters parameters = new TemporaryParameters();
            parameters = gson.fromJson(reader, parameters.getClass());

            this.setWidth(parameters.getMapWidth());
            this.setHeight(parameters.getMapHeight());
            this.setStartEnergy(parameters.getStartEnergy());
            this.setMoveEnergy(parameters.getMoveEnergy());
            this.setPlantEnergy(parameters.getPlantEnergy());
            this.setJungleRatio(parameters.getJungleRelationToMap());
            this.setAnimalsOnStart(parameters.getAnimalsOnStart());


        }catch (FileNotFoundException ex)
        {
            System.out.println(ex + "brak podanego pliku w danej lokalizacji");
        }
    }

    public void setWidth(int width){ this.width = width;}

    public void setHeight(int height){ this.height = height; }

    public void setStartEnergy(int startEnergy){ this.startEnergy = startEnergy; }

    public void setMoveEnergy(int moveEnergy){ this.moveEnergy = moveEnergy; }

    public void setPlantEnergy(int plantEnergy){ this.plantEnergy = plantEnergy; }

    public void setJungleRatio(int jungleRatio){ this.jungleRatio = jungleRatio; }

    public void setAnimalsOnStart(int animalsOnStart){ this.animalsOnStart = animalsOnStart; }


    public static int getEnergyOnStart() {
        return startEnergy;
    }

    public int getMapWidth() {
        return width;
    }

    public int getMapHeight() {
        return height;
    }

    public int getJungleRelationToMap() {
        return jungleRatio;
    }

    public static int getEnergyOfTree() {
        return plantEnergy;
    }

    public static int getAnimalsOnStart()
    {
        return animalsOnStart;
    }

    public static int getDailyUsedEnergy() { return moveEnergy; }



}
