package edu.rogachova.water;

import edu.rogachova.description.Danger;
import edu.rogachova.description.WaterType;
import edu.rogachova.entities.Piglet;

import java.util.Objects;

public class Flood
{
    private Danger danger;
    public Flood(){

    }

    public void startFlood(Danger danger, Piglet piglet){
        this.danger = danger;
        System.out.println("Снаружи началось наводнение");
        piglet.getHome().setDanger(danger);
        piglet.getHome().setWaterType(WaterType.FLOOD);
        piglet.startToWorry();


    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Flood)) return false;
        Flood flood = (Flood) o;
        return Objects.equals(danger, flood.danger);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(danger);
    }

    @Override
    public String toString()
    {
        return "Flood{" +
                "danger=" + danger +
                '}';
    }
}
