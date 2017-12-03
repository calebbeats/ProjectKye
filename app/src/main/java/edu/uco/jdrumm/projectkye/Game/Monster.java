package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

public class Monster extends Actor
{
    private Monsters m;
    private int[] images;
    private int frame;
    private boolean stopped;

    public Monster(int x, int y, Monsters m)
    {
        super(x, y);
        this.m = m;
        frequency = 3;

        switch(m)
        {
            case GNASHER:
                images = new int[]{R.drawable.gnasher1, R.drawable.gnasher2, R.drawable.gnasher3, R.drawable.gnasher2};
                break;
            case TWISTER:
                images = new int[]{R.drawable.twister1, R.drawable.twister2};
                break;
            case SPIKE:
                images = new int[]{R.drawable.spike1, R.drawable.spike2};
                icon = R.drawable.spike1;
                break;
            case SNAKE:
                images = new int[]{R.drawable.snake1, R.drawable.snake2};
                break;
            default:
                images = new int[]{R.drawable.blob1, R.drawable.blob2, R.drawable.blob3, R.drawable.blob4};
        }

        icon = images[0];
        frame = (int) (Math.random() * images.length);
    }


    @Override
    public void action(GameBoard board)
    {
        BaseObject o = board.getAt(x - 1, y);
        if(o instanceof Kye)
            ((Kye) o).kill(board);
        else
        {
            o = board.getAt(x + 1, y);
            if(o instanceof Kye)
                ((Kye) o).kill(board);
            else
            {
                o = board.getAt(x, y - 1);
                if(o instanceof Kye)
                    ((Kye) o).kill(board);
                else
                {
                    o = board.getAt(x, y + 1);
                    if(o instanceof Kye)
                        ((Kye) o).kill(board);
                }
            }
        }

        if(!stopped)
        {
            boolean wandering;
            int dx, dy;
            dx = dy = 0;
            if (Math.random() < 0.5) {
                wandering = true;
                switch ((int) (Math.random() * 4)) {
                    case 0:
                        dx = -1;
                        break;
                    case 1:
                        dx = 1;
                        break;
                    case 2:
                        dy = -1;
                        break;
                    case 3:
                        dy = 1;
                        break;
                    default:
                        return;
                }
            } else {
                wandering = false;
                Kye k = board.getKye();
                int tx, ty;
                tx = k.getCordX() - x;
                ty = k.getCordY() - y;

                if (ty == 0) {
                    if (tx > 0)
                        dx = 1;
                    else
                        dx = -1;
                } else {
                    if (ty > 0)
                        dy = 1;
                    else
                        dy = -1;
                }
            }

            if (!wandering || !(board.getAt(x + dx, y + dy) instanceof BlackHole))
                board.pushGameObject(this, x + dx, y + dy);
        }
        else
            checkForMagnets(board);

        frame++;
        if(frame >= images.length)
            frame = 0;
        icon = images[frame];
    }

    public void stop()
    {
        stopped = true;
    }

    public void checkForMagnets(GameBoard board)
    {
        BaseObject o = board.getAt(x - 1, y);
        if(o instanceof HorizontalMagnet)
            return;
        o = board.getAt(x + 1, y);
        if(o instanceof HorizontalMagnet)
            return;
        o = board.getAt(x, y - 1);
        if(o instanceof VerticalMagnet)
            return;
        o = board.getAt(x, y + 1);
        if(o instanceof VerticalMagnet)
            return;
        stopped = false;
        //action(board); //Might remove this. This makes it so the piece can take its action right after becoming unstuck
    }

    public enum Monsters
    {
        GNASHER, TWISTER, SPIKE, SNAKE, BLOB
    }
}
