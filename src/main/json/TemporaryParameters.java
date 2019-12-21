package json;

public class TemporaryParameters {
    private int width;
    private int height;
    private int startEnergy;
    private int moveEnergy;
    private int plantEnergy;
    private int jungleRatio;
    private int animalsOnStart;
    public void setWidth(int width){ this.width = width;}

    public void setHeight(int height){ this.height = height; }

    public void setStartEnergy(int startEnergy){ this.startEnergy = startEnergy; }

    public void setMoveEnergy(int moveEnergy){ this.moveEnergy = moveEnergy; }

    public void setPlantEnergy(int plantEnergy){ this.plantEnergy = plantEnergy; }

    public void setJungleRatio(int jungleRatio){ this.jungleRatio = jungleRatio; }

    public void setAnimalsOnStart(int animalsOnStart){ this.animalsOnStart = animalsOnStart; }


    public int getStartEnergy() {
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

    public int getPlantEnergy() {
        return plantEnergy;
    }

    public int getAnimalsOnStart()
    {
        return animalsOnStart;
    }

    public int getMoveEnergy() { return moveEnergy; }

}
