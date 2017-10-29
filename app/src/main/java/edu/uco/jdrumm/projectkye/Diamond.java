package edu.uco.jdrumm.projectkye;

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
}
