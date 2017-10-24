package edu.uco.jdrumm.projectkye;

import android.widget.ImageView;

/**
 * Created by caleb on 10/23/2017.
 */

public abstract class BaseObject {

    public ImageView icon;
    private int cordX;
    private int cordY;

    public BaseObject(int x, int y)
    {
        cordX = x;
        cordY = y;
    }

    //Checks the next spot. If it works then will call action();
    public abstract void checkNextCordinate(int nextX, int nextY);
    //Does the necessary action for when player object collides;
    public abstract void action();

    public ImageView getIcon()
    {
        return icon;
    }
}
