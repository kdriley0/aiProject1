/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprj0000;

import static aiprj0000.GameBoard.size;
import java.util.ArrayList;

/**
 *
 * @author  Kevin Riley Spring 2018 for AI aka cosc 450  
 */
public class Ai {

    int movesTaken;
    int moves;
    //Player turn=new player()
static Ai g = new Ai();
    GameBoard gb = new GameBoard();
    int[] winAcross = new int[3];
    int[] winDown = new int[3];
    int[] winDi = new int[2];
    Player ai = new Player(-1);
    Player h = new Player(1); 
    int[][] board = new int[3][3];

    Ai() {
        movesTaken = 0;
    }

    public int getMovesTaken(int[][] b) {
        int m = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; j++) {
                if (b[i][j] != 0) {
                    
                    m++;
                    
                    
                }
            }
               
        }
        
        return m;
    }
    
    public State minVal(State state){
        State turn = new State(this.board,this.ai.symbol);
        return state;
    }
    public State maxVal(State state){
         State turn = new State(this.board,this.h.symbol);
        return turn;
    }

    /**
     * returns the possible moves
     *
     * @return
     */

    public ArrayList<Integer> findNextMoVeHelper() {
        ArrayList<Integer> avalMoves = new ArrayList<>();
        if (movesTaken < 1) {// exit condition 
            return null;
        }
        int moves = 0;//possibly
        for (int i = 0; i < 9; i++) {//loop though all 9 possibilities
            if (gb.move(i, ai.getPlayer())) {// move ia
                if (gb.hasWon(ai.getPlayer())) {//check if ai can win

                } else {// increase i and move player
                        
                }
            }
        }

        return avalMoves;
    }

    public int findNextMove() {
        int bestMove = -1;
        if (movesTaken < 1) {
            return -1;
        }
        moves++;
        int min=9;
        ArrayList<Integer> avalMoves = findNextMoVeHelper();
        for (int i = 0; i < avalMoves.size(); i++) {
            if(avalMoves.get(i)< min){
                bestMove=min;
            }
        }

        return bestMove;

    }

}
