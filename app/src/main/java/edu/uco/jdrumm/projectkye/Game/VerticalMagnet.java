package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

public class VerticalMagnet extends Actor implements Moveable, Magnet
{

    public VerticalMagnet(int x, int y)
    {
        super(x, y);
        icon = R.drawable.magnetvertical;
    }

    @Override
    public void action(GameBoard board)
    {
        BaseObject o, ou, o2, od;
        o = board.getAt(x, y - 2);
        ou = board.getAt(x, y - 1);
        o2 = board.getAt(x, y + 2);
        od = board.getAt(x, y + 1);

        if(o instanceof Kye && ou == null)
            board.moveGameObject(this, x, y - 1);
        else if(ou instanceof ActorRotatable)
            ((ActorRotatable) ou).stop();
        else if(o instanceof Moveable && !(o instanceof VerticalMagnet))
        {
            board.moveGameObject(o, x, y - 1);
            if(o instanceof ActorRotatable)
                ((ActorRotatable) o).stop();
        }

        if(o2 instanceof Kye && od == null)
            board.moveGameObject(this, x, y + 1);
        else if(od instanceof ActorRotatable)
            ((ActorRotatable) od).stop();
        else if(o2 instanceof Moveable && !(o2 instanceof VerticalMagnet))
        {
            board.moveGameObject(o2, x, y + 1);
            if(o2 instanceof ActorRotatable)
                ((ActorRotatable) o2).stop();
        }
    }
}
