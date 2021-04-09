package edu.rogachova.exceptions;

import edu.rogachova.water.Groove;

public class NoGroovesException extends Exception
{
    public NoGroovesException(Groove ... groove){

        super("Канавки не были найден.");
    }
}
