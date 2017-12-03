package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.BlackHole;
import edu.uco.jdrumm.projectkye.Game.Block;
import edu.uco.jdrumm.projectkye.Game.Diamond;
import edu.uco.jdrumm.projectkye.Game.ForceField;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;
import edu.uco.jdrumm.projectkye.Game.Monster;
import edu.uco.jdrumm.projectkye.Game.RoundShooter;
import edu.uco.jdrumm.projectkye.Game.RoundSlider;
import edu.uco.jdrumm.projectkye.Game.SquareShooter;
import edu.uco.jdrumm.projectkye.Game.SquareSlider;
import edu.uco.jdrumm.projectkye.Game.Wall;
import edu.uco.jdrumm.projectkye.Orientation.Direction;

public class Level11 extends Level
{
    public Level11()
    {
        super();
        setNextLevel(new Level12());
        levelMessage = "Fun but easy";
        levelName = "Pintpot";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
                new Kye(1, 1),
                new Wall(15, 1),

                new Wall(2, 2, 7),
                new Wall(3, 2),
                new Wall(4, 2),
                new Wall(5, 2),
                new Wall(6, 2),
                new Wall(7, 2),
                new Wall(8, 2),
                new Wall(9, 2),
                new Wall(10, 2),
                new Wall(11, 2),
                new Wall(12, 2),
                new Wall(13, 2),
                new Wall(15, 2),
                new Block(18, 2),
                new Block(19, 2),
                new Block(20, 2),
                new Block(21, 2),
                new Block(22, 2),
                new Block(23, 2),
                new Block(24, 2),
                new Block(25, 2),

                new Wall(2, 3),
                new RoundShooter(3, 3, Direction.DOWN),
                new RoundShooter(4, 3, Direction.RIGHT),
                new RoundShooter(5, 3, Direction.UP),
                new RoundShooter(6, 3, Direction.LEFT),
                new RoundShooter(7, 3, Direction.DOWN),
                new RoundShooter(8, 3, Direction.RIGHT),
                new RoundShooter(9, 3, Direction.UP),
                new RoundShooter(10, 3, Direction.LEFT),
                new RoundShooter(11, 3, Direction.DOWN),
                new RoundShooter(12, 3, Direction.RIGHT),
                new Wall(13, 3),
                new Wall(15, 3),
                new Block(18, 3),
                new Monster(19, 3, Monster.Monsters.BLOB),

                new Diamond(2, 4),
                new Diamond(13, 4),
                new Wall(15, 4),
                new Block(18, 4),
                new Monster(19, 4, Monster.Monsters.BLOB),

                new Diamond(2, 5),
                new Diamond(13, 5),
                new Wall(15, 5),
                new Block(18, 5),

                new Diamond(2, 6),
                new Diamond(13, 6),
                new Wall(15, 6),
                new Block(18, 6),

                new Diamond(2, 7),
                new Diamond(13, 7),
                new Wall(15, 7),
                new Block(18, 7),
                new Diamond(19, 7),
                new Diamond(20, 7),
                new Diamond(21, 7),
                new Diamond(22, 7),

                new Wall(2, 8),
                new Wall(13, 8),
                new Wall(15, 8),
                new Block(18, 8),
                new BlackHole(19, 8),

                new Wall(2, 9),
                new Wall(13, 9),
                new Wall(15, 9),
                new Block(18, 9),
                new Diamond(19, 9),
                new Diamond(20, 9),
                new Diamond(21, 9),
                new Diamond(22, 9),

                new Wall(3, 10, 9),
                new Wall(12, 10, 7),
                new Wall(15, 10),
                new Block(18, 10),

                new Wall(4, 11, 9),
                new Wall(11, 11, 7),
                new Wall(15, 11),
                new Block(18, 11),

                new Wall(5, 12, 9),
                new Wall(10, 12, 7),
                new Wall(15, 12),
                new Block(18, 12),

                new BlackHole(6, 13),
                new BlackHole(7, 13),
                new BlackHole(8, 13),
                new BlackHole(9, 13),
                new Wall(15, 13),
                new Block(18, 13),

                new Wall(15, 14),
                new Block(18, 14),
                new Monster(19, 14, Monster.Monsters.BLOB),

                new FuzzBlock(1, 15),
                new SquareSlider(2, 15, Direction.DOWN),
                new FuzzBlock(3, 15),
                new SquareSlider(4, 15, Direction.DOWN),
                new FuzzBlock(5, 15),
                new SquareSlider(6, 15, Direction.DOWN),
                new FuzzBlock(7, 15),
                new SquareSlider(8, 15, Direction.DOWN),
                new SquareSlider(9, 15, Direction.DOWN),
                new FuzzBlock(10, 15),
                new FuzzBlock(11, 15),
                new SquareSlider(12, 15, Direction.DOWN),
                new SquareSlider(13, 15, Direction.DOWN),
                new FuzzBlock(14, 15),
                new ForceField(15, 15, Direction.LEFT),
                new Block(18, 15),
                new Monster(19, 15, Monster.Monsters.BLOB),

                new FuzzBlock(1, 16),
                new FuzzBlock(2, 16),
                new SquareSlider(3, 16, Direction.DOWN),
                new SquareSlider(4, 16, Direction.DOWN),
                new SquareSlider(5, 16, Direction.DOWN),
                new SquareSlider(6, 16, Direction.DOWN),
                new SquareSlider(7, 16, Direction.DOWN),
                new SquareSlider(8, 16, Direction.DOWN),
                new SquareSlider(9, 16, Direction.DOWN),
                new FuzzBlock(10, 16),
                new SquareSlider(11, 16, Direction.DOWN),
                new SquareSlider(12, 16, Direction.DOWN),
                new SquareSlider(13, 16, Direction.DOWN),
                new SquareSlider(14, 16, Direction.DOWN),
                new Wall(15, 16),
                new Block(18, 16),
                new Monster(19, 16, Monster.Monsters.BLOB),

                new SquareSlider(1, 17, Direction.DOWN),
                new Diamond(3, 17),
                new Diamond(4, 17),
                new SquareSlider(5, 17, Direction.DOWN),
                new Diamond(6, 17),
                new Diamond(7, 17),
                new SquareSlider(8, 17, Direction.DOWN),
                new Diamond(9, 17),
                new SquareSlider(10, 17, Direction.DOWN),
                new Diamond(11, 17),
                new SquareSlider(12, 17, Direction.DOWN),
                new SquareSlider(13, 17, Direction.DOWN),
                new Diamond(14, 17),
                new Wall(15, 17),
                new Block(18, 17),
                new Block(19, 17),
                new Block(20, 17),
                new Block(21, 17),
                new Block(22, 17),
                new Block(23, 17),
                new Block(24, 17),
                new Block(25, 17),

                new Diamond(1, 18),
                new Diamond(2, 18),
                new SquareSlider(3, 18, Direction.DOWN),
                new Diamond(5, 18),
                new Diamond(6, 18),
                new Diamond(8, 18),
                new Diamond(10, 18),
                new Diamond(12, 18),
                new Diamond(13, 18),
                new Wall(15, 18)
        };
    }
}
