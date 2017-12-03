package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.Monster;
import edu.uco.jdrumm.projectkye.Game.Rotator;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Orientation.Rotation;

public class Level9 extends Level
{
    public Level9()
    {
        super();
        setNextLevel(new Level10());
        levelMessage = "Not bad for a beginner!";
        levelName = "Gallery";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
                new Rotator(8, 1, Rotation.CLOCKWISE),
                new Rotator(11, 1, Rotation.COUNTER_CLOCKWISE),
                new Rotator(14, 1, Rotation.CLOCKWISE),
                new Rotator(17, 1, Rotation.COUNTER_CLOCKWISE),
                new Rotator(20, 1, Rotation.CLOCKWISE),
                new Rotator(23, 1, Rotation.COUNTER_CLOCKWISE),
                new Rotator(26, 1, Rotation.CLOCKWISE),

                new Rotator(1, 2, Rotation.COUNTER_CLOCKWISE),
                new Rotator(28, 2, Rotation.CLOCKWISE),

                new Diamond(1, 3),
                new Wall(3, 3, 8),
                new Wall(26, 3, 8),
                new Diamond(28, 3),

                new Wall(1, 4),
                new Wall(3, 4),
                new Wall(26, 4),
                new Wall(28, 4),

                new Wall(1, 5),
                new Monster(2, 5, Monster.Monsters.SNAKE),
                new Wall(3, 5),
                new Wall(26, 5),
                new Monster(27, 5, Monster.Monsters.BLOB),
                new Wall(28, 5),

                new Wall(1, 6),
                new Wall(2, 6),
                new Wall(3, 6),
                new Wall(26, 6),
                new Wall(27, 6),
                new Wall(28, 6),

                new Kye(1, 7),
                new Rotator(4, 7, Rotation.CLOCKWISE),

                new Rotator(4, 8, Rotation.COUNTER_CLOCKWISE),

                new Rotator(4, 9, Rotation.CLOCKWISE),

                new Rotator(4, 10, Rotation.COUNTER_CLOCKWISE),

                new Rotator(4, 11, Rotation.CLOCKWISE),

                new SquareSlider(3, 12, Direction.RIGHT),
                new FuzzBlock(4, 12),

                new FuzzBlock(3, 13),
                new SquareSlider(4, 13, Direction.LEFT),

                new SquareSlider(3, 14, Direction.RIGHT),
                new FuzzBlock(4, 14),

                new FuzzBlock(3, 15),
                new SquareSlider(4, 15, Direction.LEFT),

                new SquareSlider(3, 16, Direction.RIGHT),
                new FuzzBlock(4, 16),

                new FuzzBlock(3, 17),
                new SquareSlider(4, 17, Direction.LEFT),

                new SquareSlider(3, 18, Direction.RIGHT),
                new FuzzBlock(4, 18)
        };
    }
}
