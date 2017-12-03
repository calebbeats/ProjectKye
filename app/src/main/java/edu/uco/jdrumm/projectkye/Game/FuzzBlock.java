package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class FuzzBlock extends BaseObject implements Destroyable
{
    public FuzzBlock(int x, int y)
    {
        super(x, y);
        icon = R.drawable.blockfuzz;
    }
}
