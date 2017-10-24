package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class SquareArrowBlock extends BaseObject {
    public SquareArrowBlock(int x, int y) {
        super(x, y);
        icon.setImageResource(R.drawable.squarearrowblock);
    }

    @Override
    public void checkNextCordinate(int nextX, int nextY) {

    }

    @Override
    public void action() {

    }
}
