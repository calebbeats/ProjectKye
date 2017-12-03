package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class SquareShooter extends Shooter
{
    public SquareShooter(int x, int y, Direction d)
    {
        super(x, y, d);

        imageUp = R.drawable.squarrowshooteru;
        imageRight = R.drawable.squarrowshooterr;
        imageDown = R.drawable.squarrowshooterd;
        imageLeft = R.drawable.squarrowshooterl;

        initialize();
    }

    @Override
    protected BaseObject getNewShootObject()
    {
        return new SquareSlider(x + dx, y + dy, d);
    }
}
