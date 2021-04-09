package edu.rogachova.entities;

import edu.rogachova.description.Place;

public class Eeyore extends Character
{
    public Eeyore(String name){
        super(name);
    }

    @Override
    public void saveOneself()
    {
        System.out.println(this.getName() + " может громко закричать");
    }

    @Override
    public void startToThink()
    {
        System.out.println(this.getName() + " начал думать");
    }
}
