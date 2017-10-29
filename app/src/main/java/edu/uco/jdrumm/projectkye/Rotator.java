package edu.uco.jdrumm.projectkye;

/**
 * Created by josh on 10/27/17.
 */

public class Rotator extends BaseObject implements Moveable
{
    private Rotation r;

    public Rotator(int x, int y, Rotation r)
    {
        super(x,y);
        this.r = r;
    }

    @Override
    public int getIcon()
    {
        switch (r)
        {
            case CLOCKWISE:
                return R.drawable.rotatorclockwise;
            default:
                return R.drawable.rotatorcounterclockwise;
        }
    }

    public Rotation getRotation()
    {
        return r;
    }
}
