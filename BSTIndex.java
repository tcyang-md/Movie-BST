import java.util.ArrayList;

public class BSTIndex {

		private class Node {
			private String key;
			private MovieInfo data;
			private Node left, right;

			public Node(MovieInfo info) {
				data = info;
				key = data.shortTitle;
			}
		}

		private Node root;
		private int size;


		public BSTIndex() {
			root = null;
			size = 0;
		}

		// --------- [DO NOT MODIFY!] public BST methods  --------- //
		/* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

		/* Calculate and return the height of the current tree. */
		public int calcHeight(){
			return calcNodeHeight(this.root);
		}

		/* Insert the given data element into the proper place in the BST structure. */
		public void insertMovie(MovieInfo data) {
			size++;
			root = insertMovie(data, this.root);
		}

		/* Find and return the data element (i.e. the MovieInfo object)
		of the node where the movie's shortTitle matches the given key.
		Return null if the movie is not found. */
		public MovieInfo findMovie(String key) {
			return findMovie(this.root, key);
		}

		/* Traverse the tree in order based on the keys. The ArrayList
		returned should contain movie IDs based on the order of 
		the keys (i.e., shortTitle) in the tree. */
		public ArrayList<Integer> inorderTraversal() {
			ArrayList<Integer> movieList = new ArrayList<Integer>();
			inorderTraversal(this.root, movieList);
			return movieList;
		}

		/* Get all movies (full title) in the database whose shortTitle begins with
		the passed prefix string. If no movies match the given prefix, the 
		ArrayList should be empty. The order of the movies in the list does not matter,
		but make sure each movie is a separate element in the list. */
		public ArrayList<String> getMoviesPrefix(String prefix) {
			ArrayList<String> movieList = new ArrayList<String>();
			getMoviesPrefix(this.root, prefix, movieList);
			return movieList;
		}

		public int getSize() {
			return size;
		}


		// ----------------- end of public methods ------------------ //


		// ------------- [TODO] private BST methods --------------- //
		private int calcNodeHeight(Node t) {
			if(t == null) {
				return 0;
			}
			
			int leftside = calcNodeHeight(t.left);
			int rightside = calcNodeHeight(t.right);

			return Math.max(leftside, rightside) + 1;
		}

		private Node insertMovie(MovieInfo data, Node t) {
			// inserts after comparing lexigraphically
			if(t == null) {
				return new Node(data);
			}

			String current = t.data.shortTitle;
			String new_movie = data.shortTitle;
			int direction = current.compareTo(new_movie);
			if (direction != 0) {
				if(direction > 0) {
					t.left = insertMovie(data, t.left);
				}
				if (direction < 0) {
					t.right = insertMovie(data, t.right);
				}
			}

			return t;
		}

		private MovieInfo findMovie(Node t, String key) {
			MovieInfo answer = null;
			// -- base cases
			// got to bottom of the tree, didn't find the node containing the movie
			if (t == null) {
				return answer;
			}
			// found the movie
			if (key.equals(t.key)) {
				answer = t.data;
			}
			// -- keep looking
			else {
				MovieInfo left = findMovie(t.left, key);
				MovieInfo right = findMovie(t.right, key);
				if(left != null)
					answer = left;
				if(right != null)
					answer = right;
			}
			return answer;
		}

		private void getMoviesPrefix(Node t, String prefix, ArrayList<String> movieList) {
			prefix = prefix.split("\\*")[0];
			if (t == null) {
				return;
			}
			else {
				String title = t.key;
				// if we find a movie that starts with it add to the list
				if (title.startsWith(prefix)) {
					movieList.add(title);
				}
				// keep looking
				if(t.left != null)
					getMoviesPrefix(t.left, prefix, movieList);
				if(t.right != null)
					getMoviesPrefix(t.right, prefix, movieList);
			}

		}

		private void inorderTraversal(Node t, ArrayList<Integer> movieList) {
			if (t == null) {
				return;
			}
			else {
				// go left node
				if(t.left != null)
					 inorderTraversal(t.left, movieList);
				// go center
				movieList.add(t.data.ID);
				// go right node
				if(t.right != null)
					inorderTraversal(t.right, movieList);
			}

		}

}