package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class BlockCircle extends BaseObject implements Moveable, Round
{
    public BlockCircle(int x, int y)
    {
        super(x, y);
        icon = R.drawable.blockround;
    }
}
