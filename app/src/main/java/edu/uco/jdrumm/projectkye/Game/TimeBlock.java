package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

public class TimeBlock extends Block
{
    private int time;
    public TimeBlock(int x, int y, int time)
    {
        super(x, y);
        if(time < 10)
            this.time = time;
        else
            this.time = 9;
        frequency = 30;
        updateIcon();
    }

    @Override
    public void action(GameBoard board)
    {
        time--;
        if(time >= 0)
            updateIcon();
        else
            board.removeObject(this);
    }

    private void updateIcon()
    {
        switch(time)
        {
            case 9:
                icon = R.drawable.block9;
                break;
            case 8:
                icon = R.drawable.block8;
                break;
            case 7:
                icon = R.drawable.block7;
                break;
            case 6:
                icon = R.drawable.block6;
                break;
            case 5:
                icon = R.drawable.block5;
                break;
            case 4:
                icon = R.drawable.block4;
                break;
            case 3:
                icon = R.drawable.block3;
                break;
            case 2:
                icon = R.drawable.block2;
                break;
            case 1:
                icon = R.drawable.block1;
                break;
            default:
                icon = R.drawable.block0;
        }
    }
}
