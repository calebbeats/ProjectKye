package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class ForceField extends Actor
{
    private static int[] imagesH = {
            R.drawable.ffh1,
            R.drawable.ffh2
            };

    private static int[] imagesV = {
            R.drawable.ffv1,
            R.drawable.ffv2
    };

    public static int sFrame = 0;
    public static int sFrequency = 3;

    private int[] images;
    private Direction d;

    public ForceField(int x, int y, Direction d)
    {
        super(x, y);
        if(d == Direction.DOWN || d == Direction.UP)
            images = imagesV;
        else
            images = imagesH;

        icon = images[0];
        this.d = d;
        frequency = 3;
    }

    @Override
    public void act(GameBoard board)
    {
        if(sFrame >= sFrequency)
            action(board);
        else
            return;
    }

    @Override
    public void action(GameBoard board)
    {
        if(icon == images[0])
            icon = images[1];
        else
            icon = images[0];
    }

    public Direction getPassableDirection()
    {
        return d;
    }
}
