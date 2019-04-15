
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;
import java.util.HashMap;

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
public class BurrowsWheeler {
    // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
    public static void transform() {
        // Read the string to Burrows-Wheeler transform from standard input
        String inString = BinaryStdIn.readString();
        
        // Construct a CircularSuffixArray from the input string
        CircularSuffixArray csa = new CircularSuffixArray(inString);
        
        // Initialize pointers to help construct the correct Burrows-Wheeler response
        int index, first, prev;
        first = -1;
        StringBuilder sb = new StringBuilder();
        
        // Iterate over the rows in the sorted Circular Suffix Array
        for (int i=0; i < inString.length(); i++) {
            
            // Get this row's position in the unsorted Circular Suffix Array
            index = csa.index(i);
            
            // If the index is 0, record that we've located the index of the
            // original string in the sorted Circular Suffix Array.
            if (index == 0) first = i;
            
            // Get the index of the last character in this suffix array.  
            // Note that this is simply the character before the index,
            // wrapped if it would be negative.
            prev = index - 1;
            if (prev < 0) prev += inString.length();
            
            // Append the last character in this suffix array to our response.
            sb.append(inString.charAt(prev));
        }
        
        // Catch situations where we haven't actually found first yet
        if (first < 0) throw new java.lang.IllegalArgumentException("'first' is negative!");
        
        // Write the index of the original string in the sorted Circular Suffix
        // Array to standard out.
        BinaryStdOut.write(first);
        // Write the last column t[] from the sorted Circular Suffix Array
        // to standard out.
        BinaryStdOut.write(sb.toString());
        
        // BinaryStdOut requires clients either to flush or to close the bytestream.
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
    public static void inverseTransform() {
        // Read the index of the original string in the sorted t[] array.
        int first = BinaryStdIn.readInt();

        // Instantiate a Priority Queue to assist in sorting the characters in t[]
        MinPQ<Pair<Character, Integer>> q = new MinPQ();
        
        // Instantiate an array to use for counting character occurrences.  
        // Presume full 8-bit ASCII
        int[] r = new int[256];
        
        // Instantiate a counter to use for the rows of the t[] array
        int i = 0;
        
        // Instantiate a map from the particular character to the row in the
        // t[] array on which it occurred
        HashMap<Pair<Character, Integer>, Integer> m = new HashMap<>();
        
        while (! BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            Pair<Character, Integer> p = new Pair<>(c, r[c]);
            q.insert(p);
            r[c]++;
            m.put(p, i++);
        }
        
        i = 0;
        ArrayList<Pair<Character, Integer>> sorted = new ArrayList<>(q.size());
        while (! q.isEmpty()) { 
            sorted.add(i++, q.delMin());
        }
        
        int ptr = first;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < sorted.size()) { 
            Pair<Character, Integer> p = sorted.get(ptr);
            char c = p.getLeft();
            sb.append(c);
            ptr = m.get(p);
        }
        
        BinaryStdOut.write(sb.toString());
        BinaryStdOut.close();
        
    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if ("-".equals(args[0])) {
            BurrowsWheeler.transform();
        }
        else if ("+".equals(args[0])) {
            BurrowsWheeler.inverseTransform();
        }
    }
}
