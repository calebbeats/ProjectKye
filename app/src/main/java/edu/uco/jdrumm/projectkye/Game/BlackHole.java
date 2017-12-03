package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

public class BlackHole extends Actor
{
    private int[] images = {
            R.drawable.blackhole1,
            R.drawable.blackhole2,
            R.drawable.blackhole3,
            R.drawable.blackhole4
    };

    private int[] images2 = {
            R.drawable.blackholeswallow1,
            R.drawable.blackholeswallow2,
            R.drawable.blackholeswallow3,
            R.drawable.blackholeswallow4
    };

    private int frame;
    private boolean swallowing;

    public BlackHole(int x, int y)
    {
        super(x, y);
        frequency = 5;
        icon = R.drawable.blackhole3;
        frame = 1;
        swallowing = false;
    }

    @Override
    public void action(GameBoard board)
    {
        if(frame < 3)
            frame++;
        else
        {
            frame = 0;
            if(swallowing)
                swallowing = false;
        }

        if(swallowing)
            icon = images2[frame];
        else
            icon = images[frame];
    }

    public boolean swallow(GameBoard board, BaseObject o)
    {
        if(swallowing)
            return false;
        swallowing = true;
        icon = images2[frame = 0];

        if(o instanceof Kye)
            ((Kye) o).kill(board);
        else
            board.removeObject(o);
        return true;
    }
}
