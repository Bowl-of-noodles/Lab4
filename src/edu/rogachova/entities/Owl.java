package edu.rogachova.entities;

import edu.rogachova.description.Place;

public class Owl extends Character
{
    public Owl(String name){
        super(name);
    }

    @Override
    public void saveOneself()
    {
        System.out.println(this.getName() + " может улететь");
    }

    @Override
    public void startToThink()
    {
        System.out.println(this.getName() + " начала думать");
    }
}
