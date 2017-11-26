package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Block;
import edu.uco.jdrumm.projectkye.Game.BlockCircle;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.HorizontalMagnet;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.Sentry;
import edu.uco.jdrumm.projectkye.Game.VerticalMagnet;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;

public class Level7 extends Level
{
    public Level7()
    {
        super();
        setNextLevel(new Level8());
        levelMessage = "Ho hum, now for some work";
        levelName = "Blocks";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
                new RoundSlider(1, 1, Direction.RIGHT),
                new RoundSlider(2, 1, Direction.RIGHT),
                new RoundSlider(3, 1, Direction.RIGHT),
                new BlockCircle(4, 1),
                new Wall(10, 1),
                new Kye(11, 1),
                new RoundSlider(17, 1, Direction.DOWN),
                new RoundSlider(18, 1, Direction.DOWN),
                new RoundSlider(19, 1, Direction.DOWN),

                new RoundSlider(2, 2, Direction.RIGHT),
                new RoundSlider(3, 2, Direction.RIGHT),
                new BlockCircle(4, 2),
                new Wall(10, 2),
                new RoundSlider(16, 2, Direction.DOWN),
                new RoundSlider(17, 2, Direction.DOWN),
                new RoundSlider(18, 2, Direction.DOWN),
                new RoundSlider(19, 2, Direction.DOWN),
                new RoundSlider(20, 2, Direction.DOWN),
                new VerticalMagnet(24, 2),
                new HorizontalMagnet(27, 2),

                new FuzzBlock(3, 3),
                new Diamond(9, 3),
                new Wall(10, 3),
                new RoundSlider(15, 3, Direction.DOWN),
                new RoundSlider(16, 3, Direction.DOWN),
                new RoundSlider(17, 3, Direction.DOWN),
                new RoundSlider(18, 3, Direction.DOWN),
                new RoundSlider(19, 3, Direction.DOWN),
                new RoundSlider(20, 3, Direction.DOWN),
                new RoundSlider(21, 3, Direction.DOWN),

                new FuzzBlock(1, 4),
                new Wall(2, 4),
                new Wall(3, 4),
                new Wall(4, 4),
                new Wall(5, 4),
                new Wall(6, 4),
                new Wall(7, 4),
                new Wall(8, 4),
                new Wall(9, 4),
                new Wall(10, 4),
                new Block(15, 4),
                new RoundSlider(16, 4, Direction.DOWN),
                new RoundSlider(17, 4, Direction.DOWN),
                new Diamond(18, 4),
                new RoundSlider(19, 4, Direction.DOWN),
                new RoundSlider(20, 4, Direction.DOWN),
                new Block(21, 4),

                new RoundSlider(2, 5, Direction.DOWN),
                new RoundSlider(3, 5, Direction.DOWN),
                new RoundSlider(4, 5, Direction.DOWN),
                new Wall(10, 5),
                new Block(15, 5),
                new RoundSlider(16, 5, Direction.DOWN),
                new RoundSlider(17, 5, Direction.DOWN),
                new RoundSlider(18, 5, Direction.DOWN),
                new RoundSlider(19, 5, Direction.DOWN),
                new RoundSlider(20, 5, Direction.DOWN),
                new Block(21, 5),

                new RoundSlider(1, 6, Direction.DOWN),
                new RoundSlider(2, 6, Direction.DOWN),
                new RoundSlider(3, 6, Direction.DOWN),
                new RoundSlider(4, 6, Direction.DOWN),
                new RoundSlider(5, 6, Direction.DOWN),
                new Wall(10, 6),
                new Block(15, 6),
                new Block(16, 6),
                new Block(17, 6),
                new Block(18, 6),
                new Block(19, 6),
                new Block(20, 6),
                new Block(21, 6),

                new RoundSlider(1, 7, Direction.DOWN),
                new RoundSlider(2, 7, Direction.DOWN),
                new RoundSlider(3, 7, Direction.DOWN),
                new RoundSlider(4, 7, Direction.DOWN),
                new RoundSlider(5, 7, Direction.DOWN),
                new RoundSlider(6, 7, Direction.DOWN),
                new RoundSlider(7, 7, Direction.DOWN),
                new Wall(10, 7),

                new BlockCircle(1, 8),
                new BlockCircle(2, 8),
                new BlockCircle(3, 8),
                new BlockCircle(4, 8),
                new BlockCircle(5, 8),
                new BlockCircle(6, 8),
                new BlockCircle(7, 8),
                new BlockCircle(8, 8),
                new BlockCircle(9, 8),
                new Wall(10, 8),
                new Sentry(20, 8, Direction.RIGHT),

                new Wall(10, 9),
                new Wall(11, 9),
                new Wall(12, 9),
                new Wall(13, 9),
                new Wall(14, 9),
                new Wall(15, 9),
                new Wall(16, 9, 9),
                new Wall(20, 9, 7),
                new Wall(21, 9),
                new Wall(22, 9),
                new Wall(23, 9),
                new Wall(24, 9),
                new Wall(25, 9),
                new Wall(26, 9),
                new Wall(27, 9),
                new Wall(28, 9),

                new Wall(2, 10),
                new Wall(3, 10),
                new Wall(4, 10),
                new Wall(5, 10),
                new Wall(6, 10, 9),
                new Wall(10, 10),
                new Wall(17, 10, 9),
                new Wall(19, 10, 7),

                new Wall(6, 11, 1),
                new Wall(7, 11),
                new Wall(8, 11),
                new Wall(9, 11),
                new Wall(10, 11),
                new Wall(17, 11),
                new FuzzBlock(18, 11),
                new Wall(21, 11, 8),

                new Wall(1, 12),
                new Wall(2, 12),
                new Wall(3, 12),
                new Wall(4, 12, 9),
                new Block(15, 12),
                new Wall(17, 12, 1),
                new Wall(18, 12),
                new Wall(19, 12),
                new Wall(20, 12),
                new Wall(21, 12, 3),
                new Wall(24, 12, 3),
                new Wall(25, 12),
                new Wall(26, 12),
                new Wall(27, 12),
                new Wall(28, 12),

                new Wall(4, 13, 1),
                new Wall(5, 13),
                new Wall(6, 13, 9),
                new Block(15, 13),
                new Wall(23, 13, 3),
                new RoundSlider(24, 13, Direction.LEFT),
                new RoundSlider(25, 13, Direction.LEFT),
                new RoundSlider(26, 13, Direction.LEFT),
                new RoundSlider(27, 13, Direction.LEFT),

                new Wall(7, 14, 9),
                new Block(15, 14),
                new Wall(22, 14, 3),
                new RoundSlider(23, 14, Direction.LEFT),
                new RoundSlider(24, 14, Direction.LEFT),
                new RoundSlider(25, 14, Direction.LEFT),
                new RoundSlider(26, 14, Direction.LEFT),
                new RoundSlider(27, 14, Direction.LEFT),

                new Wall(8, 15, 9),
                new Wall(21, 15, 3),
                new RoundSlider(22, 15, Direction.LEFT),
                new RoundSlider(23, 15, Direction.LEFT),
                new RoundSlider(24, 15, Direction.LEFT),
                new RoundSlider(25, 15, Direction.LEFT),
                new RoundSlider(26, 15, Direction.LEFT),
                new RoundSlider(27, 15, Direction.LEFT),

                new Wall(9, 16, 9),
                new FuzzBlock(20, 16),
                new RoundSlider(21, 16, Direction.LEFT),
                new RoundSlider(22, 16, Direction.LEFT),
                new RoundSlider(23, 16, Direction.LEFT),
                new RoundSlider(24, 16, Direction.LEFT),
                new RoundSlider(25, 16, Direction.LEFT),
                new RoundSlider(26, 16, Direction.LEFT),
                new RoundSlider(27, 16, Direction.LEFT),

                new Wall(21, 17, 9),
                new RoundSlider(22, 17, Direction.LEFT),
                new RoundSlider(23, 17, Direction.LEFT),
                new RoundSlider(24, 17, Direction.LEFT),
                new RoundSlider(25, 17, Direction.LEFT),
                new RoundSlider(26, 17, Direction.LEFT),
                new RoundSlider(27, 17, Direction.LEFT),

                new Wall(9, 18, 3),
                new Wall(22, 18),
                new RoundSlider(23, 18, Direction.LEFT),
                new RoundSlider(24, 18, Direction.LEFT),
                new RoundSlider(25, 18, Direction.LEFT),
                new RoundSlider(26, 18, Direction.LEFT),
                new RoundSlider(27, 18, Direction.LEFT),
                new Diamond(28, 18)
        };
    }
}
