package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class Block extends Actor implements Moveable
{
    public Block(int x, int y)
    {
        super(x, y);
        icon = R.drawable.block;
    }

    @Override
    public void action(GameBoard board)
    {

    }
}
