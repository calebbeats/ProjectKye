package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class Block extends BaseObject implements Moveable
{
    public Block(int x, int y)
    {
        super(x, y);
        icon = R.drawable.block;
    }
}
