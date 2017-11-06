package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class HorizontalMagnet extends Actor implements Moveable
{

    public HorizontalMagnet(int x, int y) {
        super(x, y);
        icon = R.drawable.magnethorizontal;
    }

    @Override
    public void action(GameBoard board)
    {
        BaseObject o, o2;
        o = board.getAt(x - 2, y);
        o2 = board.getAt(x + 2, y);

        if(o instanceof Kye)
            board.moveGameObject(this, x - 1, y);
        else if(o != null && o instanceof Moveable && !(o instanceof HorizontalMagnet))
        {
            board.moveGameObject(o, x - 1, y);
            if(o instanceof SquareArrowBlock)
                ((SquareArrowBlock) o).stop();
        }

        if(o2 instanceof Kye)
            board.moveGameObject(this, x + 1, y);
        else if(o2 != null && o2 instanceof Moveable && !(o2 instanceof HorizontalMagnet))
        {
            board.moveGameObject(o2, x + 1, y);
            if(o2 instanceof SquareArrowBlock)
                ((SquareArrowBlock) o2).stop();
        }
    }
}
