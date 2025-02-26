package it.mauluk92.dsa.c1.s1;

import it.mauluk92.dsa.c1.s1.utils.GameEntry;
import it.mauluk92.dsa.c1.s1.utils.InsertionSortClass;
import it.mauluk92.dsa.c1.s1.utils.Scoreboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * We explore here a few applications of arrays - the concrete data structures
 * that access their entries using integer indices
 */
public class C1S1PracticalUseArrayTest {


    /**
     * <h1>Introducing GameEntry</h1>
     * <br/>
     * The first application we study is storing a sequence of high score
     * entries for a video game in an array. This is representative of
     * many applications in which a sequence of objects must be stored.
     * To begin, we consider what information to include in an object
     * representing a high score entry.
     * <br/>
     * <br/>
     * Obviously one component to include is an integer representation of the score itself,
     * which we identify as <strong>score</strong>. Another useful thing to include
     * is the name of the person earning this score, which we identify as
     * <strong>name</strong>. We, therefore, introduce the {@link GameEntry} class.
     * @see GameEntry
     */
    @Test
    @DisplayName("Introducing GameEntry class")
    public void introducingGameEntry(){
        GameEntry gameEntry = new GameEntry("Mario", 100);
        Assertions.assertInstanceOf(GameEntry.class, gameEntry);
        Assertions.assertEquals("Mario", gameEntry.getName());
        Assertions.assertEquals(100, gameEntry.getScore());
    }

    /**
     * <h1>Introducing Scoreboard class</h1>
     * <br/>
     * To maintain a sequence of high scores, we develop a class named
     * {@link Scoreboard}. A scoreboard is limited to a certain number of high scores
     * that can be saved; once that limit is reached, a new score only qualifies for
     * the scoreboard if it is strictly higher than the lowest "high score" on the board.
     * THe length of the desired scoreboard may depend on the game, perhaps 10, 50 or 500.
     * Since that limit may vary, we allow it to be specified as a parameter to our
     * Scoreboard constructor.
     * <br/>
     * <br/>
     * Internally, we will use an array named <strong>board</strong> to manage {@link GameEntry}
     * instances that represent the high scores. The array is allocated with the specified
     * maximum capacity, but all entries are initially null. As entries are added,
     * we will maintain them from highest to lowest score, starting at index 0.
     * @see Scoreboard
     */
    @Test
    @DisplayName("Introducing Scoreboard class")
    public void introducingScoreboard(){
        Scoreboard scoreboard = new Scoreboard(10);
        Assertions.assertInstanceOf(Scoreboard.class, scoreboard);
    }

    /**
     * <h1>Adding a new Entry</h1>
     * <br/>
     * One of the most common updates we want to make to a Scoreboard is to add a new
     * entry. Keep in mind that not every entry will necessarily qualify as a high score.
     * If the board is not yet full, any new entry will be retained. Once the board
     * is full, a new  entry is only retained if it's strictly better than one of the other
     * scores, in particular, the last entry of the scoreboard, which is the lowest of the
     * high scores.
     * <br/>
     * <br/>
     * When a new score is considered, the first goal is to determine whether it qualifies as high
     * score. This will be the case if the scoreboard is below in capacity, or if the new score
     * is strictly higher than the lowest score on the board.
     * Once it has been determined that a new entry should be kept, there are two remaining
     * tasks:
     * <ul>
     *     <li>properly update the number of entries</li>
     *     <li>place the new entry in the appropriate location, shifting entries with inferior scores as needed</li>
     * </ul>
     * See {@link Scoreboard} for an implementation of these tasks inside add() method!
     * @see Scoreboard
     */
    @Test
    @DisplayName("Adding a new entry")
    public void addingNewEntry(){
        Scoreboard scoreboard = new Scoreboard(3);
        GameEntry firstGameEntry = new GameEntry("First Gamer", 100);
        GameEntry secondGameEntry = new GameEntry("Second Gamer" , 10);
        GameEntry thirdGameEntry = new GameEntry("Third Gamer", 20);
        GameEntry fourthGameEntry = new GameEntry("Fourth Gamer", 30);

        // Adding fourth gamer
        scoreboard.add(fourthGameEntry);
        // At this point there is only one player and is actually the best
        Assertions.assertEquals("Fourth Gamer",scoreboard.getBoard()[0].getName());
        //Adding the third gamer. It will be the second gamer since fourth is better
        scoreboard.add(thirdGameEntry);
        // Third gamer is second in place
        Assertions.assertEquals("Third Gamer", scoreboard.getBoard()[1].getName());
        // Adding the second gamer, which will be the last
        scoreboard.add(secondGameEntry);
        // Last in position
        Assertions.assertEquals("Second Gamer", scoreboard.getBoard()[2].getName());
        // Adding the first Gamer
        scoreboard.add(firstGameEntry);
        // Everyone else is shifted down since this gamer is better than anyone else while second gamer is removed from board
        Assertions.assertEquals("First Gamer", scoreboard.getBoard()[0].getName());
        Assertions.assertEquals("Fourth Gamer",scoreboard.getBoard()[1].getName());
        Assertions.assertEquals("Third Gamer", scoreboard.getBoard()[2].getName());
        System.out.println(scoreboard);
    }

