
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
public class Radix {
    // Use a linked list to represent the 256 extended ASCII characters
    // in lexicographic order.
    //
    // This linked list supports O(n) search and removal, and
    // O(1) append-to-front operations.
    //
    // This makes it an excellent data structure for move-to-front encoding.
    public static LinkedList<Character> getAsciiLinkedList() {
        LinkedList<Character> ll = new LinkedList<>();
        for (char c = 0; c < 256; c++) {
            ll.add(c);
        }
        return ll;
    }
}
