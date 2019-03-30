/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

import static aiprj0000.GameBoard.size;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class EvalFcn {

    Player ai;
    boolean middleTaken = false;
    static int[] winAcross = new int[3];
    static int[] winDown = new int[3];
    static int[] winDi = new int[2];
    Random r = new Random();
    int movesTaken;
    int rand = 0;
    static Ai g = new Ai();
    boolean aiX = false;
    int[][] board = new int[3][3];
    GameBoard gb = new GameBoard();

    EvalFcn(int[][] board, Player ai) {
        this.board = board;
        movesTaken = 0;
        this.ai = ai;
    }

    public int makeMove() {
        movesTaken = this.getMovesTaken(this.board, ai);
        if (movesTaken == 0) {
            return 4;
        } else if (movesTaken == 1 && !middleTaken) {
            return 4;
        } else if (movesTaken == 1 && middleTaken) {
            rand = r.nextInt(3);
            switch (rand) {
                case 0:
                    return 0;
                case 1:
                    return 2;
                case 2:
                    return 6;
                case 3:
                    return 8;
            }
            if (movesTaken == 2) {
                
            }
        }
        return -1;
    }

    public int getMovesTaken(int[][] b, Player ai) {
        int m = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; j++) {
                if (b[i][j] != 0) {
                    m++;
                }
            }
        }
        if (b[1][1] != ai.symbol) {
            middleTaken = true;
        }
        setWinDown(b, this.ai.symbol);
        setWinAcross(b, this.ai.symbol);
        setWinDi(b, this.ai.symbol);
        return m;
    }

    public static void setWinAcross(int[][] b, int p) {
        int win = 0, i, j;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; j++) {
                if (b[i][j] == p) {
                    win++;
                }
            }

            winAcross[j] = win;
        }

    }

    public static void setWinDown(int[][] b, int p) {
        int win = 0, i, j, k = 0;
        for (i = 0; i < size; ++i) {
            for (j = 0; j < size; j++) {

                if (k % 3 == 0) {
                    winDown[0]++;
                }
                if (k % 3 == 1) {
                    winDown[1]++;
                }
                if (k % 3 == 2) {
                    winDown[2]++;
                }
                k++;
            }

        }

    }

    public static void setWinDi(int[][] b, int p) {

        if (b[0][0] == p) {

            winDi[0]++;
        }
        if (b[1][1] == p) {
            winDi[0]++;
            winDi[1]++;
        }
        if (b[2][2] == p) {

            winDi[0]++;
        }
        if (b[0][2] == p) {

            winDi[1]++;
        }
        if (b[2][0] == p) {

            winDi[1]++;
        }

    }

}
