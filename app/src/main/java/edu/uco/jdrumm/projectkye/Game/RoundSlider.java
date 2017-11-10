package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.R;

public class RoundSlider extends ActorRotatable implements Moveable, Round
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
                rleft = rright = true;
                if(o instanceof Round)
                {
                    if(o instanceof Wall)
                    {
                        switch(((Wall) o).getRoundness())
                        {
                            case 1:
                                if(d == Direction.UP)
                                    rleft = true;
                                else if(d == Direction.RIGHT)
                                    rright = true;
                                break;
                            case 2:
                                if(d == Direction.UP)
                                    rleft = rright = true;
                                else if(d == Direction.LEFT)
                                    rleft = true;
                                else if(d == Direction.RIGHT)
                                    rright = true;
                                break;
                            case 3:
                                if(d == Direction.UP)
                                    rright = true;
                                else if(d == Direction.LEFT)
                                    rleft = true;
                                break;
                            case 4:
                                if(d == Direction.UP)
                                    rleft = true;
                                else if(d == Direction.RIGHT)
                                    rright = rleft = true;
                                else if(d == Direction.DOWN)
                                    rright = true;
                                break;
                            case 6:
                                if(d == Direction.UP)
                                    rright = true;
                                else if(d == Direction.LEFT)
                                    rright = rleft = true;
                                else if(d == Direction.DOWN)
                                    rleft = true;
                                break;
                            case 7:
                                if(d == Direction.RIGHT)
                                    rleft = true;
                                else if(d == Direction.DOWN)
                                    rright = true;
                                break;
                            case 8:
                                if(d == Direction.RIGHT)
                                    rleft = true;
                                else if(d == Direction.DOWN)
                                    rright = rleft = true;
                                else if(d == Direction.LEFT)
                                    rright = true;
                                break;
                            case 9:
                                if(d == Direction.DOWN)
                                    rleft = true;
                                else if(d == Direction.LEFT)
                                    rright = true;
                                break;
                            default:
                        }
                    }
                    int olx, oly;
                    int orx, ory;
                    switch (d)
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
                            olx = x + 1;
                            oly = y + 1;
                            orx = x - 1;
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

                    if (ol != null)
                        rleft = false;
                    if (or != null)
                        rright = false;

                    if(board.getAt(x + dy, y - dx) != null)
                        rleft = false;
                    if(board.getAt(x - dy, y + dx) != null)
                        rright = false;

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
