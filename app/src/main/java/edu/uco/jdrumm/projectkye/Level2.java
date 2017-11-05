package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 11/5/2017.
 */

public class Level2 extends Level {

    public Level2(Kye k)
    {
        super(k);
        setNextLevel(new Level3(k));
    }


    @Override
    public void populateBoard(GameBoard b) {
        kye = new Kye(14, 10);
        b.addGameObject(kye, 14, 10);

        BaseObject t = new Diamond(0,0);
        b.addGameObject(t, 0, 0);
        t = new Diamond(0,5);
        b.addGameObject(t, 0, 5);
        t = new Diamond(0,10);
        b.addGameObject(t, 0, 10);
        t = new Diamond(0,15);
        b.addGameObject(t, 0, 15);
    }
}
