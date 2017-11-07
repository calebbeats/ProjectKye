package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class RoundSlider extends ActorRotatable implements Moveable
{
    public RoundSlider(int x, int y, Direction d)
    {
        super(x, y, d);

        imageUp = R.drawable.roundslideru;
        imageRight = R.drawable.roundsliderr;
        imageDown = R.drawable.roundsliderd;
        imageLeft = R.drawable.roundsliderl;

        initialize();
    }

    @Override
    public void action(GameBoard board)
    {
        if(!stopped)
        {
            BaseObject o = board.getAt(x + dx, y + dy);
            if (o == null)
                board.moveGameObject(this, x + dx, y + dy);
            else if (o instanceof Rotator)
                rotate(((Rotator) o).getRotation());
            else
            {
                //Handle all rounding around objects here
                boolean rleft, rright; //Relative left and right
                rleft = rright = false;
                if(o instanceof BlockCircle || o instanceof RoundSlider)
                {
                    int olx, oly;
                    int orx, ory;
                    switch(d)
                    {
                        case UP:
                            olx = x - 1;
                            oly = y - 1;
                            orx = x + 1;
                            ory = y - 1;
                            break;
                        case RIGHT:
                            olx = x + 1;
                            oly = y - 1;
                            orx = x + 1;
                            ory = y + 1;
                            break;
                        case DOWN:
                            olx = x - 1;
                            oly = y + 1;
                            orx = x + 1;
                            ory = y + 1;
                            break;
                        default:
                            olx = x - 1;
                            oly = y + 1;
                            orx = x - 1;
                            ory = y - 1;
                    }

                    BaseObject ol = board.getAt(olx, oly);
                    BaseObject or = board.getAt(orx, ory);

                    if(ol == null && board.getAt(x + dy, y - dx) == null)
                        rleft = true;
                    if(or == null && board.getAt(x - dy, y + dx) == null)
                        rright = true;

                    if(rleft && rright)
                    {
                        if(Math.random() < 0.5)
                            rleft = false;
                        else
                            rright = false;
                    }
                    if(rleft && !rright)
                        board.moveGameObject(this, olx, oly);
                    else if(!rleft && rright)
                        board.moveGameObject(this, orx, ory);
                }
            }
        }
        else
            checkForMagnets(board);
    }
}
