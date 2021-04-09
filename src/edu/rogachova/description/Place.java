package edu.rogachova.description;

import edu.rogachova.water.Hydrosphere;

public class Place
{
    private String name;
    private Boolean isFlooded;
    private WaterType waterType;

    public Place(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public WaterType getWaterType(){
        return waterType;
    }
    public void setWaterType(WaterType waterType){
        this.waterType = waterType;
    }

    public void checkAmountOfWater(){
        if (waterType == WaterType.FLOOD) {
            isFlooded = true;
        }
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return true;
        }

        if(otherObject == null){
            return false;
        }

        if(otherObject instanceof Place){
            Place place2 = (Place)otherObject;
            return this.name.equals(place2.name);
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Place{" +
                "name='" + name + '\'' +
                ", isFlooded=" + isFlooded +
                '}';
    }
}
