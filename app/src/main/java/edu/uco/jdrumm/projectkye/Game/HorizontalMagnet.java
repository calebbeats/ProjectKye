package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class HorizontalMagnet extends Actor implements Moveable, Magnet
{

    public HorizontalMagnet(int x, int y) {
        super(x, y);
        icon = R.drawable.magnethorizontal;
    }

    @Override
    public void action(GameBoard board)
    {
        BaseObject o, ol, o2, or;
        o = board.getAt(x - 2, y);
        ol = board.getAt(x - 1, y);
        o2 = board.getAt(x + 2, y);
        or = board.getAt(x + 1, y);

        if(o instanceof Kye && ol == null)
            board.moveGameObject(this, x - 1, y);
        else if(ol instanceof ActorRotatable)
            ((ActorRotatable) ol).stop();
        else if(o instanceof Moveable && !(o instanceof HorizontalMagnet))
        {
            board.moveGameObject(o, x - 1, y);
            if(o instanceof ActorRotatable)
                ((ActorRotatable) o).stop();
        }

        if(o2 instanceof Kye && or == null)
            board.moveGameObject(this, x + 1, y);
        else if(or instanceof ActorRotatable)
            ((ActorRotatable) or).stop();
        else if(o2 instanceof Moveable && !(o2 instanceof HorizontalMagnet))
        {
            board.moveGameObject(o2, x + 1, y);
            if(o2 instanceof ActorRotatable)
                ((ActorRotatable) o2).stop();
        }
    }
}
