package edu.rogachova.entities;

import edu.rogachova.ability.IMovePlace;
import edu.rogachova.ability.ReasonToWorry;
import edu.rogachova.description.Danger;
import edu.rogachova.description.Place;

public class ChristopherRobin extends Character
{
    IMovePlace movePlace;
    public ChristopherRobin(String name, IMovePlace place){
        super(name);
        movePlace = place;
    }

    @Override
    public void saveOneself()
    {
        Place newPlace = movePlace.makePlace();
        System.out.println(this.getName() + " может забраться на " + newPlace.getName());
    }

    @Override
    public void startToThink()
    {
        System.out.println(this.getName() + " рассказал историю");
    }



}
