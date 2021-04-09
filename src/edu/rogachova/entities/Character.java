package edu.rogachova.entities;

import edu.rogachova.ability.AbleToRemember;
import edu.rogachova.ability.IMovePlace;
import edu.rogachova.description.Place;

import java.util.Objects;

public abstract class Character implements AbleToRemember
{
    private String name;
    private Place place;

    public Character(String name){
        this.name = name;
    }

    public Character(String name, Place place){
        this.name = name;
        this.place = place;
    }


    public String getName(){
        return name;
    }

    public Place getPlace(){
        return place;
    }

    public abstract void startToThink();

    public abstract void saveOneself();

    @Override
    public void recollectMemories(){
        System.out.println(this.name + " задумался");
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) &&
               Objects.equals(place, character.place);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, place);
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", location=" + place +
                '}';
    }

}
