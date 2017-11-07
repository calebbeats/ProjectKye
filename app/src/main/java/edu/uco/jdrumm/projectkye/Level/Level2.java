package edu.uco.jdrumm.projectkye.Level;

/**
 * Created by caleb on 11/5/2017.
 */

public class Level2 extends Level {

    public Level2()
    {
        super();
        setNextLevel(new Level3());
    }


    @Override
    public void createObjects()
    {
        /*
        Kye kye = new Kye(14, 10);
        b.addGameObject(kye);

        BaseObject t = new Diamond(0,0);
        b.addGameObject(t);
        t = new Diamond(0,5);
        b.addGameObject(t);
        t = new Diamond(0,10);
        b.addGameObject(t);
        //t = new Diamond(0,15);
        //b.addGameObject(t);
        */
    }
}
