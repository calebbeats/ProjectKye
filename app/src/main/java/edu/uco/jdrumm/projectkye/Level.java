package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public abstract class Level {


    private Level nextLevel;

    public Level()
    {

    }

    public abstract void populateBoard(GameBoard b);

    public Level getNextLevel()
    {
        return nextLevel;
    }

    public void setNextLevel(Level l)
    {
        nextLevel = l;
    }
}


