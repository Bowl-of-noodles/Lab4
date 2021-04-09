package edu.rogachova.water;

import edu.rogachova.ability.Flowable;
import edu.rogachova.description.Danger;
import edu.rogachova.description.WaterType;

import java.util.Objects;

public class Hydrosphere implements Flowable
{
    protected double nWater;
    private WaterType waterType;
    private Danger danger;

    public Hydrosphere()
    {

    }

    public double getnWater()
    {
        return nWater;
    }

    public void setnWater(double nWater)
    {
        this.nWater = nWater;
    }

    public WaterType getWaterType()
    {
        return waterType;
    }

    public void setWaterType(WaterType waterType)
    {
        this.waterType = waterType;
    }


    @Override
    public void startToFlow()
    {
        System.out.println("Воды стало больше");
    }

    @Override
    public String toString()
    {
        return "Hydrosphere{" +
                "waterType=" + waterType +
                ", danger=" + danger +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Hydrosphere)) return false;
        Hydrosphere that = (Hydrosphere) o;
        return waterType == that.waterType &&
                Objects.equals(danger, that.danger);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(waterType, danger);
    }
}
