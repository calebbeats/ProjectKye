package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class Kye extends Actor
{
    public Kye(int x, int y)
    {
        super(x,y);
        icon = R.drawable.kye;
    }

    @Override
    public void action(GameBoard board)
    {
        Direction d = board.popFromInputQueue();
        if(d == null)
            return;
        int dx = 0, dy = 0;
        switch(d)
        {
            case UP:
                dy = -1;
                break;
            case RIGHT:
                dx = 1;
                break;
            case DOWN:
                dy = 1;
                break;
            default:
                dx = -1;
        }

        board.moveGameObject(this, getCordX() + dx, getCordY() + dy);
    }
}