    /**
     * <h1>Removing an Entry</h1>
     * <br/>
     * Suppose some hot shot plays our video game and gets his or her name
     * on our high score list, but we later learn that cheating occurred. In
     * this case, we might want to have a method that lets us remove a game entry
     * from the list of high scores.
     * <br/>
     * <br/>
     * Therefore, let us consider how we might remove a reference
     * to a {@link GameEntry} object from a {@link Scoreboard}.
     * Our implementation for remove will involve a loop for shifting entries, much
     * like our algorithms for addition, but in reverse. To remove the reference of
     * the object at index i, we start at index i and move all the references at
     * indices higher than i once cell to the left.
     * @see Scoreboard
     */
    @Test
    @DisplayName("Removing an entry")
    public void removingAnEntry(){
        Scoreboard scoreboard = new Scoreboard(3);
        GameEntry firstGameEntry = new GameEntry("First Gamer", 100);
        GameEntry secondGameEntry = new GameEntry("Second Gamer" , 10);
        GameEntry thirdGameEntry = new GameEntry("Third Gamer", 20);

        // Adding all gamers

        scoreboard.add(firstGameEntry);
        scoreboard.add(secondGameEntry);
        scoreboard.add(thirdGameEntry);

        System.out.println(scoreboard); // Showing current ranking

        // Removing first player!

        GameEntry disqualified = scoreboard.remove(0);

        Assertions.assertEquals(firstGameEntry, disqualified);

        // Now everyone else is shifted up! While the last place is null
        Assertions.assertEquals("Third Gamer", scoreboard.getBoard()[0].getName());
        Assertions.assertEquals("Second Gamer", scoreboard.getBoard()[1].getName());
        Assertions.assertNull(scoreboard.getBoard()[2]);

        System.out.println(scoreboard);
    }

    /**
     * <h1>Sorting an array</h1>
     * <br/>
     * In the previous subsection, we considered an application for which we added
     * an object to an array at a given position while shifting other elements
     * so as long to keep the  previous order intact. In this section, use a similar
     * technique to solve the <strong>sorting</strong> problem, that is, starting
     * with an unordered array of elements and rearranging them into
     * non-decreasing order.<br/>
     * <br/>
     * We describe here a simple sorting algorithm, known as <strong>insertion sort</strong>.
     * The algorithm proceeds by considering one element at a time, placing
     * the element in the correct order relative to those before it.<br/>
     * <br/>
     * We start with the first element in the array, trivially sorted by itself.
     * When considering the next element in the array, if it is smaller than the first,
     * we swap them. Next we consider the third element in the array, swapping it leftward
     * until is in its proper order relative to the first two elements.
     * We continue in this manner with the fourth element, the fifth, and so on.
     * Let's have a description in pseudocode:
     * <br/>
     * <h2>Algorithm: InsertionSort(A)</h2>
     * <br/>
     * <strong>Input</strong>: An array A of <em>n</em> elements <br/>
     * <strong>Output</strong>: The array A with elements rearranged in non-decreasing order<br/>
     * <strong>for</strong> k from 1 to <em>n</em> -1 <strong>do</strong>:<br/>
     * &nbsp &nbsp Insert A[k] at its proper location within A[0], A[1], ..., A[k].<br/>
     * @see InsertionSortClass
     */
    @Test
    @DisplayName("InsertionSort")
    public void insertionSortTest(){
        char[] unorderedArray = new char[]{'a', 'h', 'b', 'c', 't'};
        char[] orderedArray = new char[]{'a','b','c', 'h', 't'};
        InsertionSortClass.insertionSort(unorderedArray);
        System.out.println(Arrays.toString(unorderedArray));
        Assertions.assertArrayEquals(unorderedArray, orderedArray);
    }
}
