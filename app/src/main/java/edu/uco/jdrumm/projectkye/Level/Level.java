package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.GameBoard;
import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Wall;

public abstract class Level {


    private Level nextLevel;
    protected BaseObject[] objects;
    protected String levelMessage, levelName;

    public Level()
    {
        levelMessage = "Please change this to a unique level message";
        levelName = "WE THREW OUT HIS NAME!!!!";
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

    public String getLevelMessage()
    {
        return levelMessage;
    }

    public String getLevelName()
    {
        return levelName;
    }
}


