package edu.rogachova.water;

import edu.rogachova.description.WaterType;

import java.util.Objects;

public class River extends Hydrosphere
{
    public River(double nWater){
        if (nWater != 0)
        {
            this.nWater = nWater;
        }
        else{
            this.nWater = 1;
        }

    }

    @Override
    public void startToFlow()
    {
        setWaterType(WaterType.RIVER);
        System.out.println("Ручьи превратились в реку");
        nWater *= 5;
        System.out.println("Река наполнилась водой");
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof River)) return false;
        if (!super.equals(o)) return false;
        River river = (River) o;
        return Double.compare(river.getnWater(), getnWater()) == 0 &&
                getWaterType() == river.getWaterType();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getWaterType(), getnWater());
    }

    @Override
    public String toString()
    {
        return "River{" +
                "waterType=" + getWaterType() +
                ", nWater=" + nWater +
                '}';
    }
}
