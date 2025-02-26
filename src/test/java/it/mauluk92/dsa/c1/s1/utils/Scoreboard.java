package it.mauluk92.dsa.c1.s1.utils;

import java.util.Arrays;

/**
 * This class is used to represent a scoreboard in a virtual game
 * It contains a reference to an array of {@link GameEntry}
 * together with the number of actual entries
 */
public class Scoreboard {
    private int numEntries = 0;            // number of actual entries (non null)
    private final GameEntry[] board;       // array of game entries

    /* Constructs an empty scoreboard with the given capacity for storing entries */
    public Scoreboard(int capacity){
        board = new GameEntry[capacity];
    }
    /* Getting game entries in scoreboard */
    public GameEntry[] getBoard() {
        return board;
    }

    /* Attempting to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e){
        int newScore = e.getScore();
        // Is the new entry a really high score?
        if(numEntries < board.length || newScore > board[numEntries - 1].getScore()){
            if(numEntries < board.length){     // no score drops from the board
                numEntries++;                  // so overall number increases
            }
            // shift any lower scores rightward to make room for the new entry
            int j = numEntries - 1;
            while(j > 0 && board[j-1].getScore() < newScore){
                board[j] = board[j-1];          // shift entry from j-1 to j
                j--;                            // and decrement j
            }
            board[j] = e;                       // when done, add new entry
        }
    }

    /* Remove and returns the high score at index i */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= numEntries){
            throw new IndexOutOfBoundsException("Invalid index %s".formatted(i));
        }
        GameEntry temp = board[i];                // save the object to be removed
        for(int j = i; j < numEntries -1; j++){   // count up from i
            board[j] = board[j+1];                // move one cell to the left
        }
        board[numEntries -1] = null;              // null out the old last score
        numEntries--;                             // decrease the number of entries
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(board);
    }
}
