package edu.rogachova.water;

import edu.rogachova.ability.ReasonToWorry;
import edu.rogachova.description.Danger;
import edu.rogachova.description.Place;
import edu.rogachova.description.WaterType;
import edu.rogachova.entities.Piglet;
import edu.rogachova.exceptions.WaterLevelOutOfRangeError;

import java.util.Objects;

public class WaterLevel
{
    private int highLevel;

    public WaterLevel(int highLevel)
    {
        if (highLevel != 0)
        {
            this.highLevel = highLevel;
        } else
        {
            throw new WaterLevelOutOfRangeError();
        }

    }

    public boolean changeWaterAmount(Piglet piglet, Groove[] grooves){
        System.out.println("\nУровень воды стал повышаться");
        boolean beginingOfFlood = false;
        Danger danger = new Danger();
        danger.setDanger(ReasonToWorry.FLOOD);
        for(Groove groove:grooves)
        {
            groove.startToFlow();
        }
        System.out.println(grooves.length + " канавки/ок наполнились водой");
        Stream stream = new Stream(grooves[0].getnWater());
        stream.startToFlow();
        River river = new River(stream.getnWater());
        river.startToFlow();
        piglet.getHome().setnWater(river.getnWater());
        if(river.getnWater()>=highLevel){
            System.out.println("Река вышла из своих берегов");
            beginingOfFlood = true;
        }
        else{
            piglet.getHome().setDanger(danger);
            piglet.getHome().setWaterType(WaterType.RIVER);
            piglet.startToWorry();
            System.out.println("Воды еще было недостаточно для наводнения");
        }
        return beginingOfFlood;
    }

    public String changeWaterLavel(double nWater, String amount){
        if(nWater >= highLevel){
            return "Вода поднялась " + amount;
        }
        else{
            return "Вода опустилась " + amount;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof WaterLevel)) return false;
        WaterLevel that = (WaterLevel) o;
        return highLevel == that.highLevel;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(highLevel);
    }

    @Override
    public String toString()
    {
        return "WaterLevel{" +
                "highLevel=" + highLevel +
                '}';
    }
}
