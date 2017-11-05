package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 11/5/2017.
 */

public class Level3 extends Level {
    public Level3() {
        super();
    }

    @Override
    public void populateBoard(GameBoard b) {
        Kye kye = new Kye(14, 10);
        b.addGameObject(kye, 14, 10);

        BaseObject t = new Block(13,10);
        b.addGameObject(t, 13, 10);
        t = new Block(15,10);
        b.addGameObject(t, 15, 10);
        t = new Block(14,11);
        b.addGameObject(t, 14, 11);
        t = new Block(14,9);
        b.addGameObject(t, 14, 9);


        t = new Diamond(0,15);
        b.addGameObject(t, 0, 15);
    }
}
