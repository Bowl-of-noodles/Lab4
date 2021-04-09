package edu.rogachova.description;

import edu.rogachova.ability.ReasonToWorry;

import java.util.Objects;

public class Danger
{
    private ReasonToWorry danger;

    public Danger(){
        this.danger = ReasonToWorry.NONE;
    }

    public ReasonToWorry getDanger()
    {
        return danger;
    }

    public void setDanger(ReasonToWorry danger)
    {
        this.danger = danger;
    }

    @Override
    public String toString()
    {
        return "Danger{" +
                "danger='" + danger + '\'' +
                '}';
    }

    @Override
    public int hashCode(){
        return danger.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Danger)) return false;
        Danger danger1 = (Danger) o;
        return Objects.equals(danger, danger1.danger);
    }
}
