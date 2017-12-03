package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class RoundShooter extends Shooter
{
    public RoundShooter(int x, int y, Direction d)
    {
        super(x, y, d);

        imageUp = R.drawable.roundshooteru;
        imageRight = R.drawable.roundshooterr;
        imageDown = R.drawable.roundshooterd;
        imageLeft = R.drawable.roundshooterl;

        initialize();
    }

    @Override
    protected BaseObject getNewShootObject()
    {
        return new RoundSlider(x + dx, y + dy, d);
    }
}
