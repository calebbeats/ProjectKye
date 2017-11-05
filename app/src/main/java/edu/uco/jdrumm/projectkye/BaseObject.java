package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public abstract class BaseObject {

    public int icon;
    protected int x;
    protected int y;
    protected int frequency, frame;

    public BaseObject(int x, int y)
    {
        setCordX(x);
        setCordY(y);
        frequency = frame = 0;
    }

    public int getIcon()
    {
        return icon;
    }


    public int getCordX() {
        return x;
    }

    public void setCordX(int x) {
        this.x = x;
    }

    public int getCordY() {
        return y;
    }

    public void setCordY(int y) {
        this.y = y;
    }
}
