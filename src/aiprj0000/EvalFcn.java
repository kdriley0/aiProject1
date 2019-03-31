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
    Player h = new Player(1);
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
        if (ai.symbol == 1) {
            aiX = true;
            h = new Player(-1);
        }

    }

    public int makeMove() {
        movesTaken = ai.getMovesTaken(this.board, ai);
        int i, j, k;
        switch (movesTaken) {
            case 0:
                return 4;
            case 1:
                if (movesTaken == 1 && !middleTaken) {
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
                }
            case 2:
                if (aiX) {
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
                }
            case 3:
                h.getMovesTaken(board, h);
                for (i = 0; i < 3; i++) {
                    if (h.winAcross[i] == 2) {
                        for (j = 0; j < 3; j++) {
                            if (board[i][j] == 0) {
                                return (i * 3 + j);
                            }
                        }
                    }
                    if(h.winDown[i]==2){
                        if(isTaken(this.board,i)&&isTaken(this.board,i+3)){
                            return i+6;
                        }else if(isTaken(this.board,i+6)&&isTaken(this.board,i+3)){
                            return i;
                        }else if(isTaken(this.board,i+6)&&isTaken(this.board,i)){
                            return i+3;
                        }
                        
                    }
                }
        }

    


return -1;
    }
    public static boolean isTaken(int[][] b,int m){
         int win = 0, i, j, k = 0;
          for (i = 0; i < size; ++i) {
            for (j = 0; j < size; j++) {
                if(k==m&&b[i][j]!=0){
                    return true;
                }
            }
          }
          return false;
    }

   

}
