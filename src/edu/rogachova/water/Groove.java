package edu.rogachova.water;

import edu.rogachova.description.WaterType;

import java.util.Objects;

public class Groove extends Hydrosphere
{
    private String name;
    private boolean isVisited;

    public Groove(){

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public boolean getIsVisited()
    {
        return isVisited;
    }

    public void setIfVisited(boolean is){
        this.isVisited = is;
    }

    @Override
    public void startToFlow()
    {
        setWaterType(WaterType.GROOVE);
        nWater *= 2;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Groove)) return false;
        if (!super.equals(o)) return false;
        Groove groove = (Groove) o;
        return Double.compare(groove.getnWater(), getnWater()) == 0 &&
                isVisited == groove.isVisited &&
                Objects.equals(getName(), groove.getName());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getnWater(), getName(), isVisited);
    }

    @Override
    public String toString()
    {
        return "Groove{" +
                "waterType=" + getWaterType() +
                ", nWater=" + nWater +
                ", name='" + name + '\'' +
                ", isVisited=" + isVisited +
                '}';
    }
}
