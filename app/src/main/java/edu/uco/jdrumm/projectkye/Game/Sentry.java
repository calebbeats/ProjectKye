package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

/**
 * Created by josh on 11/7/17.
 */

public class Sentry extends ActorRotatable implements Moveable
{

    public Sentry(int x, int y, Direction d)
    {
        super(x, y, d);
        frequency = 5;

        imageUp = R.drawable.sentryu;
        imageRight = R.drawable.sentryr;
        imageDown = R.drawable.sentryd;
        imageLeft = R.drawable.sentryl;

        initialize();
    }

    @Override
    public void action(GameBoard board)
    {
        if(!stopped)
        {
            BaseObject o = board.getAt(x + dx, y + dy);
            if (o == null || o instanceof BlackHole)
                board.moveGameObject(this, x + dx, y + dy);
            else
            {
                if (o instanceof Moveable)
                    board.pushGameObject(o, x + dx * 2, y + dy * 2);
                turnAround();
            }
        }
        else
            checkForMagnets(board);
    }

    private void turnAround()
    {
        switch(d)
        {
            case UP:
                turnDown();
                break;
            case RIGHT:
                turnLeft();
                break;
            case DOWN:
                turnUp();
                break;
            default:
                turnRight();
        }
    }
}
