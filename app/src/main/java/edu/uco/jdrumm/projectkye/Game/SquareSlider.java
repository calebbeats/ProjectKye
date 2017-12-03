package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class SquareSlider extends ActorRotatable implements Moveable
{
    public SquareSlider(int x, int y, Direction d)
    {
        super(x, y, d);

        imageUp = R.drawable.squarrowu;
        imageRight = R.drawable.squarrowr;
        imageDown = R.drawable.squarrowd;
        imageLeft = R.drawable.squarrowl;

        initialize();
    }

    @Override
    public void action(GameBoard board)
    {
        if(!stopped)
        {
            BaseObject o = board.getAt(x + dx, y + dy);
            if (!(o instanceof Rotator))
                board.pushGameObject(this, x + dx, y + dy);
            else
                rotate(((Rotator) o).getRotation());
        }
        else
            checkForMagnets(board);
    }
}
