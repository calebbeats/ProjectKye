package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.GameBoard;
import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Wall;

/**
 * Created by caleb on 10/23/2017.
 */

public abstract class Level {


    private Level nextLevel;
    protected BaseObject[] objects;

    public Level()
    {

    }

    public void populateBoard(GameBoard b)
    {
        createWalls(b);
        createObjects();
        populate(b);
    }

    private void createWalls(GameBoard b)
    {
        for(int i = 0; i < 30; i++)
        {
            b.addGameObject(new Wall(i, 0));
            b.addGameObject(new Wall(i, 19));
        }
        for(int i = 1; i < 19; i++)
        {
            b.addGameObject(new Wall(0, i));
            b.addGameObject(new Wall(29, i));
        }
    }

    private void populate(GameBoard b)
    {
        for(BaseObject o : objects)
            b.addGameObject(o);
    }

    protected abstract void createObjects();

    public Level getNextLevel()
    {
        return nextLevel;
    }

    public void setNextLevel(Level l)
    {
        nextLevel = l;
    }
}


