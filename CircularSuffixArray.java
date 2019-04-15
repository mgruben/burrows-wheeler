
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SuffixArray;

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
    private final SuffixArray sa;
    
    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new java.lang.IllegalArgumentException(
                    "Constructor cannot be null");
        }
        sa = new SuffixArray(s);
    }
    
    // length of s
    public int length() {
        return sa.length();
    }
    
    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= sa.length()) {
            throw new java.lang.IllegalArgumentException(
                    "i must be in the range of [0,s.length())");
        }
        return sa.index(i);
    }
    
    public static void main(String[] args) {
        String s = "abracadabra!";
        CircularSuffixArray csa = new CircularSuffixArray(s);
        
        // should print 12
        StdOut.println(csa.length());
        
        int[] a = new int[12];
        for (int i = 0; i < s.length(); i++) {
            a[i] = csa.index(i);
            StdOut.println("Index of " + i + " is " + a[i]);
        }
        
    }
}
