package edu.rogachova.entities;

import edu.rogachova.ability.IMovePlace;
import edu.rogachova.description.Place;

public class Pooh extends Character
{
    private IMovePlace placeMove;

    public Pooh(String name, IMovePlace place){
        super(name);
        placeMove = place;
    }

    @Override
    public void saveOneself()
    {
        Place newPlace = placeMove.makePlace();
        System.out.println(this.getName() + " может забраться на " + newPlace.getName());
    }

    @Override
    public void startToThink()
    {
        System.out.println(this.getName() + " начал думать");
    }
}
