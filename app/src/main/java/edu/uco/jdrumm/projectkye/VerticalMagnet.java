package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class VerticalMagnet extends Actor implements Moveable
{

    public VerticalMagnet(int x, int y)
    {
        super(x, y);
        icon = R.drawable.magnetvertical;
    }

    @Override
    public void action(GameBoard board)
    {
        BaseObject o, o2;
        o = board.getAt(x, y - 2);
        o2 = board.getAt(x, y + 2);

        if(o instanceof Kye)
            board.moveGameObject(this, x, y - 1);
        else if(o != null && o instanceof Moveable && !(o instanceof VerticalMagnet))
            board.moveGameObject(o, x, y - 1);

        if(o2 instanceof Kye)
            board.moveGameObject(this, x, y + 1);
        else if(o2 != null && o2 instanceof Moveable && !(o2 instanceof VerticalMagnet))
            board.moveGameObject(o2, x, y + 1);
    }
}
