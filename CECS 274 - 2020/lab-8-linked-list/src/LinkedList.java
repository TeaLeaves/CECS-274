/**
 * Tina L Vu
 * 04/13/2020
 * create a linked list or circle objects
 */
public class LinkedList {
    //NODE CLASS
    private static class Node {

        //instance variable
        private Circle data;
        private Node next;

        //constructor
        public Node( Circle c ) {
            data = c;
            next = null;
        }

        //overrride constructor
        public Node( Circle c, Node n ) {
            data = c;
            next = n;
        }

        //methods
        /**
         * @Override toString
         * @return node with circle
         */
        public String toString() {
            return "Node{" + "data=" + data + ", next=" + next + '}';
        }
    }


    //LINKED LIST CLASS

    //instance variable
    private Node first;
    private Node last;

    //constructor
    public LinkedList( ) {
        first = null;
        last = null;
    }

    //methods

    /**
     * check if a node is empty or occupied
     * @return true if node is empty and false if node is occupied
     */
    public boolean isEmpty( ) {
        return first == null;
    }

    /**
     * add a circle object into the linked list
     * @param c: the circle object that is being add into the linked list
     */
    public void add( Circle c ) {
        //if list is empty just add it
        if( first == null ) {
            first = new Node( c );
            last = first;
            //else add it to the end
        } else {
            Node n = new Node( c );
            last.next = n;
            last = n;
        }
    }

    /**
     * add a circle into a linked list at a specified position
     * @param i: position in linked list
     * @param c: circle object being added into linked list
     */
    public void add( int i, Circle c ){
        //check if the position exist in linked list
        if( i < 0 ){
            throw new IndexOutOfBoundsException();
        }
        //add circle object at the beginning of the linked list
        if( i == 0 ){
            first = new Node ( c, first);
            if( last == null ){
                last = first;
            }
        } else{
            Node n = first;
            //node is out of bound
            if( n == null ) {
                throw new IndexOutOfBoundsException();
            }
            //move cursor(first) to position we want to add node to
            for( int j = 1; j < i; j++){
                n = n.next;
                if( n == null ){
                    throw new IndexOutOfBoundsException();
                }
            }
            //add circle object at position wanted
            n.next = new Node( c, n.next );
            if( n.next.next == null ){
                last = n.next;
            }
        }
    }

    /**
     * remove the node at the position i
     * @param i: the position of the node to beb removed
     * @return: circle
     */
    public Circle remove( int i ) {
        Circle rem = new Circle();
        //check if out of bound
        if( first == null || i < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        //remove first node
        if( i == 0 ) {
            rem = first.data;
            first = first.next;
            if( first == null ){
                last = null;
            }
        } else {
            //find node at position i and remove
            Node n = first;
            for( int j = 1; j < i; j++ ) {
                n = n.next;
                if( n == null ) {
                    throw new IndexOutOfBoundsException();
                }
            }
            if( n.next == null ) {
                throw new IndexOutOfBoundsException();
            }
            rem = n.next.data;
            n.next = n.next.next;
            if(
                    n.next == null ) {
                last = n;
            }
        }
        return rem;
    }

    /**
     * check if node that contains the circle given had been removed yet
     * @param c: the given circle to remove
     * @return: true if the circle have been removed, false if didn't
     */
    public boolean remove( Circle c ) {
        if( first != null ) {
            if( c.equals( first.data ) ) {
                first = first.next;
                if( first == null ) {
                    last = null;
                }
                return true;
            } else {
                Node n = first;
                while(n.next!=null && !n.next.data.equals(c)){
                    n = n.next;
                }
                if( n.next != null ) {
                    n.next = n.next.next;
                    if( n.next == null ) {
                        last = n;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * get a circle object in a node at position i
     * @param i: position of node
     * @return circle in the node at position i
     */
    public Circle get( int i ) {
        //check if position is out of bound or not
        if( first == null || i < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        //go to node at position i
        Node n = first;
        for( int j = 0; j < i; j++) {
            //get the circle object of the node
            n = n.next;
            if( n == null ) {
                throw new IndexOutOfBoundsException();
            }
        }
        return n.data;
    }

    /**
     * changed circle object of node in given position,i, to given circle c
     * @param i: position of node
     * @param c: circle object of node
     */
    public void set( int i, Circle c ) {
        if( first == null || i < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for( int j = 0; j < i; j++ ) {
            n = n.next;
            if( n == null ) {
                throw new IndexOutOfBoundsException();
            }
        }
        n.data = c;
    }

    /**
     * find the size of the linked list
     * @return the size of the linked list
     */
    public int size( ) {
        int count = 0;
        Node n = first;
        while( n != null ) {
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * @Override toString
     * @return a string of linked list containing circle objects
     */
    public String toString( ) {
        String str = "";
        Node n = first;
        while( n != null ) {
            str = str + n.data;
            n = n.next;
        }
        return str;
    }
}
