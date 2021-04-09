package edu.rogachova.entities;

import edu.rogachova.ability.MoveableInWater;
import edu.rogachova.ability.ReasonToWorry;
import edu.rogachova.ability.Worriable;
import edu.rogachova.description.Danger;
import edu.rogachova.description.Home;
import edu.rogachova.description.Place;
import edu.rogachova.exceptions.NoGroovesException;
import edu.rogachova.things.Bottle;
import edu.rogachova.things.Paper;
import edu.rogachova.things.Pencil;
import edu.rogachova.water.Groove;

import java.util.ArrayList;
import java.util.Objects;


public class Piglet extends Character implements Worriable, MoveableInWater
{
    private Home home;
    private Groove[] visitedGrooves;
    private ReasonToWorry reasonToWorry;

    public Piglet(String name, Home home){
        super(name);
        this.home = home;
    }


    public Home getHome(){
        return home;
    }

    public ReasonToWorry getReasonToWorry()
    {
        return reasonToWorry;
    }

    public void setReasonToWorry(ReasonToWorry reasonToWorry)
    {
        this.reasonToWorry = reasonToWorry;
    }

    public void createRescueBottle(Bottle bottle, Paper paper, Pencil pencil, Bottle.Bung bung){
        System.out.println(this.getName() + " решил написать послание");
        paper.writeMessage(pencil, "ПОМОГИТЕ! ПЯТАЧКУ (ЭТО Я)! ЭТО Я, ПЯТАЧОК, СПАСИТЕ, ПОМОГИТЕ!");
        System.out.println(paper.getMessage());
        System.out.println("Положил " + paper.getName() + " в" + bottle.getName());
        bottle.putInTHeBottle(paper);
        System.out.println("Затем решил закупорить бутылку");
        bung.closeBottle();
    }

    public void beggingRescue(Bottle bottle){
        bottle.moveToAnotherPlace(new Place("Улица"));
        System.out.println(this.getName() + " выбросил на удицу " + bottle.getName());
        feelPainAfterWatching();
        bottle.setisVisible(false);
        System.out.println(bottle.getName() + " скрылась из виду, " + this.getName() + " ее никогда не увидит");
    }

    public void feelPainAfterWatching(){
        System.out.println("смотрел вдаль, пока не заболели глаза");
    }

    @Override
    public void wasInTheWater(Groove[] grooves) throws NoGroovesException
    {
        long numberOfVisited = Math.round((double)grooves.length/2);
        if (numberOfVisited > 0)
        {
            visitedGrooves = new Groove[(int) numberOfVisited];
            int number = 0;
            for (int i = 0; i < grooves.length; i++)
            {
                if (i % 2 == 0)
                {
                    grooves[i].setIfVisited(true);
                    visitedGrooves[number] = grooves[i];
                    number++;
                } else
                {
                    grooves[i].setIfVisited(false);
                }
            }
        }
        else{
            throw new NoGroovesException();
        }
    }

    @Override
    public boolean isVisitedGroove(Groove groove){
        for (Groove checkedGroove : visitedGrooves)
        {
            if (checkedGroove.equals(groove)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Groove[] getWhatGrooveVisited(){
        return visitedGrooves;
    }

    @Override
    public void saveOneself()
    {
        System.out.println("А я, " + this.getName() + ", ничего не могу сделать для своего спасения!");
    }

    @Override
    public void recollectMemories(){
        ArrayList<String> names = new ArrayList<>();
        for(int i=0; i<visitedGrooves.length; i++){
            names.add(visitedGrooves[i].getName());
        }
        System.out.print("\nПяточек вспоминал, как он прыгал через ");
        for(String name: names){
            System.out.print("\t" + name);
        }

    }

    @Override
    public void startToWorry(){
        System.out.println("Пятачок начал беспокоится, нужно проверить количество воды");
        this.getHome().checkAmountOfWater();
    }

    public void toBeInTheirHome()
    {
         home.setOwner(this);
    }

    @Override
    public void startToThink(){
        System.out.println("Пяточек увидел, как сильно поднялся уровень воды. Он начал боятся, что его дом затопит");
        setReasonToWorry(ReasonToWorry.ESCAPING);
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Piglet)) return false;
        if (!super.equals(o)) return false;
        Piglet piglet = (Piglet) o;
        return Objects.equals(getName(), piglet.getName()) &&
                Objects.equals(getHome(), piglet.getHome());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getName(), getHome());
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + this.getName() + '\'' +
                ", location=" + home.getName() +
                '}';
    }
}
