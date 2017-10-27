package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class HorizontalMagnet extends BaseObject implements Moveable
{

    public HorizontalMagnet(int x, int y) {
        super(x, y);
        icon = R.drawable.magnethorizontal;
    }

    @Override
    public void checkNextCordinate(int nextX, int nextY) {

    }

    @Override
    public void action() {

    }
}
