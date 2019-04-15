# BurrowsWheeler
Binary compression based on the Burrows-Wheeler transform and Huffman encoding

### Introduction
The [Burrows-Wheeler transform](https://en.wikipedia.org/wiki/Burrows%E2%80%93Wheeler_transform) is a reversible process that (for, _inter alia_, English-language text input), tends to cluster the input characters together.

This transform, in combination with other transforms such as [move-to-front](https://en.wikipedia.org/wiki/Move-to-front_transform), allows for compression algorithms such as [Huffman coding](https://en.wikipedia.org/wiki/Huffman_coding) to achieve very good compression rates.  
Indeed, the open-source [bzip2](https://en.wikipedia.org/wiki/Bzip2) compression algorithm uses the Burrows-Wheeler transform, the move-to-front transform, and Huffman Encoding, along with several other techniques, to compress data.

### More Information
The extended problem statement for the `BurrowsWheeler` assignment can be found at Princeton's [Algorithms and Data Structures, Part II](http://coursera.cs.princeton.edu/algs4/assignments/burrows.html) website.

### Motivation
This project was completed for [Algorithms, Part II](https://www.coursera.org/learn/algorithms-part2).

If you're in that course or related course right now, obey all honor code requirements before viewing this code.  
I recommend that this code should only be viewed _after_ you've completed your own implementation.  
If you're super stuck, take a break, take a walk, and it will come to you; good luck.

