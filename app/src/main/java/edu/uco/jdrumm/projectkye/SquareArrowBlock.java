package edu.uco.jdrumm.projectkye;

public class SquareArrowBlock extends BaseObject implements Moveable
{

    Direction d;

    public SquareArrowBlock(int x, int y, Direction d)
    {
        super(x, y);
        this.d = d;
    }

    @Override
    public void checkNextCordinate(int nextX, int nextY) {

    }

    @Override
    public void action() {

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
}
