package edu.uco.jdrumm.projectkye;

/**
 * Created by caleb on 10/23/2017.
 */

public class TestLevel extends Level {
    @Override
    public void populateBoard(GameBoard b) {
        b.board[0][0] = new Diamond(0,0);
        b.board[1][1] = new Kye(1,1);
        b.board[2][2] = new WallBlock(2,2);
    }
}
