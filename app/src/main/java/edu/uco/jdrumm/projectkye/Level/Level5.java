package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;

public class Level5 extends Level
{
    public Level5()
    {
        super();
        setNextLevel(new Level6());
        levelMessage = "That was pretty, wasn't it?";
        levelName = "Diamond";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
                new RoundSlider(1, 1, Direction.RIGHT),
                new RoundSlider(2, 1, Direction.RIGHT),
                new RoundSlider(3, 1, Direction.RIGHT),
                new RoundSlider(4, 1, Direction.RIGHT),
                new Wall(5, 1, 1),
                new Wall(6, 1),
                new Wall(7, 1),
                new FuzzBlock(13, 1),
                new Wall(15, 1, 1),
                new Wall(16, 1),
                new Wall(17, 1),
                new Wall(22, 1, 2),
                new Wall(26, 1, 8),
                new Diamond(28, 1),

                new RoundSlider(2, 2, Direction.RIGHT),
                new RoundSlider(3, 2, Direction.RIGHT),
                new RoundSlider(4, 2, Direction.RIGHT),
                new RoundSlider(5, 2, Direction.RIGHT),
                new Wall(6, 2, 1),
                new Wall(7, 2),
                new Wall(12, 2, 8),
                new Wall(16, 2, 1),
                new Wall(17, 2),
                new Wall(25, 2, 4),
                new Wall(26, 2),

                new RoundSlider(3, 3, Direction.RIGHT),
                new RoundSlider(4, 3, Direction.RIGHT),
                new RoundSlider(5, 3, Direction.RIGHT),
                new RoundSlider(6, 3, Direction.RIGHT),
                new Wall(7, 3, 2),
                new Wall(11, 3, 7),
                new Wall(12, 3),
                new Wall(17, 3, 2),
                new Wall(22, 3, 9),
                new Wall(26, 3, 2),

                new Kye(1, 4),
                new FuzzBlock(4, 4),
                new FuzzBlock(5, 4),
                new FuzzBlock(6, 4),
                new Wall(10, 4, 7),
                new Wall(11, 4),
                new Wall(12, 4),
                new FuzzBlock(18, 4),
                new Wall(20, 4, 7),
                new Wall(21, 4),
                new Wall(22, 4),
                new FuzzBlock(28, 4),

                new Wall(1, 5),
                new Wall(2, 5),
                new Wall(3, 5),
                new Wall(4, 5),
                new Wall(5, 5),
                new Wall(6, 5),
                new Wall(7, 5),
                new Wall(8, 5),
                new Wall(9, 5),
                new Wall(10, 5),
                new Wall(11, 5),
                new Wall(12, 5),
                new Wall(13, 5),
                new Wall(14, 5),
                new Wall(15, 5),
                new Wall(16, 5),
                new Wall(17, 5),
                new Wall(18, 5),
                new Wall(19, 5),
                new Wall(20, 5),
                new Wall(21, 5),
                new Wall(22, 5),
                new Wall(23, 5),
                new Wall(24, 5),
                new Wall(25, 5),
                new Wall(26, 5),
                new Wall(27, 5),
                new FuzzBlock(28, 5),

                new Wall(3, 6),
                new Diamond(4, 6),
                new Wall(5, 6),
                new FuzzBlock(14, 6),

                new Wall(3, 7),
                new SquareSlider(4, 7, Direction.DOWN),
                new Wall(5, 7),
                new Wall(14, 7),
                new RoundSlider(21, 7, Direction.DOWN),

                new Wall(3, 8),
                new FuzzBlock(4, 8),
                new Wall(5, 8),
                new Wall(10, 8),
                new Wall(11, 8),
                new Wall(12, 8),
                new Wall(13, 8),
                new Wall(14, 8),
                new RoundSlider(20, 8, Direction.RIGHT),
                new RoundSlider(21, 8, Direction.DOWN),
                new RoundSlider(22, 8, Direction.DOWN),

                new Wall(3, 9),
                new FuzzBlock(11, 9),
                new SquareSlider(12, 9, Direction.LEFT),
                new Diamond(13, 9),
                new Wall(14, 9),
                new RoundSlider(19, 9, Direction.RIGHT),
                new RoundSlider(20, 9, Direction.RIGHT),
                new RoundSlider(21, 9, Direction.DOWN),
                new RoundSlider(22, 9, Direction.DOWN),
                new RoundSlider(23, 9, Direction.DOWN),

                new Wall(11, 10),
                new Wall(12, 10),
                new Wall(13, 10),
                new Wall(14, 10),
                new RoundSlider(18, 10, Direction.RIGHT),
                new RoundSlider(19, 10, Direction.RIGHT),
                new RoundSlider(20, 10, Direction.RIGHT),
                new RoundSlider(21, 10, Direction.DOWN),
                new RoundSlider(22, 10, Direction.DOWN),
                new RoundSlider(23, 10, Direction.DOWN),
                new RoundSlider(24, 10, Direction.DOWN),

                new Wall(7, 11, 7),
                new Wall(8, 11, 9),
                new Wall(14, 11),
                new RoundSlider(17, 11, Direction.RIGHT),
                new RoundSlider(18, 11, Direction.RIGHT),
                new RoundSlider(19, 11, Direction.RIGHT),
                new RoundSlider(20, 11, Direction.RIGHT),
                new RoundSlider(21, 11, Direction.DOWN),
                new RoundSlider(22, 11, Direction.DOWN),
                new RoundSlider(23, 11, Direction.DOWN),
                new RoundSlider(24, 11, Direction.DOWN),
                new RoundSlider(25, 11, Direction.DOWN),

                new Wall(7, 12, 1),
                new Wall(8, 12, 3),
                new Wall(14, 12),
                new RoundSlider(16, 12, Direction.RIGHT),
                new RoundSlider(17, 12, Direction.RIGHT),
                new RoundSlider(18, 12, Direction.RIGHT),
                new RoundSlider(19, 12, Direction.RIGHT),
                new RoundSlider(20, 12, Direction.RIGHT),
                new Diamond(21, 12),
                new RoundSlider(22, 12, Direction.LEFT),
                new RoundSlider(23, 12, Direction.LEFT),
                new RoundSlider(24, 12, Direction.LEFT),
                new RoundSlider(25, 12, Direction.LEFT),
                new RoundSlider(26, 12, Direction.LEFT),

                new Wall(14, 13),
                new RoundSlider(17, 13, Direction.UP),
                new RoundSlider(18, 13, Direction.UP),
                new RoundSlider(19, 13, Direction.UP),
                new RoundSlider(20, 13, Direction.UP),
                new RoundSlider(21, 13, Direction.UP),
                new RoundSlider(22, 13, Direction.LEFT),
                new RoundSlider(23, 13, Direction.LEFT),
                new RoundSlider(24, 13, Direction.LEFT),
                new RoundSlider(25, 13, Direction.LEFT),

                new Wall(1, 14),
                new Wall(2, 14),
                new Wall(3, 14),
                new Wall(14, 14),
                new RoundSlider(18, 14, Direction.UP),
                new RoundSlider(19, 14, Direction.UP),
                new RoundSlider(20, 14, Direction.UP),
                new RoundSlider(21, 14, Direction.UP),
                new RoundSlider(22, 14, Direction.LEFT),
                new RoundSlider(23, 14, Direction.LEFT),
                new RoundSlider(24, 14, Direction.LEFT),

                new Diamond(1, 15),
                new SquareSlider(2, 15, Direction.RIGHT),
                new FuzzBlock(3, 15),
                new Wall(11, 15),
                new Wall(14, 15),
                new RoundSlider(19, 15, Direction.UP),
                new RoundSlider(20, 15, Direction.UP),
                new RoundSlider(21, 15, Direction.UP),
                new RoundSlider(22, 15, Direction.LEFT),
                new RoundSlider(23, 15, Direction.LEFT),

                new Wall(1, 16),
                new Wall(2, 16),
                new Wall(3, 16),
                new Wall(4, 16),
                new Wall(9, 16),
                new FuzzBlock(10, 16),
                new Wall(11, 16),
                new Wall(14, 16),
                new RoundSlider(20, 16, Direction.UP),
                new RoundSlider(21, 16, Direction.UP),
                new RoundSlider(22, 16, Direction.LEFT),

                new Wall(9, 17),
                new SquareSlider(10, 17, Direction.UP),
                new Wall(11, 17),
                new Wall(14, 17),
                new RoundSlider(21, 17, Direction.UP),

                new Wall(9, 18),
                new Diamond(10, 18),
                new Wall(11, 18),
                new Wall(14, 18),
        };
    }
}
