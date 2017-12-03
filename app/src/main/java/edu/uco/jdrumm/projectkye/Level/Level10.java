package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Block;
import edu.uco.jdrumm.projectkye.Game.BlockCircle;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.Monster;
import edu.uco.jdrumm.projectkye.Game.Rotator;
import edu.uco.jdrumm.projectkye.Game.Sentry;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;

public class Level10 extends Level
{
    public Level10()
    {
        super();
        setNextLevel(new Level11());
        levelMessage = "I hope you didn't just outrun 'em";
        levelName = "Trapper";
    }

    @Override
    protected void createObjects() {
        objects = new BaseObject[]{
                new Kye(1, 1),
                new Block(18, 1),
                new Diamond(28, 1),

                new Block(2, 2),
                new Block(5, 2),
                new Block(6, 2),
                new Sentry(8, 2, Direction.RIGHT),
                new Block(9, 2),
                new Block(10, 2),
                new BlockCircle(18, 2),

                new Block(2, 3),
                new Block(18, 3),
                new Monster(23, 3, Monster.Monsters.TWISTER),

                new Block(2, 4),
                new BlockCircle(18, 4),

                new Block(2, 5),
                new Block(18, 5),
                new Monster(23, 5, Monster.Monsters.GNASHER),
                new Diamond(28, 5),

                new Block(2, 6),
                new BlockCircle(18, 6),

                new Block(2, 7),
                new Block(18, 7),
                new Monster(23, 7, Monster.Monsters.BLOB),

                new Rotator(2, 8, Rotation.COUNTER_CLOCKWISE),
                new BlockCircle(18, 8),

                new Rotator(2, 9, Rotation.CLOCKWISE),
                new Block(18, 9),
                new Monster(23, 9, Monster.Monsters.SPIKE),
                new Diamond(28, 9),

                new Rotator(2, 10, Rotation.COUNTER_CLOCKWISE),
                new BlockCircle(18, 10),

                new Rotator(2, 11, Rotation.CLOCKWISE),
                new Block(18, 11),

                new Block(6, 12),
                new FuzzBlock(10, 12),
                new SquareSlider(11, 12, Direction.DOWN),
                new BlockCircle(18, 12),

                new Block(6, 13),
                new SquareSlider(10, 13, Direction.UP),
                new FuzzBlock(11, 13),
                new Block(18, 13),

                new BlockCircle(2, 14),
                new BlockCircle(18, 14),
                new Diamond(28, 14),

                new BlockCircle(2, 15),
                new Sentry(6, 15, Direction.UP),
                new FuzzBlock(10, 15),
                new SquareSlider(11, 15, Direction.LEFT),
                new Block(18, 15),

                new BlockCircle(2, 16),
                new Block(6, 16),
                new SquareSlider(10, 16, Direction.RIGHT),
                new FuzzBlock(11, 16),
                new BlockCircle(18, 16),

                new BlockCircle(2, 17),
                new Block(6, 17),
                new Block(18, 17),

                new BlockCircle(18, 18),
                new Diamond(28, 18)

        };
    }
}
