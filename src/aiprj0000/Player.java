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
public class Player {

    public  int[] winAcross = new int[3];
    public  int[] winDown = new int[3];
    public  int[] winDi = new int[2];

    public  int[] getWinAcross() {
        return this.winAcross;
    }

    public  int[] getWinDown() {
        return winDown;
    }

    public  int[] getWinDi() {
        return winDi;
    }
    int symbol;

    Player(int s) {
        symbol = s;
        winAcross = new int[3];
        winDown = new int[3];
         winDi = new int[2];
    }

    public int getPlayer() {
        return symbol;
    }

    public int getMovesTaken(int[][] b, Player p) {
        int m = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; j++) {
                if (b[i][j] != 0) {
                    m++;
                }
            }
        }
        if (b[1][1] != p.symbol) {
            //     middleTaken = true;
        }
        setWinDown(b, p);
        setWinAcross(b, p);
        setWinDi(b, p);
        return m;
    }

    public static void setWinAcross(int[][] b, Player p) {
        int win = 0, i, j;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; j++) {
                if (b[i][j] == p.symbol) {
                    win++;
                }
            }
            if (j == 3) {
                j--;
            }
            p.winAcross[i] = win;
        }

    }

    public static void setWinDown(int[][] b, Player p) {
        int win = 0, i, j, k = 0;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; j++) {

                if (b[i][j]==p.symbol&&k % 3 == 0) {
                    p.winDown[0]++;
                }
                if (b[i][j]==p.symbol&&k % 3 == 1) {
                      p.winDown[1]++;
                }
                if (b[i][j]==p.symbol&&k % 3 == 2) {
                      p.winDown[2]++;
                }
                k++;
            }

        }

    }

    public static void setWinDi(int[][] b, Player p) {

        if (b[0][0] == p.symbol) {

            p.winDi[0]++;
        }
        if (b[1][1] ==  p.symbol) {
            p.winDi[0]++;
            p.winDi[1]++;
        }
        if (b[2][2] ==  p.symbol) {

            p.winDi[0]++;
        }
        if (b[0][2] == p.symbol) {

            p.winDi[1]++;
        }
        if (b[2][0] ==  p.symbol) {

            p.winDi[1]++;
        }

    }

}
