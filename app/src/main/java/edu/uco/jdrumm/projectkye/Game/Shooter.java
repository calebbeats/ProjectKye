package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;
import edu.uco.jdrumm.projectkye.R;

public abstract class Shooter extends ActorRotatable implements Moveable
{
    private int shootTick;
    public Shooter(int x, int y, Direction d)
    {
        super(x, y, d);
        shootTick = 0;
        frequency = 7;
    }

    @Override
    public void action(GameBoard board)
    {
        rotate(Rotation.COUNTER_CLOCKWISE);
        if(shootTick < 3)
            shootTick++;
        else if(shoot(board))
            shootTick = 0;
    }

    private boolean shoot(GameBoard board)
    {
        BaseObject b = board.getAt(x + dx, y + dy);
        if(b != null)
            return false;
        b = getNewShootObject();
        board.addGameObject(b);
        return true;
    }

    protected abstract BaseObject getNewShootObject();
}
