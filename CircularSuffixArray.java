
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/*
 * Copyright (C) 2019 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class CircularSuffixArray {
    private final int length;
    private final Integer[] index;
    
    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new java.lang.IllegalArgumentException(
                    "Constructor cannot be null");
        }
        
        length = s.length();
        index = new Integer[length];
        
        // Initialize the suffix array with the index of the character
        // that should start this row of the suffix array.
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (Integer t, Integer t1) -> {
            for (int i = 0; i < length; i++) {
                // Entries in 'index' should be compared based on the character
                // in 's' to which they map, allowing wrap-around.
                char c = s.charAt((t + i) % length);
                char c1 = s.charAt((t1 + i) % length);
                
                // Break early if we encounter a different character
                if (c < c1) return -1;
                if (c > c1) return 1;
                // But if we don't encounter a different character,
                // move on to the next character in the shifted string.
            }
            // If we're here; the strings were the same.  
            // Break ties by comparing the actual indices themselves.
            return t.compareTo(t1);
        });
    }
    
    // length of s
    public int length() {
        return length;
    }
    
    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= length) {
            throw new java.lang.IllegalArgumentException(
                    "i must be in the range of [0,s.length())");
        }
        return index[i];
    }
    
    public static void main(String[] args) {
        String s = "BBBBABBBBB";
        CircularSuffixArray csa = new CircularSuffixArray(s);
        
        // should print (s.length())
        StdOut.println(csa.length());
        
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = csa.index(i);
            StdOut.println("Index of " + i + " is " + a[i]);
        }
    }
}
