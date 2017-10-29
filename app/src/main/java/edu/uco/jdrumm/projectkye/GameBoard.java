package edu.uco.jdrumm.projectkye;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.provider.Settings;

import java.util.ArrayList;

import javax.security.auth.Destroyable;

/**
 * Created by caleb on 10/23/2017.
 */

public class GameBoard {

    public BaseObject[][] board;
    public Level currentLevel;
    public Level nextLevel;

    private Kye kye;
    private ArrayList<BaseObject> gameObjects, currentMagnetized;

    public GameBoard()
    {
        board = new BaseObject[30][20];
        gameObjects = new ArrayList<>();
        kye = new Kye(0, 0);
        addGameObject(kye, 0, 0);
        for(int i = 0; i < 30; i++)
            for(int j = 0; j < 20; j++)
            {
                if(i == 0 && j == 0)
                    i++;
                if(Math.random() < 0.3)
                {
                    BaseObject o = new Kye(0, 0);
                    int rand = (int) (Math.random() * 6);
                    switch (rand) {
                        case 0:
                            o = new Diamond(i, j);
                            break;
                        case 1:
                            o = new WallBlock(i, j);
                            break;
                        case 2:
                            int r = (int) (Math.random() * 3);
                            if (r == 0)
                                o = new Block(i, j);
                            else if (r == 1)
                                o = new BlockCircle(i, j);
                            else
                                o = new FuzzBlock(i, j);
                            break;
                        case 3:
                            if (Math.random() > 0.5)
                                o = new HorizontalMagnet(i, j);
                            else
                                o = new VerticalMagnet(i, j);
                            break;
                        case 4:
                            o = new SquareArrowBlock(i, j, getRandomDirection());
                            break;
                        case 5:
                            o = new Rotator(i, j, getRandomRotation());
                    }
                    addGameObject(o, i, j);
                }
            }
    }

    private Direction getRandomDirection()
    {
        int i = (int) (Math.random() * 4);
        switch(i)
        {
            case 0:
                return Direction.UP;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.DOWN;
            default:
                return Direction.LEFT;

        }
    }

    private Rotation getRandomRotation()
    {
        if(Math.random() < 0.5)
            return Rotation.CLOCKWISE;
        return Rotation.COUNTER_CLOCKWISE;
    }

    public void clearBoard()
    {
        for(int i = 0; i < 30; i++)
            for(int j = 0; j < 20; j++)
                board[i][j] = null;
    }

    public void addGameObject(BaseObject obj, int cordX, int cordY)
    {
        board[cordX][cordY] = obj;
        if(!(obj instanceof WallBlock) && !(obj instanceof Kye))
            gameObjects.add(obj);
    }

    public void loadLevel()
    {
        currentLevel.populateBoard(this);
    }

    public void setCurrentLevel(Level l)
    {
        currentLevel = l;
    }

    public void setNextLevel(Level l)
    {
        nextLevel = l;
    }

    public void draw(Canvas canvas, Resources resources)
    {
        for(int i = 0; i < 30; i++)
            for(int j = 0; j < 20; j++)
                if(board[i][j] != null)
                    canvas.drawBitmap(BitmapFactory.decodeResource(resources, board[i][j].getIcon()), i * 42, j * 42, new Paint());
    }

    public Kye getKye()
    {
        return kye;
    }

    private boolean moveGameObject(BaseObject o, int cordX, int cordY)
    {
        if(!inBounds(cordX, cordY))
            return false;
        BaseObject o2 = board[cordX][cordY];
        if(o2 instanceof WallBlock || o2 instanceof Kye)
            return false;
        if(!validMove(o, o2))
            return false;
        boolean val = true;
        if(o2 instanceof Moveable)
            val = moveGameObject(board[cordX][cordY], o.getCordX() - 2 * (o.getCordX() - cordX), o.getCordY() - 2 * (o.getCordY() - cordY));
        if(!val)
            return false;
        board[o.getCordX()][o.getCordY()] = null;
        o.setCordX(cordX);
        o.setCordY(cordY);
        board[cordX][ cordY] = o;
        return true;
    }

    private boolean validMove(BaseObject o, BaseObject o2)
    {
        String s1, s2;
        if(o != null)
            s1 = o.getClass().toString();
        else
            s1 = "NULL";

        if(o2 != null)
            s2 = o2.getClass().toString();
        else
            s2 = "NULL";

        System.out.println(s1 + " " + s2);

        if((o2 instanceof edu.uco.jdrumm.projectkye.Destroyable) && !(o instanceof Kye))
            return false;
        return true;
    }

    public void move(Direction d)
    {
        int dx = 0, dy = 0;
        switch(d)
        {
            case UP:
                dy = -1;
                break;
            case RIGHT:
                dx = 1;
                break;
            case DOWN:
                dy = 1;
                break;
            default:
                dx = -1;
        }

        moveGameObject(kye, kye.getCordX() + dx, kye.getCordY() + dy);

    }

    public boolean inBounds(int cordX, int cordY)
    {
        return cordX >= 0 && cordX <= 29 && cordY >= 0 && cordY <= 19;
    }

    public boolean isEmpty(int cordX, int cordY)
    {
        return board[cordX][cordY] == null;
    }

    public void updateGameObjects()
    {
        currentMagnetized = new ArrayList<>(16);

        for(int i = 0; i < gameObjects.size(); i++)
        {
            BaseObject o = gameObjects.get(i);
            if(o instanceof HorizontalMagnet)
            {
                BaseObject left = null, right = null;
                int x = o.getCordX(), y = o.getCordY();
                if(inBounds(x - 2, y))
                    left = board[x - 2][y];
                if(inBounds(x + 2, y))
                    right = board[x + 2][y];

                if(left != null && left instanceof Moveable && !(left instanceof HorizontalMagnet) && !currentMagnetized.contains(left))
                {
                    moveGameObject(left, x - 1, y);
                    currentMagnetized.add(left);
                }

                if(right != null && right instanceof Moveable && !(right instanceof HorizontalMagnet) && !currentMagnetized.contains(right))
                {
                    moveGameObject(right, x + 1, y);
                    currentMagnetized.add(right);
                }
            }

            if(o instanceof VerticalMagnet)
            {
                BaseObject up = null, down = null;
                int x = o.getCordX(), y = o.getCordY();
                if(inBounds(x, y - 2))
                    up = board[x][y - 2];
                if(inBounds(x , y + 2))
                    down = board[x][y + 2];

                if(up != null && up instanceof Moveable && !(up instanceof VerticalMagnet) && !currentMagnetized.contains(up))
                {
                    moveGameObject(up, x, y - 1);
                    currentMagnetized.add(up);
                }

                if(down != null && down instanceof Moveable && !(down instanceof VerticalMagnet) && !currentMagnetized.contains(down))
                {
                    moveGameObject(down, x, y + 1);
                    currentMagnetized.add(down);
                }
            }

            if(o instanceof SquareArrowBlock)
            {
                int dx = 0, dy = 0;
                switch(((SquareArrowBlock)o).getDirection())
                {
                    case UP:
                        dy = -1;
                        break;
                    case RIGHT:
                        dx = 1;
                        break;
                    case DOWN:
                        dy = 1;
                        break;
                    default:
                        dx = -1;
                }
                int x = o.getCordX() + dx, y = o.getCordY() + dy;
                if(!moveGameObject(o, x, y))
                {
                    if(inBounds(x, y) && board[x][y] instanceof Rotator)
                    {
                        Rotator r = (Rotator) board[x][y];
                        ((SquareArrowBlock)o).rotate(r.getRotation());
                    }
                }
            }
        }
    }
}


