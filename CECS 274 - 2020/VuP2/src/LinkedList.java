/**
 * Tina L Vu
 * 04/27/2020
 * create a linked list and node class that uses Songs
 */
import java.util.ArrayList;

/**
 * LinkedList Class: contains linked nodes
 */
public class LinkedList {
    //NODE CLASS
    /**
     * Node Class: contains Song data and next indicator
     */
    private static class Node {

        //instance variable
        //Song object that contains title, artist, year, decade
        private Song data;
        //the next node
        private Node next;

        //constructor
        public Node( Song s ) {
            //data is now the given Song
            data = s;
            //next is at the end of the list
            next = null;
        }

        //overrride constructor
        public Node( Song s, Node n ) {
            //data is now the given Song
            data = s;
            //next is at the end of the list
            next = n;
        }

        //methods
        /**
         * @Override toString
         * @return node with Song
         */
        public String toString() {
            return "Node{" + "data=" + data + ", next=" + next + '}';
        }
    }


    //LINKED LIST CLASS

    //instance variable
    //first node
    private Node first;
    //last node
    private Node last;

    //constructor
    public LinkedList( ) {
        //empty linked list has first and last nodes at null
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
     * add a song object into the linked list
     * @param s: the song object that is being add into the linked list
     */
    public void add( Song s ) {
        //if list is empty just add it
        if( first == null ) {
            first = new Node( s );
            last = first;
            //else add it to the end
        } else {
            Node n = new Node( s );
            last.next = n;
            last = n;
        }
    }

    public int size(){
        int i = 0;
        Node n = first;

        if(n != null){
            i=1;
        }
        //continue until you search through entire list
        while (n.next != null) {
            i++;
            n = n.next;
        }
        return i;
    }

    /**
     * remove the first song node
     * @return: the song that was removed
     */
    public Song remove( ) {
        //save data of song that is being removed
        Song rem = first.data;
        //the next node is now first
        first = first.next;
        //if linked list is now empty
        if( first == null ){
            last = null;
        }
        //return that removed song data
        return rem;
    }

    /**
     * find the song
     * @param songTitle: title of the song
     * @param songArtist: singer of the song
     * @return: the song if it is in the list or null if it does not exist
     */
    public Song searchSong(String songTitle, String songArtist){
        //if linked list is not empty
        if( first != null ) {
            //if songTitle is equal to title
            if( songTitle.equals( first.data.getTitle() ) && songArtist.equals( first.data.getArtist()) ) {
                //next node is now first
                first = first.next;
                //if linked list is now empty
                if( first == null ) {
                    last = null;
                }
                //TODO
                System.out.println("THIS PRINTED");
                return first.data;
                //if not equal, continue searching
            } else {
                Node n = first;
                while(n.next!=null){
                    if(n.data.getTitle().equals(songTitle) && n.data.getArtist().equals(songArtist)){
                        return n.data;
                    }
                    n = n.next;
                }
                //if you searched through everything but the song title still does NOT show up
//                if( n.next != null ) {
//                    n.next = n.next.next;
//                    if( n.next == null ) {
//                        last = n;
//                    }
//                    System.out.println("SECOND RAN");
//                    return n.data;
//                }
            }
        }
        return null;
    }

    /**
     * print out a list of songs with the same singer
     * @param songArtist: the singer we are searching the songs to
     * @return: an array list of songs by the singer
     */
    public ArrayList<Song> searchArtist(String songArtist) {
        ArrayList<Song> song = new ArrayList<>();
        //if linked list is not empty
        if (first != null) {
            Node n = first;
            //continue until you search through entire list
            while (n.next != null) {
                //if it is the artist we are searching for
                if(n.data.getArtist().equals(songArtist)){
                    //add it to the array
                    song.add(n.data);
                }
                //go to the next node
                n = n.next;
            }
        }
        //return the array
        return song;
    }

    /**
     * print out a list of songs from the same decade
     * @param decade: the decade of the song ex: 80's = 1980-1989
     * @return: the array list of songs from the same decade
     */
    public ArrayList<Song> searchDecade(int decade){
        ArrayList<Song> song = new ArrayList<>();
        //if linked list is not empty
        if (first != null) {
            Node n = first;
            //continue until you search through entire list
            while (n.next != null) {
                //if input is 70's, 80's, 90's, etc.
                if(decade<100){
                    decade = decade + 1900;
                    if (decade <= n.data.getYear() && n.data.getYear() <= (decade + 9)) {
                        //add it to the array
                        song.add(n.data);
                    }
                    //go to the next node
                    n = n.next;
                    //if input is 1970s, 1980's, 1990's, etc.
                } else {
                    if (decade <= n.data.getYear() && n.data.getYear() <= (decade + 9)) {
                        //add it to the array
                        song.add(n.data);
                    }
                    //go to the next node
                    n = n.next;
                }
            }
        }
        //return the array
        return song;
    }

    /**
     * bubble sort the linked list from least to greatest in rating
     * if rating is the same then alphabetical order for artist
     * if artist is the same then alphabetical order for title
     */
    public void sort() {
        boolean swapped = false;
        do {
            swapped = false;
            //if linked list is not empty
            if (first != null) {
                Node n = first;
                //continue until you search through entire list
                while (n.next != null) {
                    //if first is greater than next
                    if (n.data.compareTo(n.next.data.getRating(), n.next.data.getArtist(), n.next.data.getTitle()) == 1) {
                        Song swap = n.data;
                        n.data = n.next.data;
                        n.next.data = swap;
                        swapped = true;
                    }
                    //go to next node
                    n = n.next;
                }
            }
        } while( swapped );
    }

    /**
     * display all of the songs in the array list
     * @param song: the array list of songs
     */
    public void display(ArrayList<Song> song){
        for(int i = 0; i<song.size(); i++){
            System.out.println(song.get(i));
        }
    }

    /**
     * display all of the songs in the linked list
     */
    public void display(){
        Node n = first;
        //continue until you search through entire list
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    /**
     * @Override toString
     * @return a string of linked list containing song objects
     */
    public String toString( ) {
        String str = "";
        Node n = first;
        while( n != null ) {
            str = str + n.data + "\n";
            n = n.next;
        }
        return str;
    }
}