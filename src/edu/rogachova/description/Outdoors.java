package edu.rogachova.description;

import edu.rogachova.ability.ReasonToWorry;

import java.util.ArrayList;
import java.util.Objects;

public class Outdoors extends Place
{
    private String name;
    private Boolean isFlooded;
    private Danger danger;
    private ArrayList<WaterType> amountWater;

    public Outdoors(String name){
        super(name);
    }

    public void description(ArrayList<WaterType> waterTypes){
        System.out.print("Outside there were a lots of ");
        amountWater = waterTypes;
        for(WaterType type: waterTypes){
            System.out.print("\t" + type);
        }

    }

    @Override
    public void checkAmountOfWater(){
        if(amountWater.contains(WaterType.FLOOD)){
            isFlooded = true;
            danger.setDanger(ReasonToWorry.FLOOD);
        }
    }

    @Override
    public String toString()
    {
        return "Outdoors{" +
                "name='" + name + '\'' +
                ", isFlooded=" + isFlooded +
                ", danger=" + danger +
                ", amountWater=" + amountWater +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Outdoors)) return false;
        if (!super.equals(o)) return false;
        Outdoors outdoors = (Outdoors) o;
        return Objects.equals(name, outdoors.name) &&
                Objects.equals(isFlooded, outdoors.isFlooded) &&
                Objects.equals(danger, outdoors.danger) &&
                Objects.equals(amountWater, outdoors.amountWater);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(super.hashCode(), name, isFlooded, danger, amountWater);
    }
}
