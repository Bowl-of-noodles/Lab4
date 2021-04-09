package edu.rogachova.entities;

import edu.rogachova.ability.IMovePlace;
import edu.rogachova.description.Place;
import edu.rogachova.things.Bottle;
import edu.rogachova.things.Paper;

public class Person extends Character
{
    private IMovePlace movePlace;
    public Person(String name, Place place, IMovePlace movePlace){
        super(name, place);
        this.movePlace = movePlace;
    }
    public void escaping(Bottle bottle, Paper paper)
    {
        System.out.println("Он взял " + paper.getName() + " и " + bottle.getName() );
        System.out.println("Положил " + paper.getName() + " в " + bottle.getName() );
        bottle.putInTHeBottle(paper);
        Place newPlace = movePlace.makePlace();
        System.out.println("Затем он бросил "+ bottle.getName() + " в " + newPlace.getName());
    }

    @Override
    public void saveOneself()
    {
        System.out.println(this.getName() + " должен был спастись с " + getPlace().getName());
    }

    @Override
    public void startToThink()
    {
        System.out.println("Начал думать");
    }
}
