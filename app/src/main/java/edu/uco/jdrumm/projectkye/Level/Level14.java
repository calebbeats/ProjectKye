package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.BlackHole;
import edu.uco.jdrumm.projectkye.Game.Block;
import edu.uco.jdrumm.projectkye.Game.BlockCircle;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.ForceField;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.HorizontalMagnet;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.Monster;
import edu.uco.jdrumm.projectkye.Game.Rotator;
import edu.uco.jdrumm.projectkye.Game.RoundShooter;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.Sentry;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Game.VerticalMagnet;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;

public class Level14 extends Level
{
    public Level14()
    {
        super();
        setNextLevel(new Level15());
        levelMessage = "Darn doors!";
        levelName = "Adoorable";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
                new Diamond(1, 1),
                new Wall(2, 1),
                new Sentry(12, 1, Direction.RIGHT),
                new Diamond(13, 1),
                new BlackHole(14, 1),
                new Diamond(15, 1),
                new RoundShooter(16, 1, Direction.RIGHT),
                new Diamond(17, 1),
                new Wall(22, 1, 1),
                new Wall(23, 1),
                new Wall(24, 1),
                new Wall(25, 1, 3),
                new Kye(28, 1),

                new Wall(2, 2),
                new FuzzBlock(6, 2),
                new Wall(10, 2),
                new Wall(11, 2),
                new Wall(12, 2),
                new Wall(13, 2, 3),
                new RoundShooter(14, 2, Direction.LEFT),
                new Diamond(15, 2),
                new Diamond(16, 2),

                new Wall(2, 3),
                new Wall(3, 3),
                new Wall(4, 3),
                new Wall(5, 3),
                new FuzzBlock(6, 3),
                new FuzzBlock(7, 3),
                new FuzzBlock(8, 3),
                new FuzzBlock(9, 3),
                new Wall(10, 3),
                new Diamond(14, 3),

                new Monster(1, 4, Monster.Monsters.GNASHER),
                new BlockCircle(2, 4),
                new FuzzBlock(3, 4),
                new FuzzBlock(4, 4),
                new Wall(10, 4),
                new Wall(18, 4),
                new Wall(20, 4),
                new Wall(21, 4),
                new Wall(22, 4),
                new VerticalMagnet(23, 4),
                new Wall(25, 4),
                new Wall(26, 4),

                new Wall(1, 5),
                new Wall(2, 5),
                new Wall(3, 5),
                new Wall(4, 5),
                new Wall(5, 5),
                new Wall(10, 5),
                new Wall(18, 5),
                new Wall(21, 5),
                new Block(23, 5),
                new SquareSlider(24, 5, Direction.LEFT),
                new Wall(26, 5),

                new HorizontalMagnet(1, 6),
                new SquareSlider(4, 6, Direction.RIGHT),
                new Diamond(5, 6),
                new RoundSlider(6, 6, Direction.LEFT),
                new Wall(10, 6),
                new Wall(18, 6, 1),
                new Wall(19, 6),
                new Wall(21, 6),
                new BlockCircle(26, 6),

                new Wall(1, 7),
                new Wall(2, 7),
                new Wall(3, 7),
                new Wall(4, 7),
                new Wall(5, 7, 6),
                new Wall(7, 7, 8),
                new Wall(10, 7),
                new Wall(19, 7),
                new Wall(21, 7),
                new BlockCircle(26, 7),

                new Wall(7, 8),
                new Wall(8, 8),
                new Wall(9, 8),
                new Wall(10, 8, 3),
                new Wall(19, 8),
                new SquareSlider(20, 8, Direction.DOWN),
                new Wall(21, 8),
                new Monster(25, 8, Monster.Monsters.BLOB),
                new Wall(26, 8),

                new Wall(3, 9, 7),
                new Wall(4, 9, 6),
                new Wall(7, 9, 2),
                new Wall(9, 9, 2),
                new HorizontalMagnet(19, 9),
                new SquareSlider(20, 9, Direction.DOWN),
                new Wall(21, 9),
                new Wall(22, 9),
                new Wall(23, 9),
                new Wall(24, 9),
                new Wall(25, 9),
                new Wall(26, 9, 3),

                new Diamond(1, 10),
                new Wall(2, 10, 7),
                new Wall(3, 10, 3),
                new Wall(11, 10, 8),
                new BlockCircle(14, 10),
                new BlockCircle(15, 10),
                new BlockCircle(16, 10),
                new Wall(19, 10),
                new Wall(21, 10),

                new Wall(1, 11),
                new Wall(2, 11, 3),
                new FuzzBlock(4, 11),
                new Monster(6, 11, Monster.Monsters.SNAKE),
                new FuzzBlock(8, 11),
                new Wall(10, 11, 4),
                new Wall(11, 11),
                new BlockCircle(14, 11),
                new Monster(15, 11, Monster.Monsters.SPIKE),
                new BlockCircle(16, 11),
                new Wall(19, 11),
                new Wall(21, 11),
                new ForceField(22, 11, Direction.DOWN),
                new Wall(23, 11, 8),
                new ForceField(24, 11, Direction.UP),
                new Wall(25, 11, 8),
                new ForceField(26, 11, Direction.UP),
                new Wall(27, 11, 8),
                new ForceField(28, 11, Direction.DOWN),

                new Wall(1, 12),
                //new Diamond(5, 12),
                new VerticalMagnet(6, 12),
                //new Diamond(7, 12),
                new Wall(11, 12),
                new BlockCircle(14, 12),
                new Diamond(15, 12),
                new BlockCircle(16, 12),
                new Wall(19, 12),
                new Wall(21, 12),
                new ForceField(22, 12, Direction.UP),
                new Wall(23, 12),
                new ForceField(24, 12, Direction.UP),
                new Wall(25, 12),
                new ForceField(26, 12, Direction.UP),
                new Wall(27, 12),
                new ForceField(28, 12, Direction.DOWN),

                new Wall(1, 13),
                new FuzzBlock(2, 13),
                new Monster(4, 13, Monster.Monsters.GNASHER),
                new HorizontalMagnet(5, 13),
                new Monster(6, 13, Monster.Monsters.BLOB),
                new HorizontalMagnet(7, 13),
                new Monster(8, 13, Monster.Monsters.SPIKE),
                new FuzzBlock(10, 13),
                new Wall(11, 13),
                new BlockCircle(14, 13),
                new Diamond(15, 13),
                new BlockCircle(16, 13),
                new Rotator(19, 13, Rotation.CLOCKWISE),
                new Wall(21, 13),
                new ForceField(22, 13, Direction.DOWN),
                new Wall(23, 13),
                new ForceField(24, 13, Direction.UP),
                new Wall(25, 13),
                new ForceField(26, 13, Direction.DOWN),
                new Wall(27, 13),
                new ForceField(28, 13, Direction.DOWN),

                new Wall(1, 14),
                //new Diamond(5, 14),
                new VerticalMagnet(6, 14),
                //new Diamond(7, 14),
                new Wall(11, 14),
                new BlockCircle(14, 14),
                new BlockCircle(15, 14),
                new BlockCircle(16, 14),
                new Rotator(19, 14, Rotation.CLOCKWISE),
                new Wall(21, 14),
                new ForceField(22, 14, Direction.DOWN),
                new Wall(23, 14),
                new ForceField(24, 14, Direction.UP),
                new Wall(25, 14),
                new ForceField(26, 14, Direction.UP),
                new Wall(27, 14),
                new ForceField(28, 14, Direction.DOWN),

                new Wall(1, 15),
                new Wall(2, 15, 9),
                new FuzzBlock(4, 15),
                new Monster(6, 15, Monster.Monsters.TWISTER),
                new FuzzBlock(8, 15),
                new Wall(10, 15, 7),
                new Wall(11, 15, 3),
                new Wall(19, 15),
                new Wall(21, 15),

                new Wall(2, 16),
                new Wall(3, 16, 9),
                new Wall(9, 16, 7),
                new Wall(10, 16, 3),
                new Wall(19, 16),
                new Wall(21, 16),
                new RoundSlider(25, 16, Direction.DOWN),

                new Wall(3, 17),
                new Wall(4, 17, 9),
                new FuzzBlock(6, 17),
                new Wall(8, 17, 7),
                new Wall(9, 17, 3),
                new Wall(19, 17),
                new Wall(21, 17),
                new RoundSlider(23, 17, Direction.DOWN),
                new RoundSlider(24, 17, Direction.RIGHT),
                new Diamond(25, 17),
                new RoundSlider(26, 17, Direction.LEFT),
                new RoundSlider(27, 17, Direction.DOWN),

                new Wall(4, 18),
                new Wall(5, 18),
                new Wall(6, 18),
                new Wall(7, 18),
                new Wall(8, 18),
                new Wall(19, 18),
                new Diamond(20, 18),
                new Wall(21, 18),
                new FuzzBlock(22, 18),
                new RoundSlider(23, 18, Direction.UP),
                new Diamond(24, 18),
                new Diamond(25, 18),
                new Diamond(26, 18),
                new RoundSlider(27, 18, Direction.UP),
                new FuzzBlock(28, 18)
        };
    }
}
