# Movie Binary Search Tree :popcorn:
The program, written in java, reads in a text file with movies and creates a **binary search tree**. The program can search for movies with the exact title, traverse the tree in order, and search for movies beginning with specific characters. All functions were written **recursively**. The movies are inserted in the tree in lexicographic order by the short names of the movies.

## Instructions
Download `BSTIndex.java`, `IndexTester.java`, `MovieInfo.java`, and `data.zip` files. Unzip the `data.zip` file and it should contain many different files each containing a different number of movies and their information. To run, `IndexTester.java` takes command line arguments for file containing movie information (`$ java IndexTest.java data/filename.txt`).

### Example
```
$ java IndexTester.java data/movies100.txt
Index building complete. Inserted 99 records. Elapsed time = 0 seconds.

Welcome to the IMDB movie search engine!
- Enter search string to find a specific movie. 
- Enter search string ending with '*' to print all movies that match this prefix. 
- Enter 'h' to print tree height. 
- Enter 'q' to quit.
Enter Option: Plan 10 from Outer Space
100011 Plan 10 from Outer Space Plan 10 from Outer Space
Enter Option: Ta*
[Finding all movies that start with Ta..]
Tange Sazen: zankoku no kawa
Takekurabe
Tamaru onna
Enter Option: h
Height of BSTIndex tree = 19
Enter Option: q
```

## Breakdown
### Classes
- `BSTIndex.java`: BST class that contains an inner `node` with that takes a parameter of type `MovieInfo` and holds a movie's short-hand title in `key` and the rest of the movie information (see `MovieInfo.java`). The class contains public methods which call private methods where the implementation of the methods are.
  - `private int calcNodeHeight(Node t)`: recursively calculates the height of the tree, called by inputing `h` in the menu when prompted to `Enter Option: `
  - `private Node insertMovie(MovieInfo data, Node t)`: recursively determines a position to correctly insert the movie and its `data` into the binary search tree. Again, the movies are inserted in lexicographic order by the `shortTitle` of the movie. Called everytime a BST is created/`$ java IndexTester.java data/movies100.txt`.
  - `private MovieInfo findMovie(Node t, String key)`: recursively searches the tree for a movie with a matching `key` or movie `shortTitle`. Returns `null` if the `key` is not found in any of the nodes in the tree. This function is called by typing in a string into the menu when prompted to `Enter Option: `
  - `private void getMoviesPrefix(Node t, String prefix, ArrayList<String> movieList)`: recursively searches the tree for a movie `shortTitle` starting with `prefix` and adds `shortTitle` to an array list `movieList`. This function is called by typing in a string followed by a `*` into the menu when prompted to `Enter Option: `
  - `private void inorderTraversal(Node t, ArrayList<Integer> movieList)`: recursively traverses BST inorder.
- `IndexTester.java`: checks if command line argument for a `filename.txt` is passed or it throws an error, loads in `filename.txt` and inserts each line into a BST, and displays the menu in the console allowing for multiple selections.
- `MovieInfo.java`: `MovieInfo` class that stores a movie's `ID`, `shortTitle`, and `fullTitle`.

### Data
`data.zip` must be unzipped before using and contains text files that hold different amounts of movie data. These files can be used when calling `IndexTester.java data/filename.txt`. Each movie contains an `ID`, `shortTitle`, and `fullTitle` separated by spaces (`10	Ocean's 7-11 	Ocean's 7-11  (2008)`).

| Filename | # of movies |
| :------- | :---------- |
| movies.txt | 500,000 |
| movies1.txt | 1 |
| movies10.txt | 10 |
| movies100.txt | 100 |
| movies100k.txt | 100,000 |

## Challenges
This was my first time using BST and to do it recursively was definitely a challenge. Although I was initially pretty shakey on my recursion, after lots of practice problems online I was able to apply what I had learned to create recursive function.
