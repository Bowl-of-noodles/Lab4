package edu.rogachova.things;

import edu.rogachova.description.Place;

public class Bottle
{
    private String name;
    private boolean isEmpty;
    private Paper content;
    private boolean isOpen;
    private Place place;
    private boolean isVisible;

    public Bottle(String name){
        this.name = name;
        isEmpty = true;
        isOpen = true;
        isVisible = true;
    }

    public Bottle(String name, Place place){
        this.name = name;
        this.place = place;
        isEmpty = true;
        isOpen = true;
        isVisible = true;

    }

    public String getName()
    {
        return name;
    }

    public void setisVisible(boolean is)
    {
        this.isVisible = is;
    }

    public void putInTHeBottle(Paper paper){
        isEmpty = false;
        this.content = paper;
        System.out.println("В " + this.name + " теперь " + paper.getName());
    }

    public void moveToAnotherPlace(Place place){
        this.place = place;
    }

    public class Bung{
        String name;
        public Bung(String name){
            this.name = name;
        }
        public void closeBottle(){
            isOpen = false;
            System.out.println("Бутылка закрыта пробкой");
        }

        public String getName()
        {
            return this.name;
        }
    }
}
//вложенный класс пробка Bung