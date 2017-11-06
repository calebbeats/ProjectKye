package edu.uco.jdrumm.projectkye;

public class SquareArrowBlock extends Actor implements Moveable
{
    private Direction d;
    private int dx, dy;
    private boolean stopped;

    public SquareArrowBlock(int x, int y, Direction d)
    {
        super(x, y);
        this.d = d;

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

    public Direction getDirection()
    {
        return d;
    }

    private void turnUp()
    {
        dx = 0;
        dy = -1;
        icon = R.drawable.squarrowu;
    }

    private void turnRight()
    {
        dx = 1;
        dy = 0;
        icon = R.drawable.squarrowr;
    }

    private void turnDown()
    {
        dx = 0;
        dy = 1;
        icon = R.drawable.squarrowd;
    }

    private void turnLeft()
    {
        dx = -1;
        dy = 0;
        icon = R.drawable.squarrowl;
    }

    public void rotate(Rotation r)
    {
        switch(r)
        {
            case CLOCKWISE:
                switch(d)
                {
                    case UP:
                        d = Direction.RIGHT;
                        turnRight();
                        break;
                    case RIGHT:
                        d = Direction.DOWN;
                        turnDown();
                        break;
                    case DOWN:
                        d = Direction.LEFT;
                        turnLeft();
                        break;
                    default:
                        d = Direction.UP;
                        turnUp();
                }
                break;
            default:
                switch (d)
                {
                    case UP:
                        d = Direction.LEFT;
                        turnLeft();
                        break;
                    case RIGHT:
                        d = Direction.UP;
                        turnUp();
                        break;
                    case DOWN:
                        d = Direction.RIGHT;
                        turnRight();
                        break;
                    default:
                        d = Direction.DOWN;
                        turnDown();
                }
        }
    }

    public void stop()
    {
        stopped = true;
    }

    @Override
    public void action(GameBoard board)
    {
        if(!stopped)
        {
            BaseObject o = board.getAt(x + dx, y + dy);
            if (o == null)
                board.moveGameObject(this, x + dx, y + dy);
            else if (o instanceof Rotator)
                rotate(((Rotator) o).getRotation());
        }
        else
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
}
