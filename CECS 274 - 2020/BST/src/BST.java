/**
 * create a binary search tree
 */
public class BST {
    /**
     * single node of a binary search tree,
     * contains the word data, and left and right nodes
     */
    private static class Node {

        //the word and its frequency
        private Word data;
        //go to left node
        private Node left;
        //go to right node
        private Node right;

        /**
         * pass in a word object to fill in for word data
         * @param d: the word object
         */
        public Node(Word d) {
            data = d;
            left = null;
            right = null;
        }

        /**
         * convert word object to string
         * @return: string version of data
         */
        public String toString() {
            return "" + data;
        }
    }

    //the root of the bst, the head
    private Node root;

    //create empty bst
    public BST() {
        root = null;
    }

    /**
     * check if the bst is empty
     * @return: true is bst is empty, false is bst is not empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * pass in a word to add into the bst
     * @param d: the word being added
     */
    public void add(Word d) {
        d.incFrequency();
        root = add(d, root);
    }

    /**
     * check whether the word is already in the tree, if it is do not add but increment frequency
     * @param d: the word being added
     * @param n: the node with the data we are comparing with
     * @return: the node added
     */
    private Node add(Word d, Node n) {
        if (n == null) {
            return new Node(d);
        } else {
            //d < n.data
            if (d.compareTo(n.data) == -1) {
                n.left = add(d, n.left);
                //d > n.data
            } else if(d.compareTo(n.data) == 1) {
                n.right = add(d, n.right);
            } else{
                //d == n.data, so increment frequency
                n.data.incFrequency();
            }
            return n;
        }
    }

    /**
     * check whether the word is already in the bst
     * @param d: the word we are comparing with
     * @return: recursion of contains with position of node to start comparing
     */
    //search the tree for a particular value
    public Word contains( Word d ){
        if( root == null ){
            return null;
        } else {
            return contains( d, root);
        }
    }

    /**
     * check whether the word is already in the bst
     * @param d: the word we are comparing with
     * @param n: the node we are comparing to
     * @return: the word object
     */
    private Word contains( Word d, Node n){
        if( d.equals(n.data)){
            d.incFrequency();
            return n.data;
        }
        //d < n.data
        if( d.compareTo(n.data) == -1){
            if( n.left == null){
                return null;
            } else {
                return contains( d, n.left );
            }
        } else {
            if (n.right == null){
                return null;
            } else {
                return contains( d, n.right );
            }
        }
    }

    /**
     * run through the bst in sorted order
     * @return: recursion of sorted method with position
     */
    //in-order (sorted order) traversal
    public String toSortedString(){
        return toSortedString(root);
    }

    /**
     * run through the bst in sorted order
     * @param n: the position to start running through the bst
     * @return: a string of the bst in sorted order
     */
    private String toSortedString( Node n ){
        String s = "";
        if(n != null){
            s += toSortedString(n.left);
            s += n.data + "";
            s += toSortedString(n.right);
        }
        return s;
    }

}