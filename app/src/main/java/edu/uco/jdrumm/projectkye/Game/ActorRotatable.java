package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;
import edu.uco.jdrumm.projectkye.R;

/**
 * Created by josh on 11/7/17.
 */

public abstract class ActorRotatable extends Actor
{
    protected Direction d;
    protected int dx, dy;
    protected boolean stopped;
    protected int imageUp, imageRight, imageDown, imageLeft;

    public ActorRotatable(int x, int y, Direction d)
    {
        super(x, y);
        this.d = d;
    }

    public Direction getDirection()
    {
        return d;
    }

    protected void initialize()
    {
        switch(d)
        {
            case UP:
                turnUp();
                break;
            case RIGHT:
                turnRight();
                break;
            case DOWN:
                turnDown();
                break;
            default:
                turnLeft();
        }
    }

    protected void turnUp()
    {
        d = Direction.UP;
        dx = 0;
        dy = -1;
        icon = imageUp;
    }

    protected void turnRight()
    {
        d = Direction.RIGHT;
        dx = 1;
        dy = 0;
        icon = imageRight;
    }

    protected void turnDown()
    {
        d = Direction.DOWN;
        dx = 0;
        dy = 1;
        icon = imageDown;
    }

    protected void turnLeft()
    {
        d = Direction.LEFT;
        dx = -1;
        dy = 0;
        icon = imageLeft;
    }

    public void rotate(Rotation r)
    {
        switch(r)
        {
            case CLOCKWISE:
                switch(d)
                {
                    case UP:
                        turnRight();
                        break;
                    case RIGHT:
                        turnDown();
                        break;
                    case DOWN:
                        turnLeft();
                        break;
                    default:
                        turnUp();
                }
                break;
            default:
                switch (d)
                {
                    case UP:
                        turnLeft();
                        break;
                    case RIGHT:
                        turnUp();
                        break;
                    case DOWN:
                        turnRight();
                        break;
                    default:
                        turnDown();
                }
        }
    }

    public void stop()
    {
        stopped = true;
    }

    public void checkForMagnets(GameBoard board)
    {
        BaseObject o = board.getAt(x - 1, y);
        if(o instanceof HorizontalMagnet)
            return;
        o = board.getAt(x + 1, y);
        if(o instanceof HorizontalMagnet)
            return;
        o = board.getAt(x, y - 1);
        if(o instanceof VerticalMagnet)
            return;
        o = board.getAt(x, y + 1);
        if(o instanceof VerticalMagnet)
            return;
        stopped = false;
        action(board); //Might remove this. This makes it so the piece can take its action right after becoming unstuck
    }
}
