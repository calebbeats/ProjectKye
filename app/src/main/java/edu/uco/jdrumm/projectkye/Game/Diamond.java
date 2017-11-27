package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

public class Diamond extends BaseObject implements Destroyable
{

    public Diamond(int x, int y)
    {
        super(x, y);
        icon = R.drawable.diamond2;
    }

    public int getFrequency()
    {
        return 20;
    }
}
