package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

public class Diamond extends Actor implements Destroyable
{

    public Diamond(int x, int y)
    {
        super(x, y);
        if(Math.random() < 0.5)
            icon = R.drawable.diamond1;
        else
            icon = R.drawable.diamond2;
        frequency = 20;
    }

    @Override
    public void action(GameBoard board)
    {
        if(Math.random() < 0.1)
        {
            if(icon == R.drawable.diamond1)
                icon = R.drawable.diamond2;
            else
                icon = R.drawable.diamond1;
        }
    }
}
