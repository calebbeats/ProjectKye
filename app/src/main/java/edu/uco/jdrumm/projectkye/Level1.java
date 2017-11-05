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

        t = new SquareArrowBlock(23, 9, Direction.LEFT);
        b.addGameObject(t, 23, 9);

        t = new Rotator(15, 9, Rotation.CLOCKWISE);
        b.addGameObject(t, 15, 9);

        t = new Rotator(16, 0, Rotation.CLOCKWISE);
        b.addGameObject(t, 16, 0);

        t = new Rotator(21, 1, Rotation.CLOCKWISE);
        b.addGameObject(t, 21, 1);

        t = new Rotator(20, 4, Rotation.COUNTER_CLOCKWISE);
        b.addGameObject(t, 20, 4);

        t = new Rotator(25, 3, Rotation.CLOCKWISE);
        b.addGameObject(t, 25, 3);

        t = new Rotator(24, 10, Rotation.CLOCKWISE);
        b.addGameObject(t, 24, 10);

        t = new HorizontalMagnet(16, 14);
        b.addGameObject(t, 16, 14);

        t = new Block(15, 14);
        b.addGameObject(t, 15, 14);

        t = new VerticalMagnet(12, 14);
        b.addGameObject(t, 12, 14);

        t = new Block(12, 15);
        b.addGameObject(t, 12, 15);
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
