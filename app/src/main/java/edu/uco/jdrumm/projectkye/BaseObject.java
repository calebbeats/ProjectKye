package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public abstract class BaseObject {

    public int icon;
    private int cordX;
    private int cordY;

    public BaseObject(int x, int y)
    {
        setCordX(x);
        setCordY(y);
    }

    //Checks the next spot. If it works then will call action();
    public abstract void checkNextCordinate(int nextX, int nextY);
    //Does the necessary action for when player object collides;
    public abstract void action();

    public int getIcon()
    {
        return icon;
    }


    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }
}
