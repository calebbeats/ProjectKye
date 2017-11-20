package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class Kye extends Actor
{
    private int startX, startY;

    public Kye(int x, int y)
    {
        super(x,y);
        startX = x;
        startY = y;
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

    void kill(GameBoard board)
    {
        board.respawnKye(startX, startY);
        x = startX;
        y = startY;
    }
}
