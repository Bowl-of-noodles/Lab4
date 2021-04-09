package edu.rogachova.entities;

import edu.rogachova.description.Place;

public class Kanga extends Character
{
    public Kanga(String name){
        super(name);
    }

    @Override
    public void saveOneself()
    {
        System.out.println(this.getName() + " может ускакать");
    }

    @Override
    public void startToThink()
    {
        System.out.println(this.getName() + " начала думать");
    }
}
