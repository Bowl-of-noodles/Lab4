package edu.rogachova.description;

import edu.rogachova.ability.ReasonToWorry;
import edu.rogachova.entities.Character;

import java.util.Objects;

public class Home extends Place
{
    private Character owner;
    private WaterType waterType;
    private Danger danger;
    private double nWater;

    public Home(String name)
    {
        super(name);
    }


    public void setOwner(Character owner)
    {
        this.owner = owner;
    }


    public Character getOwner()
    {
        return owner;
    }

    public ReasonToWorry getDangerDescription()
    {
        return danger.getDanger();
    }

    public void setDanger(Danger danger)
    {
        this.danger = danger;
    }

    public  void setWaterType(WaterType waterType){
        this.waterType = waterType;
    }

    public double getnWater()
    {
        return nWater;
    }

    public void setnWater(double nWater){
        this.nWater = nWater;
    }


    @Override
    public void checkAmountOfWater()
    {
        System.out.println("Уровень воды: " + nWater);
        if (waterType.equals(WaterType.FLOOD))
        {
            owner.startToThink();
        }
        else{
            System.out.println("Но пяточку не о чем было волноваться");
        }

    }


    @Override
    public String toString()
    {
        return "Home{" +
                "name='" + getName() + '\'' +
                ", owner=" + owner +
                ", danger=" + danger +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Home)) return false;
        if (!super.equals(o)) return false;
        Home home = (Home) o;
        return  Objects.equals(getName(), home.getName()) &&
                Objects.equals(getOwner(), home.getOwner()) &&
                waterType == home.waterType &&
                Objects.equals(danger, home.danger);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getName(), getOwner(), waterType, danger);
    }
}
