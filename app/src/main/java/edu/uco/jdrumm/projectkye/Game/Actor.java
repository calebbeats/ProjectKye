package edu.uco.jdrumm.projectkye.Game;

/**
 * Created by josh on 11/2/17.
 */

public abstract class Actor extends BaseObject
{
    public Actor(int x, int y)
    {
        super(x, y);
        frequency = 1;
    }

    public void act(GameBoard board)
    {
        frame++;
        if(frame >= frequency)
        {
            frame = 0;
            action(board);
        }
        else
            return;
    }

    public abstract void action(GameBoard board);
}
