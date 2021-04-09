package edu.rogachova.ability;

import edu.rogachova.exceptions.NoGroovesException;
import edu.rogachova.water.Groove;

public interface MoveableInWater
{
    void wasInTheWater(Groove[] grooves) throws NoGroovesException;
    boolean isVisitedGroove(Groove groove);
    Groove[] getWhatGrooveVisited();
}
