package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.Rotator;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.Sentry;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;

public class Level6 extends Level
{
    public Level6() {
        super();
        setNextLevel(new Level7());
        levelMessage = "If you're this good - design some new levels";
        levelName = "Counters";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
                new Kye(1, 1),
                new Wall(5, 1),
                new Wall(6, 1),
                new Wall(7, 1),
                new Wall(8, 1, 3),
                new Wall(11, 1, 1),
                new Wall(12, 1),
                new Wall(13, 1),
                new Wall(14, 1, 3),
                new Wall(16, 1, 1),
                new Wall(17, 1),
                new Rotator(18, 1, Rotation.COUNTER_CLOCKWISE),
                new Wall(19, 1),

                new Rotator(4, 2, Rotation.COUNTER_CLOCKWISE),
                new Wall(19, 2, 1),
                new Wall(20, 2),
                new Wall(21, 2),
                new FuzzBlock(22, 2),
                new Wall(23, 2),
                new Wall(24, 2),
                new Wall(25, 2),
                new Wall(26, 2),
                new FuzzBlock(27, 2),
                new Wall(28, 2),

                new Wall(1, 3),
                new FuzzBlock(2, 3),
                new Wall(3, 3),
                new Wall(4, 3),
                new Wall(6, 3, 7),
                new Rotator(7, 3, Rotation.CLOCKWISE),
                new Wall(8, 3),
                new Wall(9, 3),
                new FuzzBlock(10, 3),
                new Wall(11, 3),
                new Wall(12, 3),
                new Wall(13, 3),
                new Wall(14, 3),
                new FuzzBlock(15, 3),
                new Wall(16, 3),
                new Rotator(17, 3, Rotation.CLOCKWISE),
                new Rotator(26, 3, Rotation.COUNTER_CLOCKWISE),

                new Wall(4, 4),
                new Wall(6, 4),
                new Rotator(18, 4, Rotation.CLOCKWISE),
                new Wall(19, 4),
                new Wall(20, 4),
                new Rotator(21, 4, Rotation.COUNTER_CLOCKWISE),
                new Wall(22, 4),
                new SquareSlider(23, 4, Direction.LEFT),
                new SquareSlider(24, 4, Direction.LEFT),

                new Wall(4, 5),
                new Rotator(6, 5, Rotation.CLOCKWISE),
                new Wall(22, 5),
                new Sentry(23, 5, Direction.UP),
                new Wall(25, 5),
                new Wall(28, 5, 7),

                new Wall(4, 6),
                new Wall(6, 6, 1),
                new Wall(7, 6),
                new FuzzBlock(8, 6),
                new Wall(9, 6),
                new Wall(10, 6),
                new Wall(11, 6),
                new Wall(12, 6),
                new Wall(13, 6),
                new FuzzBlock(14, 6),
                new Wall(15, 6),
                new Wall(16, 6),
                new Wall(18, 6, 7),
                new Wall(19, 6),
                new Wall(20, 6, 9),
                new Wall(22, 6),
                new FuzzBlock(25, 6),
                new Wall(28, 6),

                new Wall(4, 7),
                new Rotator(16, 7, Rotation.CLOCKWISE),
                new Wall(18, 7),
                new Wall(20, 7),
                new Wall(22, 7),
                new Wall(25, 7),
                new Wall(28, 7, 1),

                new Wall(4, 8, 1),
                new Rotator(5, 8, Rotation.COUNTER_CLOCKWISE),
                new Wall(6, 8),
                new Wall(7, 8),
                new FuzzBlock(8, 8),
                new Wall(9, 8),
                new Wall(10, 8),
                new Wall(11, 8),
                new FuzzBlock(12, 8),
                new Wall(13, 8),
                new Wall(14, 8),
                new Wall(16, 8),
                new FuzzBlock(18, 8),
                new Wall(20, 8),
                new Wall(22, 8),
                new Wall(23, 8),
                new Wall(24, 8),
                new Wall(25, 8),

                new Wall(14, 9),
                new SquareSlider(15, 9, Direction.DOWN),
                new Wall(16, 9),
                new Wall(18, 9),
                new FuzzBlock(20, 9),
                new Wall(22, 9, 1),
                new Rotator(23, 9, Rotation.COUNTER_CLOCKWISE),
                new Wall(24, 9),
                new Wall(25, 9),

                new Wall(1, 10),
                new Wall(2, 10),
                new Wall(3, 10),
                new FuzzBlock(4, 10),
                new Wall(5, 10),
                new Wall(6, 10),
                new FuzzBlock(7, 10),
                new Wall(8, 10),
                new Wall(9, 10),
                new Wall(10, 10),
                new FuzzBlock(11, 10),
                new Wall(12, 10),
                new Wall(13, 10),
                new Wall(14, 10),
                new Wall(16, 10),
                new Wall(18, 10),
                new Rotator(20, 10, Rotation.CLOCKWISE),
                new Wall(25, 10),

                new Rotator(1, 11, Rotation.COUNTER_CLOCKWISE),
                new Wall(16, 11),
                new FuzzBlock(18, 11),
                new Wall(20, 11, 1),
                new Wall(21, 11),
                new Wall(22, 11, 9),
                new Wall(25, 11),
                new Wall(28, 11, 7),

                new Wall(1, 12),
                new Wall(3, 12, 7),
                new Wall(4, 12),
                new FuzzBlock(5, 12),
                new Wall(6, 12),
                new Wall(7, 12),
                new Wall(8, 12),
                new Wall(9, 12),
                new FuzzBlock(10, 12),
                new Wall(11, 12),
                new Wall(12, 12),
                new Wall(13, 12),
                new Wall(14, 12),
                new Rotator(15, 12, Rotation.CLOCKWISE),
                new Wall(16, 12),
                new Wall(18, 12),
                new FuzzBlock(22, 12),
                new FuzzBlock(25, 12),
                new Wall(28, 12),

                new Wall(1, 13),
                new Rotator(3, 13, Rotation.COUNTER_CLOCKWISE),
                new Wall(18, 13),
                new Wall(22, 13),
                new Wall(25, 13),
                new Wall(28, 13, 1),

                new Wall(1, 14),
                new Wall(3, 14),
                new Wall(5, 14, 4),
                new Wall(6, 14),
                new FuzzBlock(7, 14),
                new Wall(8, 14),
                new Wall(9, 14),
                new Wall(10, 14),
                new Wall(11, 14),
                new Wall(12, 14),
                new Wall(13, 14),
                new FuzzBlock(14, 14),
                new Wall(15, 14),
                new Wall(16, 14),
                new Rotator(17, 14, Rotation.CLOCKWISE),
                new Wall(18, 14),
                new Wall(19, 14),
                new FuzzBlock(20, 14),
                new Wall(21, 14),
                new Wall(22, 14, 3),
                new Wall(25, 14),

                new Wall(1, 15),
                new Wall(3, 15),
                new RoundSlider(10, 15, Direction.RIGHT),
                new Rotator(24, 15, Rotation.COUNTER_CLOCKWISE),
                new Wall(25, 15),

                new Wall(1, 16, 3),
                new Wall(3, 16, 1),
                new Rotator(4, 16, Rotation.COUNTER_CLOCKWISE),
                new Wall(5, 16),
                new Wall(6, 16),
                new FuzzBlock(7, 16),
                new Wall(8, 16),
                new Wall(9, 16),
                new Wall(10, 16),
                new Wall(11, 16),
                new Wall(12, 16),
                new FuzzBlock(13, 16),
                new Wall(14, 16),
                new Wall(15, 16),
                new Wall(16, 16),
                new Wall(17, 16),
                new Wall(18, 16),
                new FuzzBlock(19, 16),
                new Wall(20, 16),
                new Wall(21, 16),
                new Sentry(24, 16, Direction.RIGHT),
                new SquareSlider(25, 16, Direction.UP),
                new RoundSlider(27, 16, Direction.DOWN),

                new SquareSlider(13, 17, Direction.RIGHT),
                new Rotator(26, 17, Rotation.COUNTER_CLOCKWISE),
                new Wall(27, 17),

                new Wall(1, 18),
                new Rotator(2, 18, Rotation.COUNTER_CLOCKWISE),
                new Wall(3, 18),
                new Wall(4, 18),
                new Wall(5, 18),
                new Wall(6, 18),
                new Wall(7, 18),
                new Wall(8, 18, 9),
                new Wall(12, 18, 7),
                new Wall(13, 18),
                new Wall(14, 18),
                new Wall(15, 18),
                new Wall(16, 18),
                new Wall(17, 18),
                new Wall(18, 18),
                new Wall(19, 18, 9),
                new Wall(23, 18, 7),
                new Wall(24, 18),
                new Wall(25, 18),
                new Wall(26, 18),
                new Wall(27, 18),
                new Diamond(28, 18)
        };
    }
}