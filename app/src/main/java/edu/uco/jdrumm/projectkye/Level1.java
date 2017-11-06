package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 11/5/2017.
 */

public class Level1  extends Level{

    public Level1()
    {
        super();

        setNextLevel(new Level2());
    }

    @Override
    public void createObjects()
    {
        objects = new BaseObject[] {
                new Kye(13, 1),
                new Diamond(14, 1),
                new FuzzBlock(5, 1),
                new Block(5, 2),
                new Block(5, 3),
                new Block(5, 4),
                new FuzzBlock(5, 5),
                new Block(4, 5),
                new Block(3, 5),
                new Block(2, 5),
                new FuzzBlock(1, 5),
                new Wall(7, 2), //
                new Wall(8, 2),
                new Wall(9, 2),
                new Wall(10, 2),
                new Wall(11, 2),
                new Wall(12, 2), //
                new SquareArrowBlock(7, 3, Direction.DOWN),
                new SquareArrowBlock(7, 4, Direction.DOWN),
                new FuzzBlock(7, 5),
                new FuzzBlock(8, 5),
                new BlockCircle(9, 5),
                new BlockCircle(10, 5),
                new FuzzBlock(11, 5),
                new FuzzBlock(12, 5),
                new SquareArrowBlock(12, 4, Direction.DOWN),
                new SquareArrowBlock(12, 3, Direction.DOWN),
                new Wall(2, 7), //
                new Wall(2, 8),
                new Wall(2, 9),
                new Wall(2, 10),
                new Wall(2, 11),
                new Wall(2, 12), //
                new SquareArrowBlock(3, 7, Direction.RIGHT),
                new SquareArrowBlock(4, 7, Direction.RIGHT),
                new FuzzBlock(5, 7),
                new FuzzBlock(5, 8),
                new BlockCircle(5, 9),
                new BlockCircle(5, 10),
                new FuzzBlock(5, 11),
                new FuzzBlock(5, 12),
                new SquareArrowBlock(4, 12, Direction.RIGHT),
                new SquareArrowBlock(3, 12, Direction.RIGHT),
                new FuzzBlock(5, 18),
                new Block(5, 15),
                new Block(5, 16),
                new Block(5, 17),
                new FuzzBlock(5, 14),
                new Block(4, 14),
                new Block(3, 14),
                new Block(2, 14),
                new FuzzBlock(1, 14),
                new Wall(7, 17), //
                new Wall(8, 17),
                new Wall(9, 17),
                new Wall(10, 17),
                new Wall(11, 17),
                new Wall(12, 17), //
                new SquareArrowBlock(7, 16, Direction.UP),
                new SquareArrowBlock(7, 15, Direction.UP),
                new FuzzBlock(7, 14),
                new FuzzBlock(8, 14),
                new BlockCircle(9, 14),
                new BlockCircle(10, 14),
                new FuzzBlock(11, 14),
                new FuzzBlock(12, 14),
                new SquareArrowBlock(12, 15, Direction.UP),
                new SquareArrowBlock(12, 16, Direction.UP),
                new FuzzBlock(24, 1),
                new Block(24, 2),
                new Block(24, 3),
                new Block(24, 4),
                new FuzzBlock(24, 5),
                new Block(25, 5),
                new Block(26, 5),
                new Block(27, 5),
                new FuzzBlock(28, 5),
                new FuzzBlock(24, 18),
                new Block(24, 15),
                new Block(24, 16),
                new Block(24, 17),
                new FuzzBlock(24, 14),
                new Block(25, 14),
                new Block(26, 14),
                new Block(27, 14),
                new FuzzBlock(28, 14),
                new Wall(27, 7), //
                new Wall(27, 8),
                new Wall(27, 9),
                new Wall(27, 10),
                new Wall(27, 11),
                new Wall(27, 12), //
                new SquareArrowBlock(26, 7, Direction.LEFT),
                new SquareArrowBlock(25, 7, Direction.LEFT),
                new FuzzBlock(24, 7),
                new FuzzBlock(24, 8),
                new BlockCircle(24, 9),
                new BlockCircle(24, 10),
                new FuzzBlock(24, 11),
                new FuzzBlock(24, 12),
                new SquareArrowBlock(25, 12, Direction.LEFT),
                new SquareArrowBlock(26, 12, Direction.LEFT),
                new FuzzBlock(15, 18),
                new Wall(15, 17),
                new Wall(15, 16),
                new Wall(15, 15),
                new Wall(15, 14), //
                new Wall(16, 14),
                new Wall(17, 14),
                new Wall(18, 14),
                new Wall(19, 14),
                new Wall(20, 14),
                new Wall(21, 14), //
                new Wall(21, 15),
                new Wall(21, 16),
                new Wall(21, 17),
                new FuzzBlock(21, 18),
                new Rotator(16, 6, Rotation.CLOCKWISE),
                new Rotator(17, 1, Rotation.CLOCKWISE),
                new Rotator(21, 2, Rotation.CLOCKWISE),
                new Rotator(20, 5, Rotation.COUNTER_CLOCKWISE),
                new Rotator(23, 4, Rotation.CLOCKWISE),
                new Rotator(22, 7, Rotation.CLOCKWISE),
                new SquareArrowBlock(22, 1, Direction.DOWN),
                new Block(21, 13),
                new Block(21, 12),
                new Block(21, 10),
                new Block(20, 13),
                new Block(18, 13),
                new VerticalMagnet(12, 8),
                new HorizontalMagnet(15, 8),
                new VerticalMagnet(12, 11),
                new HorizontalMagnet(15, 11)
        };

    }
}
