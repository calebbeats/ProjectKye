package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class GameBoard {

    public BaseObject[][] board;
    public Level currentLevel;
    public Level nextLevel;

    public GameBoard()
    {
        board = new BaseObject[30][20];
    }

    public void clearBoard()
    {

    }

    public void loadLevel()
    {
        currentLevel.populateBoard(this);
    }

    public void setCurrentLevel(Level l)
    {
        currentLevel = l;
    }

    public void setNextLevel(Level l)
    {
        nextLevel = l;
    }
}


