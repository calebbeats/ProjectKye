package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class Wall extends BaseObject
{
    private int roundness;

    public Wall(int x, int y, int roundness)
    {
        super(x, y);
        this.roundness = roundness;
        switch(roundness)
        {
            case 1:
                icon = R.drawable.wall1;
                break;
            case 2:
                icon = R.drawable.wall2;
                break;
            case 3:
                icon = R.drawable.wall3;
                break;
            case 4:
                icon = R.drawable.wall4;
                break;
            case 5:
                icon = R.drawable.wall5;
                break;
            case 6:
                icon = R.drawable.wall6;
                break;
            case 7:
                icon = R.drawable.wall7;
                break;
            case 8:
                icon = R.drawable.wall8;
                break;
            case 9:
                icon = R.drawable.wall9;
                break;
            default:
                icon = R.drawable.wall5;
                roundness = 5;
        }
    }

    public Wall(int x, int y)
    {
        this(x, y, 5);
    }

    public int getRoundness()
    {
        return roundness;
    }

    /*
    //Roundness is defined as follows
    1 - Bottom left corner
    2 - Bottom half
    3 - Bottom right corner
    4 - Left half
    5 - Completely Square
    6 - Right half
    7 - Top left corner
    8 - Top half
    9 - Top right corner
    */
}
