package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class Diamond extends BaseObject implements Destroyable
{

    public Diamond(int x, int y)
    {
        super(x, y);
        icon = R.drawable.diamond;
    }

    public int getFrequency()
    {
        return 20;
    }
}
