/**
 * Tina L Vu
 * 04/20/2020
 * Modified version of LinkedStack class that uses Points instead of String
 * Credit to original LinkedStack Class goes to CECS 274 Class Notes on Beachboard
 */

import java.awt.Point;
public class LinkedStack {

    /**
     * node class
     */
    private static class Node {

        //instance variables

        //x,y coordinates
        private Point data;
        //the next node in a linked stack
        private Node next;

        //constructor

        /**
         * a node
         * @param d: x,y coordinates
         * @param n: a node
         */
        public Node( Point d, Node n ) {
            data = d;
            next = n;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    //instance variable
    //the node at the top of the linked stack
    private Node top;

    //constructor

    /**
     * given no param
     */
    public LinkedStack( ) {
        top = null;
    }

    /**
     * check whether the linked stack is empty or not
     * @return true if empty, false if not empty
     */
    public boolean isEmpty( ) {
        return top == null;
    }

    /**
     * add a new node to the top of the stack
     * @param s: a point containing x,y coordinates
     */
    public void push( Point s ) {
        top = new Node( s, top );
    }

    /**
     * remove a node from the top of the stack
     * @return: the node that was remove
     */
    public Point pop( ) {
        Point retVal = new Point();
        if( !isEmpty( ) ) {
            retVal = top.data;
            top = top.next;
        }
        return retVal;
    }

    /**
     * check the data of the top node without affecting the stack
     * @return: the data of the top node
     */
    public Point peek( ) {
        Point retVal = new Point();
        if( !isEmpty( ) ) {
            retVal = top.data;
        }
        return retVal;
    }

    /**
     * output linked stack
     * @return: the linked stack
     */
    public String toString( ) {
        String s = "";
        Node n = top;
        while( n != null ) {
            s = s + n.data + "";
            n = n.next;
        }
        return s;
    }

    /**
     * find out the size of the stack
     * @return: int value of the size of the stack
     */
    public int size( ) {
        int count = 0;
        Node n = top;
        while( n != null ) {
            count++;
            n = n.next;
        }
        return count;
    }
}
