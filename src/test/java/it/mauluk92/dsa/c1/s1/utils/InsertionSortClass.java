package it.mauluk92.dsa.c1.s1.utils;

/**
 * Example of sorting algorithm (Insertion Sort)
 */
public class InsertionSortClass {
    /* Insertion-sort of an array of characters into non-decreasing order */
    public static void insertionSort(char[] data) {
        int n = data.length;
        for(int k = 1; k< n; k++){             // begin with the second character
            char cur = data[k];                // time to insert cur = data[k]
            int j = k;                         // find correct index j for cur
            while(j > 0 && data[j-1] > cur){   // thus, data[j-1] must go after cur
                data[j] = data[j-1];           // slide data[j-1] rightward
                j--;                           // and consider previous j for cur
            }
            data[j] = cur;                     // proper place for cur
        }
    }
}
