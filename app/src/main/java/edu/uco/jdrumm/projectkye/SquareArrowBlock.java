package edu.uco.jdrumm.projectkye;

public class SquareArrowBlock extends BaseObject implements Moveable
{

    private Direction d;

    public SquareArrowBlock(int x, int y, Direction d)
    {
        super(x, y);
        this.d = d;
    }

    @Override
    public int getIcon()
    {
        switch(d)
        {
            case UP:
                return R.drawable.squarrowu;
            case RIGHT:
                return R.drawable.squarrowr;
            case DOWN:
                return R.drawable.squarrowd;
            default:
                return R.drawable.squarrowl;

        }
    }

    public Direction getDirection()
    {
        return d;
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
                        break;
                    case RIGHT:
                        d = Direction.DOWN;
                        break;
                    case DOWN:
                        d = Direction.LEFT;
                        break;
                    default:
                        d = Direction.UP;
                }
                break;
            default:
                switch (d)
                {
                    case UP:
                        d = Direction.LEFT;
                        break;
                    case RIGHT:
                        d = Direction.UP;
                        break;
                    case DOWN:
                        d = Direction.RIGHT;
                        break;
                    default:
                        d = Direction.DOWN;
                }
        }
    }
}
