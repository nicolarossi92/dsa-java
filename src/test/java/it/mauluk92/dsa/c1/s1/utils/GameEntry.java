package it.mauluk92.dsa.c1.s1.utils;

/**
 * A game entry class to register score, together
 * with the name of the person earning this score
 */
public class GameEntry {
    private final String name;      // name of the person earning this score
    private final int score;        // the score value

    /* Constructs a game entry with given parameter */
    public GameEntry(String n, int s){
        name = n;
        score = s;
    }

    /* Returns the name field */
    public String getName(){
        return name;
    }
    /* Returns the score field */
    public int getScore(){
        return score;
    }
    /* Returns a string representation of this entry */
    @Override
    public String toString(){
        return "(%s, %s)".formatted(name, score);
    }
}
