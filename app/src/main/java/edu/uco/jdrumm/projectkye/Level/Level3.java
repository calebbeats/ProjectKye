package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Block;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.Sentry;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;

public class Level3 extends Level
{
    public Level3()
    {
        super();
        setNextLevel(new Level4());
        levelMessage = "Well done, that one was a bit harder";
        levelName = "Slider";
    }

    @Override
    public void createObjects() {
        objects = new BaseObject[]{

                // ROW 1
                new Diamond(1,1),
                new RoundSlider(2, 1, Direction.DOWN),
                new RoundSlider(3, 1, Direction.DOWN),
                new RoundSlider(4, 1, Direction.DOWN),
                new RoundSlider(5, 1, Direction.DOWN),
                new RoundSlider(6, 1, Direction.DOWN),
                new RoundSlider(7, 1, Direction.DOWN),
                new Wall(8,1),
                // (9,1)
                // (10,1)
                new SquareSlider(11,1,Direction.RIGHT),
                new FuzzBlock(12,1),
                // (13,1)
                // (14,1)
                new Wall(15,1),
                // (16,1)
                // (17,1)
                // (18,1)
                new FuzzBlock(19,1),

                new Kye(21,1),
                // (22,1)
                new Wall(23,1),
                new Block(25,1),
                // (26,1)
                // (27,1)
                new Diamond(28,1),

                //ROW 2
                new Wall(1, 2, 9),
                new RoundSlider(2, 2, Direction.DOWN),
                new RoundSlider(3, 2, Direction.DOWN),
                new RoundSlider(4, 2, Direction.DOWN),
                new RoundSlider(5, 2, Direction.DOWN),
                new RoundSlider(6, 2, Direction.DOWN),
                new Wall(7, 2, 7),
                new Wall(8, 2, 3),
                // (9,2)
                // (10,2)
                new SquareSlider(11,2,Direction.RIGHT),
                new FuzzBlock(12,2),
                // (13,2)
                // (14,2)
                new Wall(15,2),
                new Wall(16,2, 6),
                // (17,2)
                // (18,2)
                new Wall(19,2),
                // (20,2)
                // (21,2)
                // (22,2)
                new Wall(23,2),
                new Block(24,2),
                // (25,2)
                // (26,2)
                new Block(27,2),
                new Block(28,2),

                //ROW 3
                new Wall(1,3),
                new Wall(2, 3, 9),
                new RoundSlider(3, 3, Direction.DOWN),
                new RoundSlider(4, 3, Direction.DOWN),
                new RoundSlider(5, 3, Direction.DOWN),
                new Wall(6, 3, 7),
                new Wall(7, 3, 3),
                // (8,3),
                // (9,3),
                // (10,3),
                new SquareSlider(11,3,Direction.RIGHT),
                new FuzzBlock(12,3),
                // (13,3),
                // (14,3),
                new Wall(15,3),
                // (16,3),
                // (17,3)
                // (18,3)
                new Wall(19,3),
                // (20,3)
                new Wall(21,3, 7),
                new Wall(22,3),
                new Wall(23,3),
                // (24,3),
                // (25,3)
                new Block(26,3),
                // Block(27,3),
                // Block(28,3)

                //ROW 4
                //(1,4),
                new Wall(2, 4),
                new Wall(3, 4, 9),
                new RoundSlider(4, 4, Direction.DOWN),
                new Wall(5, 4, 7),
                new Wall(6, 4, 3),
                // (7,4),
                // (8,4),
                // (9,4),
                // (10,4),
                new SquareSlider(11,4,Direction.RIGHT),
                new FuzzBlock(12,4),
                // (13,4),
                // (14,4),
                new Wall(15,4),
                new FuzzBlock(16,4),
                new Wall(17,4, 4),
                new Wall(18,4),
                new Wall(19,4),
                // (20,4)
                new Wall(21,4),
                //(22,4),
                new Wall(23,4),
                // (24,4),
                new Block(25,4),
                new Block(26,4),
                // Block(27,4),
                // Block(28,4)

                //ROW 5
                //(1,5),
                //(2, 5),
                new Wall(3, 5, 2),
                new RoundSlider(4, 5, Direction.DOWN),
                new Wall(5, 5, 2),
                //(6, 5),
                // (7,5),
                // (8,5),
                // (9,5),
                // (10,5),
                new SquareSlider(11,5,Direction.RIGHT),
                new FuzzBlock(12,5),
                // (13,5),
                // (14,5),
                new Wall(15,5),
                new RoundSlider(16,5,Direction.UP),
                new RoundSlider(17,5,Direction.UP),
                new RoundSlider(18,5,Direction.UP),
                new Wall(19,5),
                // (20,5)
                new Wall(21,5),
                //(22,4),
                new Wall(23,5),
                new Block(24,5),
                //(25,5)
                //(26,5),
                // (27,5),
                // (28,5)

                //ROW 6
                new Sentry(1,6,Direction.RIGHT),
                //(2, 6),
                //(3, 6),
                new RoundSlider(4, 6, Direction.DOWN),
                new FuzzBlock(5, 6),
                //(6, 6),
                // (7,6),
                new Wall(8, 6, 8),
                // (9,6),
                // (10,6),
                new SquareSlider(11,6,Direction.RIGHT),
                new FuzzBlock(12,6),
                // (13,6),
                // (14,6),
                new Wall(15,6),
                new Wall(16,6, 6),
                //(17,6),
                //(18,6),
                new Wall(19,6),
                // (20,6)
                new Wall(21,6),
                //(22,6),
                new Wall(23,6),
                new Wall(24,6),
                new Wall(25,6),
                //(26,6),
                new Wall(27,6),
                new Wall(28,6),

                //ROW 7
                new Wall(1,7),
                new Wall(2, 7),
                new Wall(3, 7),
                new Wall(4, 7),
                new Wall(5, 7, 9),
                new FuzzBlock(6, 7),
                new Wall(7, 7, 1),
                new Wall(8, 7),
                new Wall(9, 7),
                new Wall(10, 7, 9),
                new SquareSlider(11,7,Direction.RIGHT),
                new FuzzBlock(12,7),
                // (13,7),
                // (14,7),
                new Wall(15,7),
                // (16,7),
                //(17,7),
                //(18,7),
                new Wall(19,7),
                // (20,7)
                new Wall(21,7),
                //(22,7),
                //(23,7),
                new FuzzBlock(24,7),
                //(25,7),
                //(26,7),
                //(27,7),
                //(28,7),

                //ROW 8
                //(1,8),
                new Wall(2, 8),
                new Sentry(3, 8,Direction.RIGHT),
                //(4, 8),
                //(5, 8),
                //(6, 8),
                //(7,8),
                //(8,8),
                //(9,8),
                new Wall(10,8),
                new SquareSlider(11,8,Direction.RIGHT),
                new FuzzBlock(12,8),
                // (13,8),
                // (14,8),
                new Wall(15,8),
                new FuzzBlock(16,8),
                new Wall(17,8, 4),
                new Wall(18,8),
                new Wall(19,8),
                // (20,8)
                new Wall(21,8),
                //(22,8),
                new Wall(23,8),
                new SquareSlider(24,8,Direction.UP),
                new Wall(25,8),
                //(26,8),
                //(27,8),
                //(28,8)

                //ROW 9
                //(1,9),
                new Wall(2, 9),
                new Wall(3, 9),
                new Wall(4, 9),
                new Wall(5, 9),
                new Wall(6, 9),
                new Wall(7, 9, 9),
                new FuzzBlock(8,9),
                new Wall(9, 9, 1),
                new Wall(10, 9),
                new Wall(11, 9),
                new Wall(12, 9),
                new Wall(13, 9),
                // (14,9),
                new Wall(15,9),
                new RoundSlider(16,9,Direction.UP),
                new RoundSlider(17,9,Direction.UP),
                new RoundSlider(18,9,Direction.UP),
                new Wall(19,9),
                // (20,9)
                new Wall(21,9),
                //(22,9),
                new Wall(23,9),
                new SquareSlider(24,9,Direction.UP),
                new Wall(25,9),
                new Wall(26,9),
                new Wall(27,9),
                new Wall(28,9),

                //ROW 10
                //(1,10),
                //(2, 10),
                new Wall(3, 10),
                //(4, 10),
                //(5, 10),
                new FuzzBlock(6, 10),
                new FuzzBlock(7,10),
                new FuzzBlock(8,10),
                new FuzzBlock(9,10),
                new FuzzBlock(10,10),
                //(11,10),
                //(12,10),
                new Wall(13,10),
                // (14,10),
                new Wall(15,10),
                new Wall(16,10, 6),
                //(17,10),
                //(18,10),
                new Wall(19,10),
                // (20,10)
                new Wall(21,10),
                //(22,10),
                new Wall(23,10),
                new SquareSlider(24,10,Direction.UP),
                new SquareSlider(25,10,Direction.UP),
                new Sentry(26,10, Direction.RIGHT),
                //(27,10),
                //(28,10),

                //ROW 11
                //(1,11),
                //(2, 11),
                new Wall(3, 11),
                //(4, 11),
                //(5, 11),
                //(6,11),
                //(7,11),
                new Wall(8,11, 8),
                //(9,11),
                //(10,11),
                //(11,11),
                //(12,11),
                new Wall(13,11),
                // (14,11),
                new Wall(15,11),
                //(16,11),
                //(17,11),
                //(18,11),
                new Wall(19,11),
                // (20,11)
                new Wall(21,11),
                //(22,11),
                new Wall(23,11, 1),
                new Wall(24,11),
                new SquareSlider(25,11,Direction.UP),
                //(26,11),
                //(27,11),
                //(28,11),

                //ROW 12
                //(1,12),
                //(2, 12),
                new Wall(3, 12),
                //(4, 12),
                //(5, 12),
                //(6,12),
                //(7,12),
                new Wall(8,12),
                //(9,12),
                //(10,12),
                //(11,12),
                //(12,12),
                new Wall(13,12),
                // (14,12),
                new Wall(15,12),
                new FuzzBlock(16,12),
                new Wall(17,12, 4),
                new Wall(18,12),
                new Wall(19,12),
                // (20,12)
                new Wall(21,12),
                //(22,12),
                //(23,12),
                new Wall(24,12),
                new SquareSlider(25,12,Direction.UP),
                //(26,12),
                //(27,12),
                //(28,12),

                //ROW 13
                //(1,13),
                //(2, 13),
                new Wall(3, 13),
                //(4, 13),
                //(5, 13),
                //(6,13),
                //(7,13),
                new Wall(8,13),
                //(9,13),
                //(10,13),
                //(11,13),
                //(12,13),
                new Wall(13,13),
                // (14,13),
                new Wall(15,13),
                //(16,13),
                //(17,13),
                //(18,13),
                new Wall(19,13),
                // (20,13)
                new Wall(21,13),
                new FuzzBlock(22,13),
                new RoundSlider(23,13,Direction.LEFT),
                new Wall(24,13),
                new SquareSlider(25,13,Direction.UP),
                //(26,13),
                //(27,13),
                //(28,13),

                //ROW 14
                //(1,14),
                //(2, 14),
                new Wall(3, 14),
                //(4, 14),
                //(5, 14),
                //(6,14),
                new Wall(7,14, 7),
                new Wall(8,14),
                new Wall(9,14, 9),
                //(10,14),
                //(11,14),
                //(12,14),
                new Wall(13,14),
                // (14,14),
                new Wall(15,14),
                new Wall(16,14, 6),
                new FuzzBlock(17,14),
                new FuzzBlock(18,14),
                new Wall(19,14),
                // (20,14)
                new Wall(21,14),
                new FuzzBlock(22,14),
                new RoundSlider(23,14,Direction.LEFT),
                new Wall(24,14),
                new SquareSlider(25,14,Direction.UP),
                //(26,14),
                //(27,14),
                //(28,14),

                //ROW 15
                //(1,15),
                //(2, 15),
                new Wall(3, 15),
                new Wall(4, 15, 6),
                new FuzzBlock(5, 15),
                new Wall(6,15, 4),
                new Wall(7,15),
                //(8,15),
                new Wall(9,15),
                new Wall(10,15, 6),
                new FuzzBlock(11,15),
                new Wall(12,15, 4),
                new Wall(13,15),
                // (14,15),
                new Wall(15,15),
                new RoundSlider(16,15, Direction.UP),
                new RoundSlider(17,15, Direction.UP),
                new RoundSlider(18,15, Direction.UP),
                new Wall(19,15),
                // (20,15)
                new Wall(21,15),
                new FuzzBlock(22,15),
                new RoundSlider(23,15,Direction.LEFT),
                new Wall(24,15),
                new SquareSlider(25,15,Direction.UP),
                //(26,15),
                //(27,15),
                //(28,15),

                //ROW 16
                //(1,16),
                //(2, 16),
                //(3, 16),
                //(4, 16),
                //(5, 16),
                //(6,16),
                //(7,16),
                //(8,16),
                //(9,16),
                //(10,16),
                //(11,16),
                //(12,16),
                //(13,16),
                // (14,16),
                new Wall(15,16),
                new RoundSlider(16,16, Direction.UP),
                new RoundSlider(17,16, Direction.UP),
                new RoundSlider(18,16, Direction.UP),
                new Wall(19,16),
                // (20,16)
                new Wall(21,16),
                new FuzzBlock(22,16),
                new RoundSlider(23,16,Direction.LEFT),
                new Wall(24,16),
                //(25,16),
                //(26,16),
                //(27,16),
                //(28,16),

                //ROW 17
                new Wall(1,17),
                new FuzzBlock(2, 17),
                new FuzzBlock(3, 17),
                new Wall(4, 17),
                new Wall(5, 17),
                new Wall(6,17),
                new Wall(7,17),
                new Wall(8,17),
                new Wall(9,17),
                new Wall(10,17),
                new Wall(11,17),
                new Wall(12,17),
                new Wall(13,17),
                new Wall(14,17),
                new Wall(15,17),
                new RoundSlider(16,17, Direction.UP),
                new RoundSlider(17,17, Direction.UP),
                new RoundSlider(18,17, Direction.UP),
                new Wall(19,17),
                // (20,17)
                new Wall(21,17),
                //(22,17),
                //(23,17),
                new Wall(24,17),
                //(25,17),
                //(26,17),
                //(27,17),
                //(28,17),

                //ROW 18
                new Diamond(1,18),
                new FuzzBlock(2, 18),
                new FuzzBlock(3, 18),
                new FuzzBlock(4, 18),
                new FuzzBlock(5, 18),
                new FuzzBlock(6,18),
                new FuzzBlock(7,18),
                new FuzzBlock(8,18),
                new FuzzBlock(9,18),
                new FuzzBlock(10,18),
                new FuzzBlock(11,18),
                new FuzzBlock(12,18),
                new FuzzBlock(13,18),
                new FuzzBlock(14,18),
                new FuzzBlock(15,18),
                new RoundSlider(16,18, Direction.UP),
                new RoundSlider(17,18, Direction.UP),
                new RoundSlider(18,18, Direction.UP),
                new Wall(19,18),
                // (20,18)
                new FuzzBlock(21,18),
                //(22,18),
                //(23,18),
                new Wall(24,18),
                //(25,18),
                //(26,18),
                //(27,18),
                new Diamond(28,18)



        };
    }
}
