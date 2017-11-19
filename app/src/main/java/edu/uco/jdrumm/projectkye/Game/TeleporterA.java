package edu.uco.jdrumm.projectkye.Game;

import edu.uco.jdrumm.projectkye.R;

/**
 * Created by caleb on 11/19/2017.
 */

public class TeleporterA extends Actor {
    TeleporterB connector;

    public TeleporterA(int x, int y, TeleporterB b) {
        super(x, y);
        icon = R.drawable.teleporter1;
        connector = b;
    }

    @Override
    public void action(GameBoard board) {
        BaseObject o = board.getAt(x-1 , y);
        if (o instanceof Kye) {
            o = board.getKye();
            board.moveGameObject(o,connector.getCordX(),connector.getCordY() );
            o.setCordX(connector.getCordX());
            o.setCordY(connector.getCordY());
        } else {
            o = board.getAt(x + 1, y);
            if (o instanceof Kye) {
                o = board.getKye();
                board.moveGameObject(o,connector.getCordX(),connector.getCordY() );
                o.setCordX(connector.getCordX());
                o.setCordY(connector.getCordY());
            } else {
                o = board.getAt(x, y - 1);
                if (o instanceof Kye) {
                    o = board.getKye();
                    board.moveGameObject(o,connector.getCordX(),connector.getCordY() );
                    o.setCordX(connector.getCordX());
                    o.setCordY(connector.getCordY());
                } else {
                    o = board.getAt(x, y + 1);
                    if (o instanceof Kye) {
                        o = board.getKye();
                        board.moveGameObject(o,connector.getCordX(),connector.getCordY() );
                        o.setCordX(connector.getCordX());
                        o.setCordY(connector.getCordY());
                    }
                }

             }
        }
    }
}
