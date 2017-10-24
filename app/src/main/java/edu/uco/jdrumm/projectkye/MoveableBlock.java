package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class MoveableBlock extends BaseObject {
    public MoveableBlock(int x, int y) {
        super(x, y);
        icon.setImageResource(R.drawable.moveableblock);
    }

    @Override
    public void checkNextCordinate(int nextX, int nextY) {

    }

    @Override
    public void action() {

    }
}
