package edu.rogachova.entities;


public class Rabbit extends Character
{
    public Rabbit(String name){
        super(name);
    }

    @Override
    public void saveOneself()
    {
        System.out.println(this.getName() + " может зарыться в землю");
    }

    @Override
    public void startToThink()
    {
        System.out.println(this.getName() + " начал думать");
    }
}
