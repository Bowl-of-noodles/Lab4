package edu.rogachova.exceptions;

public class WaterLevelOutOfRangeError extends Error
{
    public WaterLevelOutOfRangeError(){
        System.out.println("Уровень воды вышел за предел");
    }
}
