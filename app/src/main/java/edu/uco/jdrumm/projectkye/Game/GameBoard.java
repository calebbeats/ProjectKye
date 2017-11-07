package edu.uco.jdrumm.projectkye.Game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.HashMap;

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;
import edu.uco.jdrumm.projectkye.Level.Level;
import edu.uco.jdrumm.projectkye.Level.Level1;
import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 10/23/2017.
 */

public class GameBoard {

    public BaseObject[][] board;
    public Level currentLevel;
    public Level nextLevel;
    public ArrayList<Direction> inputQueue;
    private Paint paint;

    public boolean levelFinished;


    private Kye kye;
    private ArrayList<BaseObject> gameObjects, currentMagnetized;
    private ArrayList<Actor> actors, actorsRemoved;

    private final int IMAGE_SIZE = 48;
    private double factor;

    private int actualSize;
    private Resources resources;

    HashMap<Integer, Bitmap> hm;

    private final int[] images =
            {
                    R.drawable.block,
                    R.drawable.block2,
                    R.drawable.block3,
                    R.drawable.diamond,
                    R.drawable.kye,
                    R.drawable.magnethorizontal,
                    R.drawable.magnetvertical,
                    R.drawable.monster1,
                    R.drawable.rotatorclockwise,
                    R.drawable.rotatorcounterclockwise,
                    R.drawable.roundslideru,
                    R.drawable.roundsliderr,
                    R.drawable.roundsliderd,
                    R.drawable.roundsliderl,
                    R.drawable.sentryu,
                    R.drawable.sentryr,
                    R.drawable.sentryd,
                    R.drawable.sentryl,
                    R.drawable.squarrowu,
                    R.drawable.squarrowr,
                    R.drawable.squarrowd,
                    R.drawable.squarrowl,
                    R.drawable.wall1,
                    R.drawable.wall2,
                    R.drawable.wall3,
                    R.drawable.wall4,
                    R.drawable.wall5,
                    R.drawable.wall6,
                    R.drawable.wall7,
                    R.drawable.wall8,
                    R.drawable.wall9
            };

    public GameBoard(int i, Resources resources, float density)
    {
        this.resources = resources;

        levelFinished = false;
        board = new BaseObject[30][20];
        gameObjects = new ArrayList<>();
        actors = new ArrayList<>();
        actorsRemoved = new ArrayList<>();
        inputQueue = new ArrayList<>();
        if(i == 0)
        {
            currentLevel = new Level1();
        }
        paint = new Paint();
        factor = IMAGE_SIZE * 16.0 / 42;

        actualSize = (int) Math.ceil(factor * density);
        hm = new HashMap<Integer, Bitmap>();

        for(int image : images)
            addToHashMap(image);
    }

    private void addToHashMap(int id)
    {
        hm.put(id, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, id), actualSize, actualSize, true));
    }

    public Direction getRandomDirection()
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

    public Rotation getRandomRotation()
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

        actors = new ArrayList<Actor>();
        actorsRemoved = new ArrayList<Actor>();
        gameObjects = new ArrayList<BaseObject>();

    }

    public void addGameObject(BaseObject obj)
    {
        if(board[obj.getCordX()][obj.getCordY()] != null)
            return;
        board[obj.getCordX()][obj.getCordY()] = obj;
        if(!(obj instanceof Wall))
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

    public void draw(Canvas canvas, Resources resources, float density, int displayWidth, int displayHeight)
    {
        int xOffset = displayWidth / 2 - 15 * actualSize;
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 20; j++)
                if (board[i][j] != null)
                    canvas.drawBitmap(hm.get(board[i][j].getIcon()), xOffset + actualSize * i, actualSize * j, paint);
    }

    public Kye getKye()
    {
        return kye;
    }

    public boolean pushGameObject(BaseObject o, int cordX, int cordY)
    {
        return moveGameObject(o, cordX, cordY, 1);
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
        if(o2 instanceof Wall || o2 instanceof Kye)
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
            actorsRemoved.add((Actor) o);
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

        if((o2 instanceof Destroyable) && !(o instanceof Kye))
            return false;

        if(o instanceof SquareSlider && o2 instanceof Rotator)
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
        for (Actor a : actors)
            if(!actorsRemoved.contains(a))
                a.act(this);

        for(Actor a : actorsRemoved)
            actors.remove(a);

        levelFinished  = true;
        for(int i = 0; i < gameObjects.size(); i++) {
            BaseObject o = gameObjects.get(i);
            if (o instanceof Diamond) {
                levelFinished = false;

            }
        }

        if(levelFinished)
        {
            this.clearBoard();
            currentLevel.getNextLevel().populateBoard(this);
            currentLevel = currentLevel.getNextLevel();
        }
    }
}


