package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class EmpytBlock extends BaseObject {

    public EmpytBlock(int x, int y)
    {
        super(x, y);
        icon = 0;//R.drawable.emptyblock;
    }

    @Override
    public void checkNextCordinate(int nextX, int nextY) {

    }

    @Override
    public void action() {

    }
}
