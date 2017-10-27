package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class FuzzBlock extends BaseObject implements Destroyable
{
    public FuzzBlock(int x, int y)
    {
        super(x, y);
        icon = R.drawable.block2;
    }

    @Override
    public void checkNextCordinate(int nextX, int nextY) {

    }

    @Override
    public void action() {

    }
}
