package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 11/5/2017.
 */

public class Level1  extends Level{

    public Level1(Kye k)
    {
        super(k);
        setNextLevel(new Level2(k));
    }

    @Override
    public void populateBoard(GameBoard b) {
        kye = new Kye(14, 10);
        b.addGameObject(kye, 14, 10);

        BaseObject t = new Diamond(0,0);
        b.addGameObject(t, 0, 0);
        /*
        t = new Diamond(0,19);
        b.addGameObject(t, 0, 19);
        t = new Diamond(29,19);
        b.addGameObject(t, 29, 19);
        t = new Diamond(29,0);
        b.addGameObject(t, 29, 0);
        */
    }
}
