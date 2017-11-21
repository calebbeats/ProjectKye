package edu.uco.jdrumm.projectkye.Level;

import edu.uco.jdrumm.projectkye.Game.BaseObject;
import edu.uco.jdrumm.projectkye.Game.FuzzBlock;
import edu.uco.jdrumm.projectkye.Game.Kye;

public class Level4 extends Level
{

    public Level4()
    {
        super();
        levelMessage = "";
        levelName = "Zoo";
    }

    @Override
    protected void createObjects()
    {
        objects = new BaseObject[]{
            new FuzzBlock(1, 2),
            new Kye(26, 2)
        };
    }
}
