package edu.rogachova;

import edu.rogachova.ability.AbleToRemember;
import edu.rogachova.ability.ReasonToWorry;
import edu.rogachova.description.*;
import edu.rogachova.entities.*;
import edu.rogachova.things.Bottle;
import edu.rogachova.things.Paper;
import edu.rogachova.things.Pencil;
import edu.rogachova.water.Flood;
import edu.rogachova.water.WaterLevel;
import edu.rogachova.water.Groove;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Piglet piglet = new Piglet("Пяточок", new Home("Дом пяточка"));

        Random random = new Random();
        int nOfGrooves = random.nextInt(10) +1;
        System.out.println(nOfGrooves);
        Groove[] grooves = new Groove[nOfGrooves];

        for(int i = 0; i < grooves.length; i++){
            grooves[i] = new Groove();
            String number = Integer.toString(i + 1);
            grooves[i].setName("Канавка " + number);
        }
        piglet.wasInTheWater(grooves);


        piglet.recollectMemories();
        piglet.toBeInTheirHome();

        System.out.println();

        double amountOfWater = random.nextInt(10) +1;
        System.out.println(amountOfWater);
        for(Groove groove: piglet.getWhatGrooveVisited())
        {
            groove.setnWater(amountOfWater);
        }

        WaterLevel waterLevel = new WaterLevel(30);
        boolean beginingOfFlood = waterLevel.changeWaterAmount(piglet, piglet.getWhatGrooveVisited());
        if(beginingOfFlood){
            Danger danger = new Danger();
            Flood flood = new Flood();
            danger.setDanger(ReasonToWorry.FLOOD);
            flood.startFlood(danger, piglet);
        }

        ChristopherRobin christopherRobin = new ChristopherRobin("Кристофер Робин", () -> new Place("Дерево"));
        Pooh pooh = new Pooh("Винни-Пух", () -> new Place("Дерево"));
        Eeyore eeyore = new Eeyore("Иа-иа");
        Kanga kanga = new Kanga("Кенга");
        Owl owl = new Owl("Сова");
        Rabbit rabbit = new Rabbit("Кролик");



        if(piglet.getReasonToWorry() == ReasonToWorry.ESCAPING){
                System.out.println("Страшно быть Очень Маленьким Существом, совершенно окруженным водой!");
                christopherRobin.saveOneself();
                pooh.saveOneself();
                kanga.saveOneself();
                rabbit.saveOneself();
                owl.saveOneself();
                eeyore.saveOneself();
                piglet.saveOneself();
        }

        waterLevel.changeWaterLavel(piglet.getHome().getnWater(), "до окошка");
        AbleToRemember ableToRemember = () -> {
            System.out.println(piglet.getName() + " вспонил историю, котрую ему рассказал " + christopherRobin.getName());
            Person person = new Person("Человек", new Place("Необитаемый остров"), () -> new Place("Море"));
            person.saveOneself();
            person.escaping(new Bottle("Бутылка"), new Paper("Лист бумаги", ""));
            System.out.println(piglet.getName() + " подумал сделать также, чтобы его спасли");
        };
        ableToRemember.recollectMemories();

        Bottle bottle = new Bottle("Бутылка");
        Bottle.Bung bung = bottle.new Bung("Пробка");
        Pencil pencil = new Pencil("Карандаш");
        Paper paper = new Paper("Бумага", "");

        piglet.createRescueBottle(bottle, paper, pencil, bung);
        piglet.beggingRescue(bottle);



    }


}
