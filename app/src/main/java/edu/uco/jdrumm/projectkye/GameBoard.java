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
    public ArrayList<Direction> inputQueue;

    public boolean levelFinished;


    private Kye kye;
    private ArrayList<BaseObject> gameObjects, currentMagnetized;
    private ArrayList<Actor> actors;

    public GameBoard()
    {
        levelFinished = false;
        board = new BaseObject[30][20];
        gameObjects = new ArrayList<>();
        actors = new ArrayList<>();
        inputQueue = new ArrayList<>();
        kye = new Kye(1, 1);
        addGameObject(kye, 1, 1);
        BaseObject t = new Diamond(1,2);
        addGameObject(t, 1, 2);
        //addGameObject(new SquareArrowBlock(29, 19, Direction.LEFT), 29, 19);

        for(int i = 0; i < 30; i++)
        {
            addGameObject(new Rotator(i, 0, Rotation.COUNTER_CLOCKWISE), i, 0);
            addGameObject(new Rotator(i, 19, Rotation.COUNTER_CLOCKWISE), i, 19);
        }
        for(int i = 1; i < 19; i++)
        {
            addGameObject(new Rotator(0, i, Rotation.COUNTER_CLOCKWISE), 0, i);
            addGameObject(new Rotator(29, i, Rotation.COUNTER_CLOCKWISE), 29, i);
        }
        for(int i = 1; i < 29; i++)
            for(int j = 1; j < 19; j++)
            {
                if(i == 0 && j == 0)
                    i++;
                if(Math.random() < 0.1)
                {
                    BaseObject o = new Kye(0, 0);
                    int rand = (int) (Math.random() * 6);
                    switch (rand) {
                        case 0:
                            o = new Block(i, j);
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
        if(board[cordX][cordY] != null)
            return;
        board[cordX][cordY] = obj;
        if(!(obj instanceof WallBlock))
        {
            gameObjects.add(obj);
            if(obj instanceof Actor)
                actors.add((Actor) obj);
        }
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

    public void draw(Canvas canvas, Resources resources, float density)
    {
        for(int i = 0; i < 30; i++)
            for(int j = 0; j < 20; j++)
                if(board[i][j] != null)
                    canvas.drawBitmap(BitmapFactory.decodeResource(resources, board[i][j].getIcon()), i * density * 16, j * density * 16, new Paint());
    }

    public Kye getKye()
    {
        return kye;
    }

    public boolean moveGameObject(BaseObject o, int cordX, int cordY)
    {
        return moveGameObject(o, cordX, cordY, 0);
    }

    private boolean moveGameObject(BaseObject o, int cordX, int cordY, int depth)
    {
        if(!inBounds(cordX, cordY) || depth >= 2)
            return false;
        BaseObject o2 = board[cordX][cordY];
        if(o2 instanceof WallBlock || o2 instanceof Kye)
            return false;
        if(!validMove(o, o2))
            return false;
        boolean val = true;
        if(o2 instanceof Moveable)
            val = moveGameObject(board[cordX][cordY], o.getCordX() - 2 * (o.getCordX() - cordX), o.getCordY() - 2 * (o.getCordY() - cordY), ++depth);
        if(!val)
            return false;
        board[o.getCordX()][o.getCordY()] = null;
        o.setCordX(cordX);
        o.setCordY(cordY);
        replaceGameObject(o, cordX, cordY);
        return true;
    }

    private void replaceGameObject(BaseObject o, int cordX, int cordY)
    {
        BaseObject remove = board[cordX][cordY];
        gameObjects.remove(remove);
        if(remove instanceof Actor)
            actors.remove((Actor) remove);
        board[cordX][cordY] = o;
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

        if((o2 instanceof edu.uco.jdrumm.projectkye.Destroyable) && !(o instanceof Kye))
            return false;

        if(o instanceof SquareArrowBlock && o2 instanceof Rotator)
            return false;

        return true;
    }

    public void pushToInputQueue(Direction d)
    {
        inputQueue.add(d);
    }

    public Direction popFromInputQueue()
    {
        if(inputQueue.size() > 0)
        {
            Direction d = inputQueue.get(0);
            inputQueue.remove(0);
            return d;
        }
        return null;
    }

    public boolean inBounds(int cordX, int cordY)
    {
        return cordX >= 0 && cordX <= 29 && cordY >= 0 && cordY <= 19;
    }

    public boolean isFinished()
    {
        return levelFinished;
    }

    public boolean isEmpty(int cordX, int cordY)
    {
        return board[cordX][cordY] == null;
    }

    public BaseObject getAt(int x, int y)
    {
        if(inBounds(x, y))
            return board[x][y];
        return null;
    }

    public void updateGameObjects()
    {
        for(Actor a : actors)
        {
            a.act(this);
        }
        /*
        currentMagnetized = new ArrayList<>(16);

        levelFinished = true;
        System.out.println("Level Finished : " + levelFinished);

        for(int i = 0; i < gameObjects.size(); i++)
        {
            BaseObject o = gameObjects.get(i);
            if(o instanceof Diamond)
            {
                levelFinished = false;
                System.out.println("Level Finished : " + levelFinished);
            }
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
        */
    }
}


