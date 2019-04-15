
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.LinkedList;

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
public class MoveToFront {
    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        // Initialize a LinkedList in lexicographic order to store
        // the moved-to-front state
        LinkedList<Character> ll = Radix.getAsciiLinkedList();
        
        // Iterate over each byte in the input stream
        int move_to_front_index;
        while (! BinaryStdIn.isEmpty()) {
            // Character is used because we expect 8 bytes.
            // During encoding, we expect that this Character represents
            // an ASCII character.
            Character ascii_character = BinaryStdIn.readChar();
            
            // Obtain the location of this character in our linked list,
            // then pop it and move it to the front.
            move_to_front_index = ll.indexOf(ascii_character);
            ll.remove(move_to_front_index);
            ll.addFirst(ascii_character);
            
            // Output the 8 least-significant bits of the character's
            // previous location in this linked list.
            BinaryStdOut.write(move_to_front_index, 8);
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        // Initialize a LinkedList in lexicographic order to store
        // the moved-to-front state
        LinkedList<Character> ll = Radix.getAsciiLinkedList();
        
        // Iterate over each byte in the input stream
        char ascii_character;
        while (! BinaryStdIn.isEmpty()) {
            // Character is used because we expect 8 bytes.
            // During decoding, we expect that this Character represents
            // a numerical index into the move-to-front index.
            Character move_to_front_index = BinaryStdIn.readChar();
            
            // Obtain the character at this location in our linked list,
            // then pop it and move it to the front.
            ascii_character = ll.remove((int) move_to_front_index);
            ll.addFirst(ascii_character);
            
            // Output the character that we just moved to the
            // front of the linked list
            BinaryStdOut.write(ascii_character);
        }
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args) {
        if ("-".equals(args[0])) {
            MoveToFront.encode();
        }
        else if ("+".equals(args[0])) {
            MoveToFront.decode();
        }
    }

}
