package json;

public class StartValues {
    private int energyOnStart = 100;
    private int mapWidth = 100;
    private int mapHeight = 100;
    private int jungleRelationToMap = 40;
    private static int energyOfTree = 20;
    private static int animalsOnStart = 4;

    public int getEnergyOnStart() {
        return energyOnStart;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getJungleRelationToMap() {
        return jungleRelationToMap;
    }

    public static int getEnergyOfTree() {
        return energyOfTree;
    }

    public static int getAnimalsOnStart()
    {
        return animalsOnStart;
    }
}
