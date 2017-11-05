package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public abstract class Level {

    public Kye kye;
    private Level nextLevel;

    public Level(Kye k)
    {
        kye = k;
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


