/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

import static aiprj0000.GameBoard.size;

/**
 *
 * @author kevin
 */
public class Game {

    int avalibleMoves;

    Game() {
        avalibleMoves = 9;
    }

    public int getAvalMoves(int[][] b) {
        int m=0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; j++) {
                if(b[i][j]==0){
                    m++;
                }
            }

        }
        return m;
    }

}
